package awt;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator; // 현재 코드 내에서는 사용되지 않는 불필요한 import입니다.

// 1. Frame을 상속받은 사용자 정의 MFrame과 선택 상태 변경을 감지하는 ItemListener를 구현
public class CheckboxEx1 extends MFrame implements ItemListener {

    // 2. [멤버 변수 선언] 체크박스와 라디오버튼을 담을 배열 및 그룹 객체 선언
    Checkbox cb[] = new Checkbox[3];   // 일반 체크박스 3개를 저장할 배열
    Checkbox rb[] = new Checkbox[3];   // 라디오버튼 역할의 체크박스 3개를 저장할 배열
    CheckboxGroup grp;                 // 라디오버튼들을 하나로 묶어줄 그룹 객체
    
    // 화면에 표시할 라벨(텍스트) 문자열 배열
    String label1[] = {"선택1", "선택2", "선택3"};
    String label2[] = {"라디오1", "라디오2", "라디오3"};
    
    // 3. [생성자] 메인 메서드에서 객체 생성 시 화면 구성 요소들을 배치 및 초기화
    public CheckboxEx1() {
        super(420, 120);              // 부모 클래스(MFrame)의 생성자 호출 (가로 420, 세로 120 크기 지정)
        setTitle("Checkbox 예제1");    // 프레임 상단 타이틀바 제목 설정
        
        // 4. [반복문 1] 일반 체크박스 3개 생성 및 이벤트 등록
        for (int i = 0; i < cb.length; i++) {
            cb[i] = new Checkbox(label1[i], true); // 라벨명을 설정하고, 기본 상태를 선택됨(true)으로 생성
            cb[i].addItemListener(this);           // 현재 클래스(ItemListener)를 이벤트 감지자로 등록
            add(cb[i]);                            // 프레임(화면)에 체크박스 추가
        }
        
        // 5. [반복문 2] 라디오버튼용 체크박스 생성
        grp = new CheckboxGroup();                 // 단일 선택을 보장하는 체크박스 그룹 객체 생성
        for (int i = 0; i < rb.length; i++) {
            // ※ 참고: grp와 연동하려면 new Checkbox(label2[i], grp, false) 형태로 작성해야 그룹으로 묶입니다.
            rb[i] = new Checkbox(label2[i], true); // 현재는 그룹 연결 없이 일반 체크박스로 생성되어 있음
            rb[i].addItemListener(this);           // 이벤트 감지자 등록
            add(rb[i]);                            // 프레임(화면)에 추가
        }
        
    } // 생성자 끝
    
    // 6. [이벤트 처리 메서드] 사용자가 체크박스를 클릭(선택/해제)할 때마다 JVM이 자동으로 호출
    @Override
    public void itemStateChanged(ItemEvent e) {
        // e.getSource(): 이벤트를 발생시킨 UI 요소(클릭된 체크박스)를 가져와 Checkbox 타입으로 형변환
        Checkbox cb = (Checkbox)e.getSource();
        
        // 선택된 체크박스의 라벨 텍스트를 조합 (ex: "선택1 : 선택1")
        // ※ 참고: 보통 cb.getLabel() + " : " + cb.getState() 로 상태(true/false)를 출력하도록 많이 사용합니다.
        String str = cb.getLabel() + " : " + cb.getLabel();
        
        setTitle(str); // 상단 타이틀바 제목을 변경된 결과 문자열로 업데이트
    }
    
    // 7. [시작점] 프로그램 실행 시 가장 먼저 호출되는 메인 메서드
    public static void main(String[] args) {
        new CheckboxEx1(); // 객체를 생성하면서 생성자(CheckboxEx1)를 실행시켜 윈도우 창을 띄움
    }
}