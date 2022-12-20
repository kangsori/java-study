package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		char[] result =str.toCharArray();
		
		for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
			result[j] = str.charAt(i);
        }
		
		return result; 
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		String str = new String(array);
		System.out.println(str);
	}
}