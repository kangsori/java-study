package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		//1-99만큼 돌린다
		for(int i=1 ; i <100; i++) {
			
			//짝을 담을 변수를 설정
			String printinfo = "" ;
			
			//숫자를 String으로 형변환
			String number = String.valueOf(i);
			
			//String으로 변환된 숫자의 길이를 구한다
			int textlength =number.length();
			
			//String으로 변환된 숫자를 배열로 만든다
			char[] arr = number.toCharArray();
			
			//배열안에 문자열을 하나씩 돌린다
			for(char j:arr) {
				
				//문자열에 3,6,9가 있으면 printinfo에 짝을 누적한다
				if(j=='3' || j=='6' || j=='9') {
					printinfo += "짝" ;
					System.out.println(number + " " + printinfo);
				}
				
			}
			
			//짝 변수 초기화
			printinfo = "" ;
		}
	}
}
