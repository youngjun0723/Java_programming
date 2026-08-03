package awt;

import java.awt.Color;
import java.awt.Label;

public class LabelEx1 extends MFrame {

	// 글자 컴포넌트를 Label로 작성한다.
	Label label[];
	int pos[] = {Label.LEFT, Label.CENTER, Label.RIGHT, Label.LEFT};
	 
	 // 생성자는 객체를 실행할 때 !!한 번만!! 호출되는 아~주 특별한 메소드이다.
	 // 기본적인 초기화 설정이 필요.
	public LabelEx1() {
		//3개 이상이면 배열로 선언함.!!
		
		// Label 객체를 담을 수 있는 4개의 칸이 만들어 진 것이다!!!!! 절대 객체가 만들어진게 아니다.
		// 배열 사용 -> for문 사용하려고!! 국룰임.
		label = new Label[4];
		// label[0].setBackground(Color.black); // 당연히 객체생성이 아니기때문에 NullPointerException이 뜬다.
		
		String str = "오늘은 행복한 금요일~!";
		for (int i = 0; i < label.length; i++) {
			// 실제 Label 객체 생성
			label[i] = new Label(str, pos[i]);
			label[i].setBackground(MColor.rColor());
			// 현재 컨테이너 add <- Frame
			add(label[i]);
		}
		// 새로고침
		validate();
		
		
		
	}
	
	public static void main(String[] args) {
		new LabelEx1();
	}
}
