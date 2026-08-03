package awt; // 패키지 선언: awt 패키지에 속한 클래스임을 명시

// 필요한 AWT GUI 및 이벤트 관련 라이브러리들 가져오기
import java.awt.Checkbox;       // 미사용 클래스 (체크박스)
import java.awt.CheckboxGroup;  // 미사용 클래스 (라디오 버튼용 그룹)
import java.awt.Color;          // 색상 지정 클래스
import java.awt.event.ItemEvent;    // 선택 항목 변경 이벤트 객체
import java.awt.event.ItemListener; // 선택 항목 변경 이벤트 감지 리스너 인터페이스
import java.util.Iterator;       // 미사용 클래스 (반복자)
import java.awt.Choice;         // 드롭다운 리스트(Choice) 컴포넌트
import java.awt.Graphics;       // 화면 그리기(텍스트, 도형 등)를 위한 그래픽 객체

// ChoiceEx3B 클래스 정의: MFrame을 상속받고, ItemListener를 구현함
public class ChoiceEx3 extends MFrame implements ItemListener {
    
    // Member Variables (멤버 변수 선언)
    String gender[] = {"남자연예인", "여자연예인"}; // 성별 선택 항목 데이터 배열
    String ms[] = {"현 빈", "원 빈", "이민호", "김수현", "김우빈", "이종석"}; // 남자 연예인 이름 배열
    String fs[] = {"고아라", "이연희", "이하늬", "문채원", "수 지", "김연아"}; // 여자 연예인 이름 배열
    Choice name, star; // 드롭다운(Choice) 객체를 담을 참조 변수 선언 (star: 성별, name: 연예인 이름)
    String str; // 멤버 변수로 선언했으나 내부 메서드에서 주로 지역변수로 재선언되어 사용됨

    
    
    // Constructor (생성자): 객체가 생성될 때 실행되어 화면과 컴포넌트를 초기화
    public ChoiceEx3() {
        super(300, 300, new Color(255, 255, 255)); // 부모 클래스(MFrame) 생성자 호출: 가로 300, 세로 300, 배경색 흰색 설정
        setTitle("Choice 예제3"); // 창 제목 설정

        star = new Choice(); // 성별 선택용 Choice 컴포넌트 생성
        for(int i = 0; i < gender.length; i++) { // gender 배열 크기만큼 반복
            star.add(gender[i]); // star Choice에 "남자연예인", "여자연예인" 항목 추가
        }
        star.addItemListener(this); // star 선택 변경 이벤트를 감지할 리스너 등록 (this = 현재 객체)

        name = new Choice(); // 이름 선택용 Choice 컴포넌트 생성
        
        // 현재 star에서 선택된 값에 따라 초기 name 드롭다운의 목록 설정
        if(star.getSelectedItem().equals("남자연예인")) 
            addName(ms); // "남자연예인"이 선택되어 있다면 ms 배열 데이터 추가
        else if(star.getSelectedItem().equals("여자연예인")) 
            addName(fs); // "여자연예인"이 선택되어 있다면 fs 배열 데이터 추가
            
        name.addItemListener(this); // name 선택 변경 이벤트를 감지할 리스너 등록

        add(star); // 프레임(화면)에 star Choice 컴포넌트 추가
        add(name); // 프레임(화면)에 name Choice 컴포넌트 추가
        validate(); // 컴포넌트 추가 후 프레임 레이아웃을 다시 재배치 및 갱신
    }

    
    
   
    // 사용자 정의 메서드: 전달받은 문자열 배열 데이터를 name Choice에 추가하는 역할
    public void addName(String[] name) { // 매개변수 name은 문자열 배열
        for(int i = 0; i < name.length; i++) { // 배열 길이만큼 반복
            this.name.add(name[i]); // ChoiceEx3B의 멤버 변수 name(Choice)에 이름 항목 추가
        }
    }
    
    
    
    
    // Paint 메서드: 화면을 새로 그려야 할 때(repaint 호출 시 등) 자동으로 실행됨
    @Override
    public void paint(Graphics g) {
        super.paint(g); // 부모 클래스(MFrame)의 paint 호출하여 기본 배경 등을 그림
        
        // 방어적 코드: 컴포넌트가 아직 생성되지 않았다면 그리지 않고 종료
        if(name == null || star == null) return; 

        g.setColor(Color.blue); // 그려질 텍스트 색상을 파란색으로 지정
        String str = "남/여 연예인선택 : " + star.getSelectedItem(); // star에서 현재 선택된 항목 텍스트 생성
        g.drawString(str, 30, 120); // (x: 30, y: 120) 좌표에 파란색 텍스트 출력

        g.setColor(Color.red); // 그려질 텍스트 색상을 빨간색으로 변경
        str = "이름 선택 : " + name.getSelectedItem(); // name에서 현재 선택된 항목 텍스트 생성
        g.drawString(str, 30, 140); // (x: 30, y: 140) 좌표에 빨간색 텍스트 출력
    }

    
    
    
    // Event Handler (이벤트 처리 메서드): Choice 항목을 바꿀 때마다 호출됨
    @Override
    public void itemStateChanged(ItemEvent e) {
        // 이벤트가 발생한 주체(소스)가 star(성별 Choice)인지 확인
        if(e.getSource() == star) {
            name.removeAll(); // 성별이 변경되었으므로 기존 name 목록의 모든 항목 제거
            
            // 변경된 star 선택값에 따라 name 목록을 새롭게 채움
            if(star.getSelectedItem().equals("남자연예인")) {
                addName(ms); // 남자 연예인 목록 추가
            } else if(star.getSelectedItem().equals("여자연예인")) {
                addName(fs); // 여자 연예인 목록 추가
            }
        }
        
        repaint(); // 선택이 변경되었으므로 paint()를 다시 호출하여 화면의 글자를 최신 상태로 갱신
    }
    
    
    
    
    // Main 메서드: 프로그램 실행 시작점
    public static void main(String[] args) {
        new ChoiceEx3(); // ChoiceEx3B 객체 생성 (생성자가 호출되면서 GUI 창이 뜸)
    }
}