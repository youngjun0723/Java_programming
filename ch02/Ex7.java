package ch02;

public class Ex7 {
	public static void main(String[] args) throws Exception{
		System.out.println("키보드에서 입력하고 Enter하세요");
		System.out.println("q를 입력하면 프로그램 종료됩니다.");
		while(true) {
			int KeyCode = System.in.read();
			System.out.printf("KeyCode: %d\n", KeyCode);
			if(KeyCode == 113) {
				break;
			}
		}
		System.out.println("End-");
	}
}
