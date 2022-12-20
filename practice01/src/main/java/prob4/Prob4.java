package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		
		int textlength =text.length();
		char[] arr = text.toCharArray();
		
		//System.out.println(arr);
   
		scanner.close();
		//System.out.println(textlength);
		for(int i=0; i<textlength;i++) {
			for(int j=0; j<=i;j++) {
				System.out.print(arr[j]);
			}
			System.out.println();
		}
	}

}
