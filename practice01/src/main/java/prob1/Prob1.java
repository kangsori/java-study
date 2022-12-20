package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		
		//사용자 입력 부분
		Scanner scanner = new Scanner( System.in );
		
		/* 코드 작성 */
		System.out.println("수를 입력 하세요 : ");
		
		//입력받은 값을 정수로 변환
		int number = scanner.nextInt();
		
		//스캐너 닫기
		scanner.close();
		
		// 입력받은수를 3으로 나눈 나머지로 구분한다
		if(number%3==0) {
			System.out.println("3의 배수 입니다.");
		}else {
			System.out.println("3의 배수가 아닙니다.");
		}
	}
}
