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
import java.util.Base64;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket ;
	private List<Writer> listWriters;
	
	public ChatServerThread(Socket socket,List<Writer> listWriters) {
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
					doJoin(tokens[1],pw);
				}else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
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
	private void doJoin(String nickname, PrintWriter writer) {
		// nickname 저장
		this.nickname=nickname;
		
		//writer풀에 저장
		addWriter(writer);
		
		//메세지 출력
		String encodeingstr=ChatClient.encodeToString(nickname+"님이 입장하셨습니다.");
		broadcast("System "+encodeingstr);
		
	}
	
	//writer풀 저장 수행 메서드
	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}
	
	//writer풀을 이용한 메세지 전달을 수행하는 메서드
	private void broadcast(String data) {
		synchronized (listWriters) {
			for(Writer writer:listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
			}
		}
	}
	
	//메세지값 전달
	private void doMessage(String message) {
		broadcast(nickname+" "+message);
		
	}
	
	//소켓 종료 메서드
	private void doQuit(Writer writer) {
		//writer풀에 삭제
		removeWriter(writer);
		
		//종료 신호 보내기
		PrintWriter printWriter = (PrintWriter)writer;
		printWriter.println("stop ");
		
		String encodeingstr=ChatClient.encodeToString(nickname+"님이 퇴장하셨습니다.");
		broadcast("System "+encodeingstr);
	}
	
	//writer풀 삭제 수행 메서드
	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
		
	}
	
	

	
	
	
	
}
