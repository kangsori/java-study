package prob3;

public abstract class Bird {
	protected String name;
	
	//날다 추상메서드 선언
	public abstract void fly();
	
	//울다 추상메서드 선언
	public abstract void sing();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}