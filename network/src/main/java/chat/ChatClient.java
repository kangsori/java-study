package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
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
			while(true) {
				System.out.print("닉네임>>");
				String nickname = scanner.nextLine();
				
				if (!nickname.isEmpty()) {
					pw.println("join "+nickname);
					break;
				}
				
				System.out.println("닉네임은 한글자 이상 입력해야 합니다.");
				
			}
			
			//ChatClient
			new ChatClientThread(br).start();

			//키보드 입력 처리
			while(true) {
				String input = scanner.nextLine();
				
				//입력값이 없을때 처리
				if(input=="") {
					System.out.print("--내용을 입력해 주세요--");
					continue;
				}
				
				if("quit".equals(input)) {
					pw.println(input);
					break;
				}else{
					pw.println("message "+encodeToString(input));
				}
					
			}
			
		} catch (IOException e) {
			log("error - "+e);
		} finally {
			try {
				//자원정리
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				
				if(scanner != null) {
					scanner.close();
				}
				
			} catch (IOException e) {
				log("error - "+e);
			}
		}
	}
	
	//클라이언트 로그 출력
	public static void log(String message) {
		System.out.println("[ChatClient : "+ message + "]");
	}
	
	//인코딩 메서드
	public static String encodeToString(String str) {
		return new String(Base64.getEncoder().encode(str.getBytes(StandardCharsets.UTF_8)));
		 
	}
	
	//디코딩 메서드
	public static String decodeToString(String str) {
		return new String(Base64.getDecoder().decode(str),StandardCharsets.UTF_8);
		 
	}
}
