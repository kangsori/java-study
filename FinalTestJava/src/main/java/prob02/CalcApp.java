package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			//연산 입력 부분
			System.out.print( ">> " );
			String expression = scanner.nextLine();
			
			// 입력받은 값이 quit일 경우 기능 중지
			if( "quit".equals( expression ) ) {
				break;
			}
			
			// 입력받은 값을 공백 기준으로 자른다
			String[] tokens = expression.split( " " );
			
			// 입력받은 값이 3개가 아닐시 오류 출력 후 처음부터 재실행
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			// 첫번째 값, 두번째 값을 담는다
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 1 ] );
			
			// arithmetic null로 초기 설정
			Arithmetic arithmetic = null;
			
			/* 코드 작성 */
			// tokens[ 2 ] = 연산자로 구분하여 해당 객체 생성
			switch( tokens[ 2 ] ) {
				case "+" : {
					arithmetic = new Add();
					break;
				}
				case "-" : {
					arithmetic = new Sub();					
					break;
				}
				case "*" : {
					arithmetic = new Mul();
					break;					
				}
				case "/" : {
					arithmetic = new Div();
					break;
				}
			}
			
			// 만들어진 객체의 calculate() 메소드 수행
			int result = arithmetic.calculate(lValue, rValue);
			System.out.println( ">> " + result );
		}
		
		scanner.close();
	}
}