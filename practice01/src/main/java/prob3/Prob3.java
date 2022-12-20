package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		//사용자 입력 부분
		Scanner scanner = new Scanner(System.in);
		
		//스캐너 닫기
		scanner.close();
		
		//결과값 출력할 합계 변수 설정
		int total = 0;

		/* 코드 작성 */
		while(true) {
			
			System.out.println("숫자를 입력 하세요 : ");
			
			//입력받은 값을 정수로 변환
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
			
			// 합계값 초기화
			total = 0;
		}
		
	}
}
