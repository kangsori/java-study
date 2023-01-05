package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;

public class ChatClientThread extends Thread {
	protected BufferedReader br ;
	protected int count =3;
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
					print("["+ChatClient.decodeToString(tokens[1])+"]");
				}else {
					print(">>"+tokens[0]+":"+ChatClient.decodeToString(tokens[1]));
				}
			}
			
		}catch(SocketException e) {
			print("[suddenly closed by server - 3초후 연결이 끊깁니다]");
			countDown();
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
	
	public void countDown() {
		Timer m = new Timer();
		TimerTask t = new TimerTask() {
			
			public void run() {
				if(count >= 1) {
					print(String.valueOf(count));
				}else {
					m.cancel();
					count =3;
					System.exit(0);
				}
				count--;
			}
		};
		
		m.schedule(t,0,1000);

	}
	
	protected void print(String str) {
		System.out.println(str);
	}
	
}
