package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for(int i=1 ; i <40; i++) {
			String printinfo = "" ;
			String number = String.valueOf(i);
			
			int textlength =number.length();
			char[] arr = number.toCharArray();
			
			for(int j=0 ; j < textlength ; j++) {
				
				char num = arr[j];
				if(num=='3' || num=='6' || num=='9') {
					printinfo += "짝" ;
					System.out.println(number + " " + printinfo);
				}
				
			}
			printinfo = "" ;
		}
	}
}
