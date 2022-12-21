
package chapter03;


public class Goods {
	
	public static int countOfGoods =0;
	
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	//생성할때마다 countOfGoods 증가
	public Goods() {
		
		//외부에서 Goods.countOfGoods 처럼 객체를 앞에 명시해주어야함 , 같은 클래스에서는 생략가능
		countOfGoods = countOfGoods + 1 ;
	}
	
	public int calDiscountPrice(float discountRate) {
		return (int)(price*discountRate);
	}
	
	public void printInfo() {
		System.out.println(name + ":" + price + ":" + countStock + ":" + countSold);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		
		//금액이 마이너스가 되는것을 방지
		if(price < 0) {
			price = 0;
		}
		
		this.price = price;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	
	

}
