package prob2;

public class Prob2 {
	public static void main(String[] args) {
		int number = 1 ;
		for(int i=0 ; i<9 ; i++) {
			for(int j=0 ; j<10 ; j++) {
				System.out.print(number+j +" ");
			}
			number += 1 ;
			System.out.println();
			
		}
	}
}
