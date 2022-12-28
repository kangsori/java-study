package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetaddress = InetAddress.getLocalHost();
			
			String hostname = inetaddress.getHostName();
			String hostIpAddress = inetaddress.getHostAddress();
			
			System.out.println(hostname);
			System.out.println(hostIpAddress);
			
			byte[] IpAddresses = inetaddress.getAddress();
			for(byte IpAddress : IpAddresses) {
				//System.out.print((int)IpAddress);
				System.out.print(IpAddress & 0x000000ff);
				System.out.print(".");
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
