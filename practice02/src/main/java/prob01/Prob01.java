package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		
		//사용자 입력 부분
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.println("금액 : ");
		int money = scanner.nextInt();
	
		//스캐너 닫기
		scanner.close();
		
		System.out.println("금액 : " +money );
		
		//MONEY 배열의 길이를 구한다
		int arrlength =MONEYS.length;
		
		//배열의 값을 순서대로 뽑아서 나누고 입력금액에서 제한다
		for(int i=0 ; i< arrlength ;i++) {
			int count = money / MONEYS[i] ;
			System.out.println(MONEYS[i] + "원 " +count +"개");
			money -= MONEYS[i]*count ;
		}
 	}
}