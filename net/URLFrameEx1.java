package net;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class URLFrameEx1 extends MFrame implements ActionListener {

	TextArea ta;
	TextField tf;
	Button connect;
	Button save;
	URL url;

	public URLFrameEx1() {
		super(500, 500);
		setTitle("ViewHost");
		Panel p = new Panel();
		p.add(tf = new TextField("https://", 40));
		p.add(connect = new Button("connect"));
		p.add(save = new Button("save"));
		ta = new TextArea();
		add(p, BorderLayout.NORTH);
		add(ta);
		save.setEnabled(false);
		connect.addActionListener(this);
		save.addActionListener(this);
		tf.addActionListener(this);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == tf || obj == connect) {
			String host = tf.getText().trim();
			try {
				url = new URL(host);
			} catch (Exception e2) {
				new DialogBox(this, "해당되는 호스트는 없습니다", "오류");
				return; // 잘못된 URL일 경우 이후 실행 중단
			}
			ta.setText("");
			connectHost(url);
		} else if (obj == save) {
			createFile(url.getHost(), ta.getText());
			save.setEnabled(false);
			tf.setText("https://");
			ta.setText("");
			tf.requestFocus();
			new DialogBox(this, "저장하였습니다", "저장");
		}
	}

	// 서버접속 및 코드 ta 저장
	public void connectHost(URL url) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				ta.append(line + "\n");
			}
			save.setEnabled(true); // 성공적으로 읽어왔을 때 저장 버튼 활성화
		} catch (Exception e) {
			// e.printStackTrace();
			new DialogBox(this, "해당되는 호스트는 없습니다", "오류");
			save.setEnabled(false);
		}
	}

	// html 파일 저장
	public void createFile(String file, String content) {
		try {
			FileWriter fw = new FileWriter("net/" + file + ".html");
			fw.write(content); // content 변수로 수정
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		URLFrameEx1 ex = new URLFrameEx1();
	}
}