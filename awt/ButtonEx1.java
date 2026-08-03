package awt;

import java.awt.Button;
import java.awt.Color;

public class ButtonEx1 extends MFrame{

	// 생성자에서 선언 할 수도 있고? 필드에서도 선언할 수 있다.
	// 근데 컴포넌트는 필드에서 선언해야한다. 공유 목적때문에.
	Button  btn[] = new Button[4];
	String label[] = {"추가", "삭제", "전체삭제", "종료"};
	
	public ButtonEx1() {
		super(500,500);
		setTitle("Button 예제");
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(label[i]);
			Color c[] = MColor.rColor2();
			btn[i].setBackground(c[0]);
			btn[i].setForeground(c[1]);
			add(btn[i]);
		}
		validate();
	}
	public static void main(String[] args) {
		new ButtonEx1();
	}
}
