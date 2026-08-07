package net;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch06.ThisEx1;

public class ChatClient1 extends JFrame implements ActionListener, Runnable{
	
	JButton btn1, btn2;
	JTextField tf1, tf2;
	TextArea ta;
	JPanel p1, p2;
	BufferedReader in;
	PrintWriter out;
	String id;
	public static final int PORT = 8001;
	String host = "127.0.0.1";
	//String host = "113.198.238.123";//강사PC
	String swear[] = {"개새끼", "병신", "씨발", "엿먹어", "미친놈", "미친년"};
	
	public ChatClient1() {
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyChat v1.0");
		p1 = new JPanel();
		p1.setBackground(new Color(100,200,100));
		p1.add(new Label("HOST ",Label.CENTER));
		p1.add(tf1 = new JTextField(host, 15));
		p1.add(btn1 = new JButton("Connect"));
		
		p2 = new JPanel();
		p2.setBackground(new Color(100,200,100));
		p2.add(new Label("CHAT ",Label.CENTER));
		p2.add(tf2 = new JTextField("",15));
		p2.add(btn2 = new JButton("SEND"));	
		
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		add(p1,BorderLayout.NORTH);
		add(ta=new TextArea());
		add(p2,BorderLayout.SOUTH);
		setVisible(true);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==tf1||obj==btn1) {
			connect(tf1.getText().trim());
			tf1.setEnabled(false);
			btn1.setEnabled(false);
			tf2.requestFocus();
		}else if(obj==tf2||obj==btn2) {
			String str = tf2.getText().trim();
			if(str.isEmpty()) return;
			// 필터링
			/*if(filterMgr(str)) { //금지어가 있다면
				new DialogBox(this, "금지어입니다.", "경고");
				tf2.setText("");
				tf2.requestFocus();
				return; // 서버로 보내지 않고 메소드 빠져 나옴
			} else if (filterMgr2(str)) {
				new DialogBox(this, "금지업이니다.", "경고");
				tf2.setText("");
				tf2.requestFocus();
				return; // 서버로 보내지 않고 메소드 빠져 나옴
			}*/
			str = makeSwearWords(str);
			if(id == null) { // id값을 서버로 보냄(1번만 실행)
				id = str;
				setTitle(getTitle() + "-" + "[" + id + "]");
				ta.setText("Chat Start....\n");
			}
			out.println(str);
			tf2.setText("");
			tf2.requestFocus();
		}
	}//--actionPerformed
	
	//msg : 문장 ex) 야! 미친놈 집에서 궁상 떨지마~
	//msg : 너 진짜 개 새끼구나~(X)
	public boolean filterMgr(String msg) {
		for (String str : swear) {
			if(msg.contains(str)) {
				return true; // 욕설이 포함이 됨.
			}
		}
		return false;
	}
	
	// 정규 표현식(Regular Expression): 문자열 안에서 특정 규칙이나 패턴을 찾아내기 위한 식
	//[abc]: 'a', 'b', 'c' 중 하나
	// [a~z]: 알파벳 소문자 중 하나
	// [^0-9]: 숫자가 아닌 것
	// hint: msg에서 모든 공백 및 특수문자 제거 -> 비교
	public boolean filterMgr2(String msg) {
		// 한글, 영문, 숫자를 제외한 특수문자 및 공백 제거
		// 너 진짜 미 친 놈 이야?
		// 씨!발! 너무하네
		// 엿.먹.어.라
		String cleanStr = msg.replaceAll("[^a-zA-Z0-9가-힣]", "");
		for (String str : swear) {
				if(cleanStr.contains(str)) {
					return true; // 욕설이 포함이 됨.					
				}
		}
		return false;
	}
	
	public String makeSwearWords(String msg) {
		for (String str : swear) {
			if(msg.contains(str)) {
				// 욕설 길이에 맞게 * 생성(ex: 씨발 -> **)
				String mask = "*".repeat(str.length());
				msg = msg.replaceAll(str,mask);
			}
		}
		return msg;
	}
	
	@Override //서버로 부터 메세지가 들어오면 반응하는 기능
	public void run() {
		try {
			while(true) {
				ta.append(in.readLine()+"\n");
				tf2.requestFocus();
			}
		} catch (Exception e) {
			System.err.println("Error in run");
			System.exit(1);
		}
	}//--run
	
	public void connect(String host){
		try {
			 Socket sock = new Socket(host, PORT);
	         in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	         out = new PrintWriter(sock.getOutputStream(), true);
	         // 서버: "반갑습니다. 사용할 아이디를 입력하세요"
	         ta.append(in.readLine()+"\n");
	         tf2.requestFocus();
	         //Server 접속 성공 시 Thread 기능 start
	         new Thread(this).start();;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatClient1();
		new ChatClient1();
		new ChatClient1();
	}
}