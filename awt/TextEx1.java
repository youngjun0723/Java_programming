package awt;

// AWT GUI 컴포넌트 및 이벤트 관련 클래스 import
import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 1. MFrame을 상속받고, 액션 이벤트(엔터키 입력 등)를 처리하기 위해 ActionListener를 구현
public class TextEx1 extends MFrame implements ActionListener {

	// 2. [멤버 변수 선언] 텍스트 입력창(TextField) 2개와 여러 줄 출력 창(TextArea) 선언
	TextField tf1, tf2; // tf1: 성명 입력용, tf2: 비밀번호 입력용
	TextArea ta;        // 결과 및 메시지를 출력할 영역
	
	
	
	// 3. [생성자] 메인 메서드에서 객체 생성 시 화면 구성 요소들을 생성 및 배치
	public TextEx1() {
		super(280, 300); // 부모 클래스(MFrame) 생성자 호출 (가로 280, 세로 300 크기 지정)
		
		// 4. '성명' 라벨과 텍스트필드 생성 및 프레임에 추가
		add(new Label("성명"));                     // "성명" 안내 문구 표시
		add(tf1 = new TextField("홍길동", 20));    // 기본값 "홍길동", 너비 20의 텍스트필드 생성 후 추가
		
		// 5. '비번' 라벨과 비밀번호용 텍스트필드 생성 및 설정
		add(new Label("비번"));                     // "비번" 안내 문구 표시
		add(tf2 = new TextField("", 20));           // 빈 문자열, 너비 20의 텍스트필드 생성 후 추가
		tf2.setEchoChar('$');                      // 비밀번호 보안을 위해 입력 문자를 '$'로 마스킹 처리
		tf2.addActionListener(this);               // tf2(비밀번호 입력창)에서 엔터키 입력 시 이벤트를 감지하도록 등록
		
		// 6. TextArea 생성 및 속성 설정
		add(ta = new TextArea(10, 30));            // 10행 30열 크기의 TextArea 생성 후 추가
		ta.append("myArea v1.0\n");                 // 초기 타이틀 문자열을 TextArea에 출력
		ta.setEditable(false);                      // 사용자가 직접 수정하지 못하도록 읽기 전용 설정
		// ta.setEnabled(false);                   // (주석 처리됨) 비활성화 시 스크롤도 안 되므로 보통 setEditable을 사용
		
		// 7. MColor 클래스를 활용한 배경색/글자색 임의 설정
		Color c[] = MColor.rColor2();               // 색상 배열 생성
		ta.setBackground(c[0]);                     // TextArea 배경색 설정
		ta.setForeground(c[1]);                     // TextArea 글자색 설정
		
		validate();                                 // 컴포넌트 재배치 및 화면 갱신 확정
	}
	
	
	
	
	// 8. [이벤트 처리 메서드] tf2(비밀번호 입력창)에서 엔터키를 치면 JVM이 자동으로 호출
	@Override
	public void actionPerformed(ActionEvent e) {
		// tf1(성명)과 tf2(비밀번호)의 입력값을 가져와 연결 (ex: "홍길동/1234\n")
		String str = tf1.getText() + "/" + tf2.getText() + "\n";
		
		ta.append(str);       // 가져온 문자열을 TextArea 기존 내용 뒤에 추가
		tf1.setText("");      // 성명 입력창 비우기
		tf2.setText("");      // 비밀번호 입력창 비우기
		tf1.requestFocus();   // 다음 입력을 위해 커서를 다시 성명 입력창(tf1)으로 이동
	}
	
	
	
	
	// 9. [시작점] 프로그램 실행 시 가장 먼저 호출되는 메인 메서드
	public static void main(String[] args) {
		new TextEx1(); // TextEx1 객체를 생성하며 생성자 실행 (GUI 창 띄움)
	}
}