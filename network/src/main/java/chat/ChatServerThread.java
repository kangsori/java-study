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
		
		// Remote Host Information
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
				if(request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				}
				
				// 프로토콜 분석
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					//new String(Base64.getDecoder().decode(tokens[1]))
					doJoin(tokens[1],pw);
				}else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}else if("quit".equals(tokens[0])) {
					doQuit(pw);
					break;
				}else {
					ChatServer.log("에러 : 알 수 없는 요청 ("+tokens[0]+")");
				}
			}
		} catch (SocketException e) {
			System.out.println("[server] suddenly closed by client");
		} catch (IOException e) {
			ChatServer.log("error ["+e+"]");
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				ChatServer.log("error ["+e+"]");
			}
		}
		
	}
	
	private void doJoin(String nickname, PrintWriter writer) {
		this.nickname=nickname;
		
		addWriter(writer);
	
		broadcast(nickname+"님이 입장하셨습니다.");
	}
	
	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}
	
	private void broadcast(String data) {
		synchronized (listWriters) {
			for(Writer writer:listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
			}
		}
	}
	
	private void doMessage(String message) {
		broadcast(nickname+":"+message);
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickname + "님이 퇴장 하셨습니다.";
		
		broadcast(data);
	}
	
	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.remove(writer);
		}
		
	}

	
	
	
	
}
