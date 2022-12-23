package prob5;

public class MyStack {
	private String[] buffer;
	private int index = 0;
	private int increaseNum = 5;
	
	//buffer배열의 길이를 설정하는 생성자
	public MyStack(int num) {
		buffer=new String[num];
	}

	//현재 index에 데이터를 넣고 인덱스 증가하는 push 메소드
	public void push(String string) {
		increaseArr();
		buffer[index]=string;
		index++;
	}
	
	//index를 하나 줄이고 데이터를 뽑아내는 pop 메소드
	public String pop() {
		--index;
		String result = buffer[index];
		return result;
	}

	//배열의 데이터 유무를 판단하는 isEmpty 메소드
	public boolean isEmpty() {
		return (index==0) ? true:false;
	}
	
	//배열의 길이를 체크하고 늘리는 메소드
	public void increaseArr() {
		if(index>=buffer.length) {
			String[] temp=new String[buffer.length+increaseNum];
			for(int i=0;i<buffer.length;i++) {
				temp[i]=buffer[i];
			}
			buffer=new String[temp.length];
			buffer=temp;
		}
	}
	
}