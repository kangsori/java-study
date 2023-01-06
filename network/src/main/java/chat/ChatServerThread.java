package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private User user;
	private Socket socket ;
	private List<User> listWriters;
	
	public ChatServerThread(Socket socket,List<User> listWriters) {
		this.socket=socket;
		this.listWriters=listWriters;
	}

	@Override
	public void run() {
		
		// 호스트 접속 정보 출력
		InetSocketAddress inetRemoteSocketAddress =(InetSocketAddress)socket.getRemoteSocketAddress();
		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteport = inetRemoteSocketAddress.getPort();
		ChatServer.log("connected by client["+remoteHostAddress+":"+remoteport+"]");
		
		try {
			
			// 스트림 얻기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
			
			// 요청 처리
			while(true) {
				String request = br.readLine();
			
				// 프로토콜 분석
				String[] tokens = request.split(" ");
				
				if("join".equals(tokens[0])) {
					doJoin(new User(pw,ChatClient.decodeToString(tokens[1]),listWriters.size()==0 ?"Y":"N"));
				}else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}else if("userlist".equals(tokens[0])) {
					sendUserList(pw);
				}else if("quit".equals(tokens[0]) || request == null) {
					ChatServer.log("disconnected by client["+remoteHostAddress+":"+remoteport+"]");
					doQuit(pw);
					break;
				}else {
					ChatServer.log("에러 : 알 수 없는 요청 ("+tokens[0]+")");
				}
			}
			
		}catch (SocketException e) {
			ChatServer.log("suddenly closed by client");
			broadcast("System "+ChatClient.encodeToString(user.name+"님의 연결이 끊겼습니다."));
			removeWriter(this.user);
			if(getMaster().isEmpty()) {
				setMaster(listWriters.get(0).name);
			}
		} catch (IOException e) {
			ChatServer.log("error - "+e);
		} finally {
			try {
				//자원정리
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				ChatServer.log("error - "+e);
			}
		}
		
	}
	
	//join 프로토콜 실행 메서드
	private void doJoin(User user) {
		// nickname 저장
		this.user=user;
		
		//writer풀에 저장
		addWriter(this.user);
		
		PrintWriter printWriter = (PrintWriter)user.writer;
		printWriter.println("System "+ChatClient.encodeToString("Join:OK"));
		
		//메세지 출력
		String encodeingstr=ChatClient.encodeToString(this.user.name+"님이 입장하셨습니다.");
		broadcast("System "+encodeingstr);
		
		//유저리스트 갱신
		broadcast("UserListgui "+getUserList());
		
	}
	
	//writer풀 저장 수행 메서드
	private void addWriter(User writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}
	
	//writer풀을 이용한 메세지 전달을 수행하는 메서드
	private void broadcast(String data) {
		synchronized (listWriters) {
			for(User writer:listWriters) {
				PrintWriter printWriter = (PrintWriter)writer.writer;
				printWriter.println(data);
			}
		}
	}
	
	//메세지값 전달
	private void doMessage(String message) {
		broadcast(ChatClient.encodeToString(user.name)+" "+message);
	}
	
	//소켓 종료 메서드
	private void doQuit(Writer writer) {
		boolean ckMaster = user.name==getMaster();

		//종료 신호 보내기
		PrintWriter printWriter = (PrintWriter)writer;
		printWriter.println("stop ");
		
		//writer풀에 삭제
		removeWriter(this.user);
	
		//퇴장메세지 전달
		String encodeingstr=ChatClient.encodeToString(user.name+"님이 퇴장하셨습니다.");
		broadcast("System "+encodeingstr);
		
		//유저리스트 갱신
		broadcast("UserListgui "+getUserList());
		
		if(ckMaster && !listWriters.isEmpty()) {
			setMaster(listWriters.get(0).name);
		}
		
	}
	
	//writer풀 삭제 수행 메서드
	private void removeWriter(User writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
		
	}
	
	//유저리스트 보내는 메서드
	private void sendUserList(Writer writer) {
		PrintWriter printWriter = (PrintWriter)writer;
		printWriter.println("UserList "+getUserList());
	}
	
	//유저리스트 가져오는 메서드
	private String getUserList() {
		String list = "[채팅 유저 리스트]\n";
		for(int i=0 ; i<listWriters.size() ; i++) {
			list += listWriters.get(i).name;
			
			if(listWriters.get(i).master =="Y") {
				list += " - MASTER";
			}
			
			if (i !=(listWriters.size()-1)) {
				list += "\n";
			}
		}
		
		return ChatClient.encodeToString(list);
	
	}
	
	private String getMaster() {
		String master ="" ;
		for(int i=0 ; i<listWriters.size() ; i++) {
			if(listWriters.get(i).master == "Y") {	
				master=listWriters.get(i).name;
			}
		}
		return master;
	}
	
	private void setMaster(String name) {
		if(listWriters.isEmpty()) {
			return;
		}
		for(int i=0 ; i<listWriters.size() ; i++) {
			if(listWriters.get(i).name == name) {	
				listWriters.get(i).setMaster("Y") ;
				broadcast("System "+ChatClient.encodeToString(listWriters.get(i).name+"(으)로 방장이 변경되었습니다"));
				//유저리스트 갱신
				broadcast("UserListgui "+getUserList());
			}
		}
	}
	
}