package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 9999;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();
		
		try {
			// 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			// 바인딩
			serverSocket.bind( new InetSocketAddress( "0.0.0.0", PORT ) );
			
			// 요청대기
			while(true) {
				Socket socket = serverSocket.accept();
				
				new ChatServerThread(socket, listWriters).start();
			}
		} catch (IOException e) {
			ChatServer.log("error ["+e+"]");
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				ChatServer.log("error ["+e+"]");
			}
		}
					
	}
	
	public static void log(String message) {
		System.out.println("[ChatServer : "+ message + "]");
	}
	

}
