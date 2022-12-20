package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int total = 0;

		/* 코드 작성 */
		while(true) {
			System.out.println("숫자를 입력 하세요 : ");
			int number = scanner.nextInt();
			
			//짝수일때
			if(number%2==0) {
				for(int i=1 ; i<=number ; i++) {
					if(i%2==0) {
						total += i ;
					}
				}
			//홀수일때
			}else {
				for(int i=1 ; i<=number ; i++) {
					if(i%2!=0) {
						total += i ;
					}
				}
			}
			
			
			
			System.out.println("결과 값 : "+ total);
			total = 0;
		}
		
	}
}
