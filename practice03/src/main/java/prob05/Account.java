package prob05;

public class Account {
	
	private String accountNo;
	private int balance;
	

	//계좌번호 저장하는 생성자
	public Account(String accountNo) {
		this.accountNo=accountNo;
		System.out.println(this.accountNo+" 계좌가 개설되었습니다.");
	}

	//getter ,setter 함수
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금을 하는 save 메소드
	public void save(int in) {
		System.out.println(this.accountNo+" 계좌에 "+ in +"만원이 입금되었습니다.");
		this.balance += in ;
		
	}

	//출금을 하는 deposit 메소드
	public void deposit(int out) {
		System.out.println(this.accountNo+" 계좌에 "+ out +"만원이 출금되었습니다.");
		this.balance -= out ;
		
		
	}
	

}
