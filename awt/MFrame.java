package awt; // awt 패키지 선언

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Font;

public class MFrame extends Frame { // Frame을 상속받는 MFrame 클래스 정의
	
	MFrame() { // 기본 생성자 (기본 크기 300x300, 연회색 배경)
		this(300, 300, new Color(220, 220, 220)); // 다른 생성자 호출
	}
	
	MFrame(int w, int h) { // 너비와 높이를 받는 생성자
		this(w, h, new Color(220, 220, 220)); // 다른 생성자 호출
	}
	
	MFrame(Color c) { // 배경색을 받는 생성자
		this(300, 300, c); // 다른 생성자 호출
	}
	
	MFrame(int w, int h, Color c) { // 너비, 높이, 배경색을 모두 받는 주 생성자

		setFont(new Font("Malgun Gothic", Font.PLAIN, 12)); // 기본 폰트 설정 (맑은 고딕, 보통, 12pt)
		setLayout(new FlowLayout()); // 레이아웃을 FlowLayout으로 설정 (순차적 배치)
		setTitle("제목"); // 창 제목 설정
		setSize(w, h); // 창 크기 설정 (너비, 높이)
		setBackground(c); // 배경색 설정
		setVisible(true); // 창을 화면에 표시
		addWindowListener(new WindowAdapter() {
		});
		addWindowListener(new WindowAdapter() { // 윈도우 이벤트 리스너 추가
			@Override
			public void windowClosing(WindowEvent e) { // 닫기 버튼(X) 클릭 시 호출
				System.exit(0); // 프로그램 종료
			}
		});
		validate(); // 레이아웃 재배치 및 화면 갱신
	}
	
	public static void main(String[] args) { // 메인 메서드 (프로그램 시작점)
		MFrame mf = new MFrame(Color.WHITE); // 초록색 배경의 MFrame 객체 생성
		MFrame mf2 = new MFrame();
		MFrame mf3 = new MFrame(300, 700);
	}
}