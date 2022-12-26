package prob01;

public class Printer {
//	//int형 오버로드
//	public void println(int i) {
//		System.out.println(i);
//	}
//	
//	//boolean형 오버로드
//	public void println(boolean i) {
//		System.out.println(i);
//	}
//	
//	//double형 오버로드
//	public void println(double i) {
//		System.out.println(i);
//	}
//	
//	//String형 오버로드
//	public void println(String i) {
//		System.out.println(i);
//	}
	
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	public int sum(Integer...nums) {
		int s = 0;
		for(Integer n:nums) {
			s += n ;
		}
		return s;
	}
	
	public <T> void println(T...ts) {
		for(T t:ts) {
			System.out.println(t);
		}
	}
	

}
