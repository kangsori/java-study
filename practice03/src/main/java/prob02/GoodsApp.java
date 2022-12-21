package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		
		//사용자 입력 부분
		Scanner scanner = new Scanner(System.in);
		
		// COUNT_GOODS 만큼의 Goods배열 생성
		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i=0; i<COUNT_GOODS ; i++) {
			String info=scanner.nextLine();
			//공백 기준으로 나뉜 정보가 배열에 담김
			String[] infos=info.split(" ");
			//배열 순서대로 객체의 필드에 순차적으로 값을 입력
			goods[i]=new Goods(infos[0],Integer.parseInt(infos[1]),Integer.parseInt(infos[2])) ;
		}
		// 상품 출력
		for(int i=0; i<COUNT_GOODS ; i++) {
			//객체 순서대로 함수 호출
			goods[i].showInfo();
		}
		// 자원정리
		scanner.close();
	}
}
