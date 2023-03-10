package Collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("도우너");
		
		while(!s.empty()) {
			String str = s.pop();
			System.out.println(str);
		}
		
		// 비어 있는 경우에는 예외 발생
		//s.pop();
		
		s.push("둘리");
		s.push("마이콜");
		s.push("도우너");

		System.err.println(s.pop());
		System.out.println(s.peek());  // 맨위에 정보 확인 , 꺼내는것 아님
		System.out.println(s.pop());
	}

}
