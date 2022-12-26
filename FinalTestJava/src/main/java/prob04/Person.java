package prob04;

public class Person {
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	/* 코드 작성 */
	
	// 나이는 12살, 이름은 공백으로 설정하는 기본생성자
	public Person() {
		this.age=12;
		this.name="";
		numberOfPerson += 1;
	}
	
	// 나이는 12살, 이름은 매개변수로 설정하는 기본생성자
	public Person(String name) {
		this.age=12;
		this.name=name;
		numberOfPerson += 1;
	}
	
	// age,name의 매개변수를 받는 생성자
	public Person(int age, String name) {
		this.age=age;
		this.name=name;
		numberOfPerson += 1;
	}
	
	// 정보출력하는 메소드
	public void selfIntroduce() {
		System.out.println("내 이름은 "+name+"이며, 나이는 "+age+"살 입니다.");
	}
	
	// 인구수 출력하는 메솓,
	public static int getPopulation() {
		return numberOfPerson;
	}
}
