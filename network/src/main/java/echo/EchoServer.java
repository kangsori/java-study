package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT=8000;
	public static void main(String[] args) {
		
		
		
		ServerSocket serversocket = null;
		try {
			serversocket = new ServerSocket();
			
			serversocket.bind(new InetSocketAddress("0.0.0.0",PORT));
			log("starts...["+PORT+"]");
			
			Socket socket =serversocket.accept();  //blocking
			
			InetSocketAddress inetRemoteSocketAddress =(InetSocketAddress)socket.getRemoteSocketAddress();
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteport = inetRemoteSocketAddress.getPort();
			log("connected by client["+remoteHostAddress+":"+remoteport+"]");
			
			try {

				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
				while(true) {
					String data = br.readLine();
					//명시적인 종료일 경우만 data가 -1이거나 null이된다.
					if(data == null) {
						log("closed by client");
						break;
					}
					log("receved:"+data);
					pw.println(data);
				}
			}catch(SocketException ex) {
				System.out.println("[server] suddenly closed by client");
			}catch(IOException ex) {
				log("error : "+ex);
			
			}finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				}catch(IOException ex) {
					ex.printStackTrace();
				}
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
		System.out.println("[EchoServer] "+ message);
	}

}
