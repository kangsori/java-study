package prob02;

public class Div implements Arithmetic {

	@Override
	public int calculate(int a, int b) {
		if(b==0) {
			return 0;
		}
		int result =(int)a / b;
		return result;
	}

}
