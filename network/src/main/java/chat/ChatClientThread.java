package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.ClosedByInterruptException;
import java.util.Base64;

public class ChatClientThread extends Thread {
	private BufferedReader br ;
	

	public ChatClientThread(BufferedReader br) {
		this.br = br;
	}

	@Override
	public void run() {
		try {
			while(true) {
				// 받은 메세지 출력
				String response = br.readLine();
				
				String[] tokens = response.split(" ");
				
				if("stop".equals(tokens[0])) {
					break;
				}else if ("System".equals(tokens[0])){
					System.out.println(ChatClient.decodeToString(tokens[1]));
				}else {
					System.out.println(">>"+tokens[0]+":"+ChatClient.decodeToString(tokens[1]));
				}
			}
			
		}catch(SocketException e) {
			ChatClient.log("suddenly closed by server");
		}catch(IOException e) {
			ChatClient.log("error - "+e);
		}finally {
			try {
				//자원정리
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				ChatClient.log("error - "+e);
			}
		}
	
	}	
	
}
