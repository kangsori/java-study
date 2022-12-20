package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println(correctNumber);
			int count = 1 ;
			int min =1 ;
			int max =100 ;
				
			while(true) {
				System.out.println(min + "-" + max);
				System.out.print(count + ">>");
				int answer = scanner.nextInt();
				
				if(answer == correctNumber ) {
					System.out.println("맞았습니다.");
					break;
				}else if(answer > correctNumber) {
					System.out.println("더 낮게");
					max = answer ;
				}else {
					System.out.println("더 높게.");
					min = answer;
				}
				count += 1 ;
				
			}

			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
		}
		
		scanner.close();
	}

}