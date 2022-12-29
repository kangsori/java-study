package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {
	private Socket socket;
	public EchoRequestHandler(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
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
	}
		
	private void log(String message) {
		System.out.println("[EchoServer#"+getId()+"] "+ message);
	}

}
