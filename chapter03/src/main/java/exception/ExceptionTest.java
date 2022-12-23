package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("Some code1...");
		
		try {
			System.out.println("Some code2...: file open");
			System.out.println("Some code3...");
			
			int result=(1+2+3) / b ;
			
			System.out.println("Some code4...");
			System.out.println("Some code5...");
		}catch(ArithmeticException ex){
			/* 예외 처리 */
			// 1. 로깅
			System.out.println("error: "+ ex);
			
			// 2. 사과
			System.out.println("미안합니다...");
			
			// 3. 정상종료
			return;
			//System.exit(0);
			
			//ex.printStackTrace();
		}finally {
			//정상적일때도 예외일때도 무조건 실행된다 
			//주로 자원정리하는용도로 쓰인다
			System.out.println("자원 정리 예: file close...");
		}
		
		System.out.println("Some code6...");
		System.out.println("Some code7...");
		

	}

}
