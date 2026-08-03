package awt;

// AWT GUI 컴포넌트 및 이벤트 관련 클래스 import
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 1. MFrame을 상속받아 파일 대화상자(FileDialog) 실습을 위한 프레임 클래스 정의
public class FileDialogEx1 extends MFrame {
	
	// 2. [멤버 변수 선언] 파일 열기/저장용 대화상자 객체와 이벤트 trigger 역할을 할 버튼 선언
	FileDialog openFile, saveFile; // 파일 열기/저장 창을 띄울 FileDialog 객체
	Button openBtn, saveBtn;       // 열기/저장 창을 호출할 버튼
	
	// 3. [생성자] 메인 메서드에서 객체 생성 시 화면 구성 및 대화상자/이벤트 초기화
	public FileDialogEx1() {
		// 4. FileDialog 객체 생성 (부모 프레임 지정, 창 제목, 대화상자 모드 설정)
		// FileDialog.LOAD : 파일 선택(열기) 모드
		openFile = new FileDialog(this/*현재의 Frame 객체*/, "파일 열기", FileDialog.LOAD);
		// FileDialog.SAVE : 파일 지정(저장) 모드
		saveFile = new FileDialog(this/*현재의 Frame 객체*/, "파일 저장", FileDialog.SAVE);
		
		// 5. 버튼을 담을 패널(Panel) 생성 및 버튼 추가
		Panel p = new Panel();
		p.add(openBtn = new Button("OPEN")); // "OPEN" 버튼 생성 후 패널에 추가
		p.add(saveBtn = new Button("SAVE")); // "SAVE" 버튼 생성 후 패널에 추가
		
		// 6. [이벤트 처리 1] "OPEN" 버튼 클릭 시 실행될 리스너 등록
		openBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile.setVisible(true);              // 파일 열기 대화상자를 화면에 띄움 (파일을 선택할 때까지 대기)
				String dir = openFile.getDirectory();   // 사용자가 선택한 파일의 디렉토리(경로) 가져오기
				String file = openFile.getFile();       // 사용자가 선택한 파일 이름 가져오기
				System.out.printf("%s%s\n", dir, file);  // 선택한 전체 경로와 파일명을 콘솔에 출력 (취소 시 nullnull 출력)
			}
		});
		
		// 7. [이벤트 처리 2] "SAVE" 버튼 클릭 시 실행될 리스너 등록
		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile.setVisible(true);              // 파일 저장 대화상자를 화면에 띄움 (파일을 지정할 때까지 대기)
				String dir = saveFile.getDirectory();   // 저장할 위치의 디렉토리(경로) 가져오기
				String file = saveFile.getFile();       // 저장할 파일 이름 가져오기
				System.out.printf("%s%s\n", dir, file);  // 경로와 파일명을 콘솔에 출력 (취소 시 nullnull 출력)
			}
		});
		
		// 8. 버튼들이 들어있는 패널 p를 프레임에 추가
		add(p);
	}
	
	// 9. [시작점] 프로그램 실행 시 가장 먼저 호출되는 메인 메서드
	public static void main(String[] args) {
		new FileDialogEx1(); // FileDialogEx1 객체를 생성하면서 생성자 실행 (GUI 창 띄움)
	}

}