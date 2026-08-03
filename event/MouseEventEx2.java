package event;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventEx2 extends MFrame{


	Button btn;
	public MouseEventEx2() {
		super(400, 500, new Color(100, 200, 100));
		setLayout(null);
		btn = new Button("move");
		btn.setBackground(MColor.rColor());
		btn.setBounds(200, 250, 50, 30);
		// 익명클래스로 MouseAdapter 이용
		// 버튼에 마우스가 들어오고 나가고 했을 때 Frame 랜덤 배경색 변경
		add(btn);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(MColor.rColor());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(MColor.rColor());
			}
		});
	}
	
	public static void main(String[] args) {
		new MouseEventEx2();
	}
}
