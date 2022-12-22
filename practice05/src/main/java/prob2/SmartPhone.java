package prob2;

public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
		//앱이 아니면 MusicPhone의 execute 실행
		if(function.equals("앱")) {
			runApp();
			return;
		}
		super.execute(function);
	}
	
	@Override
	//MusicPhone의 execute가 실행되어도 Smartphone의 플레이 기능이 실행
	public void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}
	
	//앱 실행하는 메소드 정의 
	public void runApp() {
		System.out.println("앱실행");
	}
}
