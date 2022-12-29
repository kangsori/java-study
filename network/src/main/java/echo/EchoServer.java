package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT=8000;
	public static void main(String[] args) {
		
		ServerSocket serversocket = null;
		
		try {
			serversocket = new ServerSocket();
			
			serversocket.bind(new InetSocketAddress("0.0.0.0",PORT));
			log("starts...["+PORT+"]");

			while(true) {
				Socket socket =serversocket.accept();  //blocking
				new EchoRequestHandler(socket).start();
			}
		}catch (IOException e) {
			log("error : "+e);
		}finally {
			try {
				if(serversocket != null && !serversocket.isClosed()) {
					serversocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private static void log(String message) {
		System.out.println("[EchoServer#"+Thread.currentThread().getId()+"] "+ message);
	}

}
