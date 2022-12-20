package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		
		//사용자 입력 부분
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		
		//입력받은 값을 문자열로 변환
		String text = scanner.nextLine();
		
		//입력받은 문자열의 길이를 구한다
		int textlength =text.length();
		
		//입력받은 문자열을 char배열로 만든다
		char[] arr = text.toCharArray();
   
		//스캐너 닫기
		scanner.close();
		
		//배열길이만큼 돌린다
		for(int i=0; i<textlength;i++) {
			
			//배열의순서만큼 문자열을 출력한다
			for(int j=0; j<=i;j++) {
				System.out.print(arr[j]);
			}
			
			//줄바꿈
			System.out.println();
		}
	}

}
