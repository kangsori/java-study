package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		String result = "" ;
		for(String atr:strArr) {
			result += atr;
		}
		return result;
	}
}
