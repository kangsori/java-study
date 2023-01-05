package chat.chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;


import chat.ChatClient;
import chat.ChatClientThread;

public class ChatWindow extends ChatClientThread {
	private String name;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private PrintWriter pw = null;
	
	public ChatWindow(String name,PrintWriter pw,BufferedReader br) {
		super(br);
		this.name=name;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.pw=pw;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
				
			}
		});
		
		buttonSend.addActionListener((e)-> {
			sendMessage();
		});

		// Textfield
		textField.setColumns(80);
		
		//엔터이벤트 실행
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode=e.getKeyChar();
				if(keyCode==KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		//쓰레드 실행
		start();
		updateTextArea("*****"+name+" 채팅방이 시작되었습니다 *****");
	}
	
	private void finish() {
		
		pw.println("quit");

		System.exit(0);
	}
	
	private void sendMessage() {
		String message = textField.getText();
		
		//입력값이 없을때 처리
		if(message.isEmpty()) {
			updateTextArea("--내용을 입력해 주세요--");
			return;
		}
		
		if("quit".equals(message)) {
			pw.println(message);
			finish();
			return;
		}else{
			pw.println("message "+ChatClient.encodeToString(message));
		}
		
		textField.setText("");
		textField.requestFocus();
		
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
		
	}

	@Override
	protected void print(String str) {
		updateTextArea(str);
	}
}
