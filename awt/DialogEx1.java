package awt;

// AWT GUI 컴포넌트(레이아웃, 버튼, 대화상자, 프레임) 및 이벤트 관련 클래스 import
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 1. MFrame을 상속받고, 버튼 클릭 이벤트를 처리하기 위해 ActionListener 구현
public class DialogEx1 extends MFrame implements ActionListener {

	// 2. [멤버 변수 선언] 대화상자를 띄울 버튼과 대화상자 제목으로 사용할 문자열
	Button btn;                   // Dialog를 호출할 버튼
	String title = "메세지 대화상자"; // 커스텀 Dialog의 창 제목
	
	// 3. [생성자] 메인 메서드에서 객체 생성 시 화면 구성 및 이벤트 연결
	public DialogEx1() {
		super(300, 300);                                 // 부모 클래스(MFrame) 생성자 호출 (가로 300, 세로 300 크기 지정)
		setTitle("Dialog 예제");                          // 프레임 상단 타이틀 바 제목 설정
		add(btn = new Button("보이기"), BorderLayout.SOUTH); // "보이기" 버튼을 생성하여 프레임 하단(SOUTH)에 추가
		btn.addActionListener(this);                     // 버튼 클릭 시 현재 객체(this)의 actionPerformed가 실행되도록 이벤트 등록
		validate();                                      // 화면 레이아웃 재배치 및 확정
	}
	
	// 4. [이벤트 처리 메서드] "보이기" 버튼 클릭 시 실행
	@Override
	public void actionPerformed(ActionEvent e) {
		// 내부 클래스인 MyDialog 객체 생성 (부모 프레임 객체, 창 제목, 모달 여부)
		// boolean modal = true : 대화상자가 닫히기 전까지 부모 창을 제어하지 못하게 함
		MyDialog md = new MyDialog(this, title, true);
		
		md.setSize(150, 100);             // 커스텀 대화상자(Dialog)의 가로 150, 세로 100 크기 지정
		md.setLocationRelativeTo(this);   // 대화상자가 부모 프레임(this)의 중앙에 배치되도록 설정
		md.setVisible(true);              // 대화상자를 화면에 출력 (Modal 모드이므로 창을 닫을 때까지 여기서 블로킹/대기함)
		
		// System.out.println(getWidth() + " : " + getHeight()); // (주석 처리됨) 프레임 크기 확인용
		// System.out.println(getX() + " : " + getY());         // (주석 처리됨) 프레임 위치 좌표 확인용
	}
	
	// 5. [내부 클래스] 커스텀 대화상자(Dialog) 정의
	class MyDialog extends Dialog {
		
		Button b; // 대화상자 내부에 배치할 "확인" 버튼
		
		// MyDialog 생성자
		public MyDialog(Frame owner, String title, boolean modal) {
			super(owner, title, modal);    // 부모 클래스(Dialog) 생성자 호출
			setLayout(new FlowLayout());   // 대화상자의 레이아웃을 FlowLayout(순차적 배치)으로 지정
			
			b = new Button("확인");        // "확인" 버튼 생성
			
			// "확인" 버튼 클릭 시 실행될 무명 클래스 형태의 이벤트 리스너 등록
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();             // 현재 Dialog 창을 닫고 관련 리소스를 해제함
				}
			});
			
			add(b);                        // 대화상자(Dialog)에 "확인" 버튼 추가
		}
	}
	
	// 6. [시작점] 프로그램 실행 시 가장 먼저 호출되는 메인 메서드
	public static void main(String[] args) {
		new DialogEx1(); // DialogEx1 객체를 생성하면서 생성자 실행 (GUI 창 띄움)
	}
}