package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serversocket = null;
		try {
			//1. Server socket 생성
			serversocket = new ServerSocket();
			
			//2. 바인딩(binding)
			//	 Socket에 InetSocketaddress(IPAddress + Port)를 바인딩 한다.
			//	 IPAddress : 0.0.0.0 : 특정 호스트 IP에 바인딩 하지 않는다.
			serversocket.bind(new InetSocketAddress("0.0.0.0",5000));
			
			//3. accept
			Socket socket =serversocket.accept();  //blocking
			
			try {
				InetSocketAddress inetRemoteSocketAddress =(InetSocketAddress)socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remoteport = inetRemoteSocketAddress.getPort();
				System.out.println("[server] connected by client["+remoteHostAddress+":"+remoteport+"]");
			
				//4. IO Stream 받아오기
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();
			
				while(true) {
					//5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount=is.read(buffer); // blocking
					if(readByteCount==-1) {
						// 클라이언트가 정상적으로 종료(close() 호출)
						System.out.println("[server] closed by client");
						break;
					}
					String data = new String(buffer,0,readByteCount,"utf-8");
					System.out.println("[server] receved:"+data);
					
					//6. 데이터 쓰기
					os.write(data.getBytes("utf-8"));
				}
				
			}catch(IOException ex) {
				System.out.println("[server] error :"+ex);
			
			}finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				}catch(IOException ex) {
					ex.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			System.out.println("[server] error :"+e);
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

}
