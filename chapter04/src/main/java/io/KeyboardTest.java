package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			//1. 기반 스트림(표준입력, stdin, System.in)
		
			//2. 보조 스트림1(byte|byte|byte -> char )(InputTreamReader)
			InputStreamReader isr = new InputStreamReader(System.in,"utf-8");
			
			//3. 보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3cjar4")(BufferedReader)
			br = new BufferedReader(isr);
			
			//4. 처리
			String line = null;
			while((line = br.readLine()) != null) {
				if("quit".equals(line)) {
					break;
				}
				System.out.println(line);
			}
			
		} catch (IOException e) {
			System.out.println("Error :"+e);
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

}
