package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		//반환할 String 변수 선언
		String result = "" ;
		
		//배열의 값을 순서대로 접근해서 변수에 담는다
		for(String atr:strArr) {
			result += atr;
		}
		return result;
	}
}
