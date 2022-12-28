package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner( System.in  );
		
		while(true) {
			System.out.print(">> ");
			String line = scanner.nextLine();
			if("exit".equals(line)) {
				break;
			}
			getHostAddress(line);
		}
		
	}
	
	public static void getHostAddress(String str) {
		try {
		
			InetAddress[] inetAddresses =InetAddress.getAllByName(str);
			
			for(InetAddress IpAddress : inetAddresses) {
				System.out.println(str+":"+IpAddress.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
