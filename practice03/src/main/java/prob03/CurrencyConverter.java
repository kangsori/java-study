package prob03;

public class CurrencyConverter {
	private static double rate;

	public static void setRate(double d) {
		rate=d;
		
	}

	//달러로 만들기
	public static double toDollar(double d) {
		double result = d/rate;
		return result;
	}

	//원화로 만들기
	public static double toKRW(double d) {
		// 기준환율 * 외화액수
		double result = rate*d;
		return result;
	}
}
