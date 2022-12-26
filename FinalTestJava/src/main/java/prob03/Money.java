package prob03;

import java.util.Objects;

public class Money {

	private int amount;
	
	/* 코드 작성 */
	public Money(int amount) {
		this.amount=amount;
	}

	// 사칙 연산 메쏘드(add, minus, multiply, devide)
	public Money add(Money m) {
		int result=this.amount + m.getAmount();
		return new Money(result) ;
	}
	
	public Money minus(Money m) {
		int result=this.amount - m.getAmount();
		return new Money(result) ;
	}
	
	public Money multiply(Money m) {
		int result=this.amount * m.getAmount();
		return new Money(result) ;
	}
	
	public Money devide(Money m) {
		int result=(int)(this.amount / m.getAmount());
		return new Money(result) ;
	}
	
	// getter, setter 메소드
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {	
		// object의 타입만 확인하기 위해 객체 자체는 다른지 비교하지 않음
		//if (this == obj)
		//	return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return amount == other.amount;
	}
	
	

	
	
}
