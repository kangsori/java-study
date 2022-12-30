package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	Socket socket = null;
	BufferedReader br = null;
	
	public ChatClientThread(Socket socket,BufferedReader br) {
		this.socket=socket;
		this.br = br;
	}

	@Override
	public void run() {
		try {
			while(true) {
				String response = br.readLine();
				System.out.println(response);
			}
		} catch(SocketException ex) {
			//정상 종료하는데 여기로 들어온다...
			//System.out.println("[client] suddenly closed by server");
		}catch(IOException e) {
			ChatServer.log("error ["+e+"]");
		}finally {
			try {
				if(socket != null && !socket.isClosed())
				socket.close();
			} catch (IOException e) {
				ChatServer.log("error ["+e+"]");
			}
		}
	}

}
