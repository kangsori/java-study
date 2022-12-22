package prob05;

public class MyBase extends Base {
	
	@Override
	public void service(String state){
		//오후가 아닐때는 부모함수 재사용 , 오후일때는 afterNoon 함수 사용
		if(state!="오후") {
			super.service(state);
		}else {
			afterNoon();
		}
	}
	
	@Override
	public void day(){
		System.out.println("낮에는 열심히 일하자!");
	}
	
	
	public void afterNoon(){
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}
}
