package prob04;

public class Depart extends Employee {
	private String department;
	
	// name,salary,department를 매개변수로 받는 생성자 추가
	public Depart(String name,int salary,String department) {
		// 부모클래스 생성자 사용
		super(name,salary);
		this.department=department;
	}
	
	@Override
	public void getInformation() {
		System.out.println( "이름:" + getName() + " 연봉:" + getSalary() +" 부서:"+department );
	}
	

}
