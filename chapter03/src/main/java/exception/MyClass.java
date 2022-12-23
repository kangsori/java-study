package exception;

import java.io.IOException;

public class MyClass {
	// Exception이 발생할 수 있다는것을 강제함
	public void danger() throws IOException,MyException{
		System.out.println("Some code1...");
		System.out.println("Some code2...");
		
		if(3-3 == 0) {
			throw new MyException();
		}
		
		if(5-5 == 0) {
			throw new IOException();
		}
	
		System.out.println("Some code3...");
		System.out.println("Some code4...");
	}
}
