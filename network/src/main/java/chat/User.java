package chat;

import java.io.Writer;

public class User {
	Writer writer;
	String name;
	String master;
	
	public User (Writer writer,String name,String master) {
		this.writer = writer;
		this.name = name;
		this.master= master;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}
	
	
}