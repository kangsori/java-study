package prob03;

public class CurrencyConverter {
	//  static  변수 선언
	private static double rate;

	// rate값 적용하는 static 함수
	public static void setRate(double d) {
		//static이라서 this.rate 는 안됨
		rate=d;
	}

	//달러로 만들기
	public static double toDollar(double d) {
		return d/rate;
	}

	//원화로 만들기
	public static double toKRW(double d) {
		return rate*d;
	}
}
