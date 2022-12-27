package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");
			
			System.out.println("========== 파일정보 ==========");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified())));
			
			System.out.println("========== 전화번호 ==========");
			
			//1. 기반 스트림(FileInputStream)
			FileInputStream fis = new FileInputStream(file);
			
			//2. 보조 스트림1(byte|byte|byte -> char )(InputTreamReader)
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			
			//3. 보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3cjar4")(BufferedReader)
			br = new BufferedReader(isr);
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found :"+e);
		}catch (UnsupportedEncodingException e) {
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
