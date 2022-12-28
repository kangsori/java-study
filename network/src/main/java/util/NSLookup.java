package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		try {
			String line = "www.naver.com";
		
			InetAddress[] inetAddresses =InetAddress.getAllByName(line);
			
			for(InetAddress IpAddress : inetAddresses) {
				System.out.print(IpAddress.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
