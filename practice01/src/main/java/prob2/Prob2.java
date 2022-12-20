package prob2;

public class Prob2 {
	public static void main(String[] args) {
		
		//1-9까지 시작 숫자 지정하는 첫번째 for문
		for(int i=1 ; i<10 ; i++) {
			
			//시작숫자부터 10개까지 출력하는 두번째 for문
			for(int j=0 ; j<10 ; j++) {
				System.out.print(i+j +" ");
			}

			//줄바꿈
			System.out.println();
			
		}
	}
}
