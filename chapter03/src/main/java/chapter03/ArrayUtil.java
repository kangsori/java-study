package chapter03;

public class ArrayUtil {

	public static double[] intToDouble(int[] is) {
		
		//파라미터로 전달받은 배열의 길이만큼 더블형 배열을 만든다
		double[] result = new double[is.length];

		for(int i=0 ; i <is.length ; i++) {
			result[i] =is[i];
		}
		return result;
	}

	public static int[] doubleToInt(double[] ds) {
		
		//파라미터로 전달받은 배열의 길이만큼 더블형 배열을 만든다
		int[] result = new int[ds.length];

		for(int i=0 ; i <ds.length ; i++) {
			result[i] =(int)ds[i];
		}
		return result;
	}

	public static int[] concat(int[] is, int[] is2) {
		int[] result = new int[is.length+is2.length];
		int index =0; 
		for(int i:is) {
			result[index++]=i;
		}
		
		for(int i:is2) {
			result[index++]=i;
		}
		return result;
	}

}
