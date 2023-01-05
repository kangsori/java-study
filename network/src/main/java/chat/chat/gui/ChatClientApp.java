package chat.chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatClient;
import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		String name = null;
		String nickname = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print("대화명>>");
			name = scanner.nextLine();
			
			if (!name.isEmpty()) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		while(true) {
			System.out.print("닉네임>>");
			nickname = scanner.nextLine();
			
			if (!nickname.isEmpty()) {
				break;
			}
			
			System.out.println("닉네임은 한글자 이상 입력해야 합니다.\n");
		}
		
		try {
			//1. create socekt
			socket = new Socket();

			//2. connect to server
			socket.connect(new InetSocketAddress(SERVER_IP,ChatServer.PORT));

			//3. get iostream
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));

			//4. join protocol 진행
			pw.println("join "+nickname);
			
			String response = br.readLine();

			String[] tokens = response.split(" ");
				
			if("System".equals(tokens[0])) {
				new ChatWindow(name,pw,br).show();
			}
			
			while(true) {
				if(socket.isClosed()) {
					break;
				}
			}
				
		} catch (IOException e) {
			ChatClient.log("error - "+e);
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
				ChatClient.log("error - "+e);
			}
		}
	
	}

}
