package awt;

// AWT GUI 배치 및 이벤트를 위한 클래스 import
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 1. MFrame을 상속받아 채팅 UI 프레임 클래스 정의
public class TextEx2 extends MFrame {

	// 2. [멤버 변수 선언] 채팅 메시지 출력창(ta), 입력창(tf), 전송 버튼(btn)
	TextArea ta;
	TextField tf;
	Button btn;
	
	// 3. [생성자] 메인 메서드에서 객체 생성 시 화면 구성 및 이벤트 연결
	public TextEx2() {
		super(260, 300);              // 부모 클래스(MFrame) 생성자 호출 (가로 260, 세로 300 지정)
		setTitle("MyChat v1.0");       // 프레임 상단 타이틀 바 제목 설정
		setLayout(new BorderLayout()); // 프레임의 레이아웃을 BorderLayout(동서남북중앙)으로 설정
		
		// 4. [중앙 영역] 메시지 출력용 TextArea 생성 및 화면 중앙(CENTER)에 추가
		add(ta = new TextArea());      // 위치를 지정하지 않으면 기본적으로 BorderLayout.CENTER에 배치됨
		ta.setEditable(false);         // 사용자가 출력창 텍스트를 직접 수정하지 못하도록 읽기 전용 설정
		
		// 5. MColor 클래스를 이용해 TextArea의 배경색과 글자색 무작위 지정
		Color c[] = MColor.rColor2();
		ta.setBackground(c[0]);        // 배경색 적용
		ta.setForeground(c[1]);        // 글자색 적용
		
		// 6. [하단 영역] TextField와 Button을 하나로 묶어줄 패널(Panel) 생성
		Panel p = new Panel();
		p.add(tf = new TextField(14)); // 입력창 생성 (버튼이 가려지지 않도록 크기를 22 -> 14로 조정)
		p.add(btn = new Button("SEND"));// "SEND" 버튼 생성 후 패널에 추가
		add(p, BorderLayout.SOUTH);    // 컴포넌트가 담긴 패널을 프레임 하단(SOUTH)에 배치
		
		// 7. [이벤트 처리 1] TextField에서 엔터키(Enter) 입력 시 실행될 리스너 등록
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = tf.getText().trim(); // 입력된 문자열을 가져오고 양쪽 공백 제거
				if(str.length() == 0) {
					str = "입력을 하세요";          // 아무것도 입력하지 않은 경우 출력할 기본 메시지
				}
				ta.append(str + "\n");             // TextArea에 입력한 문자열과 줄바꿈 문자 추가
				tf.setText("");                    // 입력 완료 후 TextField 내용 비우기
				tf.requestFocus();                 // 커서를 다시 TextField로 이동시켜 연속 입력 준비
			}
		});
		
		// 8. [이벤트 처리 2] "SEND" 버튼 클릭 시 실행될 리스너 등록 (tf 입력 이벤트와 동일한 동작)
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = tf.getText().trim(); // 입력창의 문자열을 가져옴
				if(str.length() == 0) {
					str = "입력을 하세요";          // 빈 문자열 체크
				}
				ta.append(str + "\n");             // TextArea에 추가
				tf.setText("");                    // 입력창 비우기
				tf.requestFocus();                 // 커서 다시 입력창으로 이동
			}
		});
		
		validate(); // 모든 컴포넌트 추가/변경 후 화면 배치를 확정하고 갱신
	}
	
	// 9. [시작점] 프로그램 실행 시 가장 먼저 호출되는 메인 메서드
	public static void main(String[] args) {
		new TextEx2(); // TextEx2 객체를 생성하면서 UI 창을 띄움
	}
}