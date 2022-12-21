package tv;

public class TV {
	private int channel ;
	private int volume;
	private boolean power;
	
	//기본생성자 추가
	public TV() {
		
	}
	
	//값 셋팅하는 생성자 추가
	public TV(int channel, int volume, boolean power) {
		this.channel=channel;
		this.volume=volume;
		this.power=power;
		power(power);
		
	}

	public void power(boolean on) {
		if(!on) {
			this.channel=0;
			this.volume=0;
		}else {
			if(channel==0) {
				this.channel=1;
			}
		}
		this.power=on;	
	}
	
	public void channel(int channel) {
		this.channel=channel;
		ckChannel(channel);
	}
	
	public void channel(boolean up) {
		if(up) {
			this.channel += 1 ;
		}else {
			this.channel -= 1 ;
		}
		ckChannel(channel);
	}
	
	public void volume(int volume) {
		this.volume=volume;
		ckVolume(volume);
	}
	
	public void volume(boolean up) {
		if(up) {
			this.volume += 1 ;
		}else {
			this.volume -= 1 ;
		}
		ckVolume(volume);
	}
	
	//채널체크
	public void ckChannel(int number) {
		if(number<1) {
			this.channel=255 ;
		}else if(number>255 || number==0){
			this.channel=1 ;
		}
	}
	
	//볼륨체크
	public void ckVolume(int number) {
		if(number<1) {
			this.volume=1 ;
		}else if(number>100){
			this.volume=100 ;
		}
	}
	
	public void status() {
		System.out.println("TV[power="+ (power? "on" : "off") +", channel="+channel+", volume="+volume+"]");
	}
}
