package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



// [이벤트 리스너 클래스] 버튼 클릭 시 동작할 로직을 정의한 외부 클래스
class MyAction2 implements ActionListener {

	// 이벤트 발생 시 원본 프레임 및 버튼 제어를 위해 EventEx2 참조 변수를 선언
	EventEx2 f;
	
	
	// [실행 3-1순위] 생성자를 통해 EventEx2 객체의 주소값(this)을 넘겨받아 멤버 변수에 저장
	public MyAction2(EventEx2 f) {
		this.f = f;
	}
	
	
	// 기능: 버튼을 클릭하면 Frame의 배경색과 Button 배경색이 랜덤하게 세팅
	// [실행 5~6순위] 사용자가 버튼을 '클릭'했을 때 자바(AWT)에 의해 자동으로 실행되는 이벤트 메서드
	@Override
	public void actionPerformed(ActionEvent e) { // 버튼을 눌렀을 때 수행되어지는 내용들 작성하는 란
		// 5순위: 전달받은 프레임(f)의 배경색을 랜덤 색상으로 변경
		f.setBackground(MColor.rColor());
		// 6순위: 프레임(f) 안에 있는 버튼(btn)의 배경색을 랜덤 색상으로 변경
		f.btn.setBackground(MColor.rColor());
	}
}




public class EventEx2 extends MFrame {
	
	// 프레임에 올려놓을 버튼 멤버 변수 선언
	Button btn;
	
	// [실행 2순위] 생성자: UI 컴포넌트 생성 및 이벤트 리스너 연결
	public EventEx2() {
		// 2순위: "버튼2" 버튼 객체를 생성하여 프레임의 남쪽(BorderLayout.SOUTH)에 추가
		add(btn = new Button("버튼2"), BorderLayout.SOUTH);
		
		// 3순위: 이벤트 처리를 위해 자기 자신(this)의 주소를 넘기며 MyAction 객체 생성
		MyAction2 ma = new MyAction2(this);
		
		// 4순위: 버튼에 액션 리스너(이벤트 연결고리)를 등록함
		btn.addActionListener(ma);
	}
	
	
	
	// [실행 1순위] 프로그램의 진입점
	public static void main(String[] args) {
		// 1순위: EventEx2 객체를 생성 (생성자 호출)
		new EventEx2();
	}

}