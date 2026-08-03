package awt;

// AWT GUI 컴포넌트(레이아웃, 버튼, 라벨, 패널) 클래스 import
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;

// 1. MFrame을 상속받아 패널 배치 실습을 위한 프레임 클래스 정의
public class PanelEx1 extends MFrame {

	// 2. [멤버 변수 선언] 라벨 배열, 버튼 배열, 그리고 화면에 출력할 문자열 배열 생성
	Label label[] = new Label[3];                  // Label 3개를 담을 참조 변수 배열
	Button btn[] = new Button[3];                  // Button 3개를 담을 참조 변수 배열
	String str1[] = {"첫번째", "두번째", "세번째"}; // 라벨에 들어갈 텍스트
	String str2[] = {"Start", "Stop", "End"};       // 버튼에 들어갈 텍스트
	
	// 3. [생성자] 메인 메서드에서 객체 생성 시 컴포넌트를 배치하고 화면 구성
	public PanelEx1() {
		// 메인 프레임의 전체 레이아웃을 BorderLayout(동,서,남,북,중앙)으로 설정
		setLayout(new BorderLayout());
		
		// 컴포넌트들을 그룹으로 묶어줄 패널(Panel) 참조 변수 2개 선언
		Panel p1, p2;
		
		// 4. [상단 영역 패널(p1) 설정]
		p1 = new Panel();                          // 첫 번째 패널 객체 생성
		p1.setBackground(MColor.rColor());         // MColor 클래스를 통해 p1의 배경색을 무작위로 지정
		
		// 반복문을 사용하여 라벨 3개를 생성하고 p1 패널에 순서대로 추가
		for (int i = 0; i < label.length; i++) {
			// 라벨 생성(텍스트, 중앙정렬) 후 배열에 저장하고 패널 p1에 add
			p1.add(label[i] = new Label(str1[i], Label.CENTER));
		}
		
		// 5. [하단 영역 패널(p2) 설정]
		p2 = new Panel();                          // 두 번째 패널 객체 생성
		p2.setBackground(MColor.rColor());         // p2의 배경색을 무작위로 지정
		
		// 반복문을 사용하여 버튼 3개를 생성하고 p2 패널에 순서대로 추가
		for (int i = 0; i < btn.length; i++) {
			// 버튼 생성 후 배열에 저장하고 패널 p2에 add
			p2.add(btn[i] = new Button(str2[i]));
		}
		
		// 6. [프레임에 패널 배치]
		add(p1, BorderLayout.NORTH);               // 라벨들이 들어있는 p1 패널을 프레임 상단(NORTH)에 배치
		add(p2, BorderLayout.SOUTH);               // 버튼들이 들어있는 p2 패널을 프레임 하단(SOUTH)에 배치
		
		validate();                                // 모든 컴포넌트 추가 후 화면 레이아웃 재배치 및 갱신 확정
	}
	
	// 7. [시작점] 프로그램 실행 시 가장 먼저 호출되는 메인 메서드
	public static void main(String[] args) {
		new PanelEx1();                            // PanelEx1 객체를 생성하며 생성자 실행 (GUI 창 띄움)
	}
}