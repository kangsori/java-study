package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.println("금액 : ");
		int money = scanner.nextInt();
	
		scanner.close();
		System.out.println("금액 : " +money );
		int arrlength =MONEYS.length;
		
		for(int i=0 ; i< arrlength ;i++) {
			int count = money / MONEYS[i] ;
			System.out.println(MONEYS[i] + "원 " +count +"개");
			money -= MONEYS[i]*count ;
		}
 	}
}