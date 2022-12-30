package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			// 키보드 연결
			scanner = new Scanner(System.in);
		
			// socket 생성
			socket = new Socket();
		
			// 연결
			socket.connect(new InetSocketAddress(SERVER_IP,ChatServer.PORT));
			//ChatServer.log("conneted");
			
			// reader /writer 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
			// join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:"+nickname);
			
			//ChatClinet
			new ChatClientThread(socket,br).start();
			
			//키보드 입력 처리
			while(true) {
				String input = scanner.nextLine();
				
				if("quit".equals(input)) {
					pw.println("quit:");
					break;
				}else {
					//input=Base64.getEncoder().encodeToString(input.getBytes());
					pw.println("message:"+input);
				}
			}
		} catch(SocketException ex) {
			System.out.println("[client] suddenly closed by server");
		}catch (IOException e) {
			ChatServer.log("error ["+e+"]");
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			
			} catch (IOException e) {
				ChatServer.log("error ["+e+"]");
			}
		}
	}
}
