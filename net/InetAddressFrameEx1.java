package net;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class InetAddressFrameEx1 extends MFrame 
implements ActionListener{
	
	TextField tf;
	TextArea ta;
	Button lookup;
	InetAddress intAddr;
	
	public InetAddressFrameEx1() {
		setTitle("InetAddress Example");
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		p.add(new Label("호스트이름"),BorderLayout.NORTH);
		p.add(tf = new TextField("",40));
		p.add(lookup = new Button("호스트 정보 얻기"), BorderLayout.SOUTH);
		tf.addActionListener(this);
		lookup.addActionListener(this);
		add(p,BorderLayout.NORTH);
		ta = new TextArea("인터넷주소\n");
		ta.setFont(new Font("Dialog",Font.BOLD,15));
		ta.setForeground(Color.BLUE);
		ta.setEditable(false);
		add(ta);
		validate();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트 발생 객체 확인 (TextField 입력 엔터 또는 버튼 클릭)
		if (e.getSource() == tf || e.getSource() == lookup) {
			String host = tf.getText().trim();
			
			if (host.isEmpty()) {
				ta.setText("인터넷주소\n호스트 이름을 입력하세요.");
				return;
			}
			try {
				// 1. 단일 대표 IP 주소 조회
				intAddr = InetAddress.getByName(host);
				
				StringBuilder sb = new StringBuilder("인터넷주소\n");
				sb.append("호스트 이름: ").append(intAddr.getHostName()).append("\n");
				sb.append("IP 주소: ").append(intAddr.getHostAddress()).append("\n\n");
				
				// 2. 해당 도메인에 연결된 모든 IP 주소 조회
				sb.append("--- [모든 IP 주소 목록] ---\n");
				InetAddress[] addrs = InetAddress.getAllByName(host);
				for (InetAddress addr : addrs) {
					sb.append(addr.getHostAddress()).append("\n");
				}
				
				ta.setText(sb.toString());
				
			} catch (UnknownHostException ex) {
				ta.setText("인터넷주소\n해당 호스트를 찾을 수 없습니다: " + host);
			}
		}
	}
	
	public static void main(String[] args) {
		new InetAddressFrameEx1();
	}
}




























