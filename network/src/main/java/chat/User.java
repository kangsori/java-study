package chat;

import java.io.Writer;

public class User {
	Writer writer;
	String name;
	
	public User (Writer writer,String name) {
		this.writer = writer;
		this.name = name;
	}
}
