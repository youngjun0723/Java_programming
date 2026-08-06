package net;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class InetAddressFrameEx2 extends MFrame 
implements ActionListener{
	
	JTextField tf;
	JTextPane ta;              // TextArea -> JTextPane 으로 교체
	StyledDocument doc;
	JButton lookup;
	InetAddress intAddr;
	
	public InetAddressFrameEx2() {
		setTitle("InetAddress Example");
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(new JLabel("호스트이름"),BorderLayout.NORTH);
		p.add(tf = new JTextField("",40));
		p.add(lookup = new JButton("호스트 정보 얻기"), BorderLayout.SOUTH);
		tf.addActionListener(this);
		lookup.addActionListener(this);
		add(p,BorderLayout.NORTH);
		
		ta = new JTextPane();
		ta.setFont(new Font("Dialog",Font.BOLD,15));
		ta.setForeground(Color.BLUE);   // 기본(정상 결과) 색상
		ta.setEditable(false);
		doc = ta.getStyledDocument();
		appendText("인터넷주소\n", Color.BLUE);
		
		add(new JScrollPane(ta));  // TextArea는 자체 스크롤 지원, JTextPane은 JScrollPane 필요
		validate();
	}
	
	// 색상을 지정해서 텍스트를 append 하는 헬퍼 메서드
	private void appendText(String text, Color color) {
		SimpleAttributeSet attr = new SimpleAttributeSet();
		StyleConstants.setForeground(attr, color);
		try {
			doc.insertString(doc.getLength(), text, attr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==lookup||obj==tf) {
			String host = tf.getText().trim();
			if(host.equals("cls")) {
				tf.setText("");
				ta.setText("");
				tf.requestFocus();
				return;
			}
			try {
				intAddr = InetAddress.getByName(host);
				String add =  intAddr.getHostName();
				String ip = intAddr.getHostAddress();
				appendText(" " + add + "\n", Color.BLUE);
				appendText(" " + ip + "\n", Color.BLUE);
			} catch (Exception e2) {
				appendText(" [" + host + "]\n", Color.RED);
				appendText("해당되는 호스트가 없습니다\n", Color.RED);
			}
			tf.setText("");
			tf.requestFocus();
		}
	}
	
	public static void main(String[] args) {
		new InetAddressFrameEx2();
	}
}