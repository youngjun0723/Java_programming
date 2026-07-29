package ch10;


public class ExceptionEx6 {
	public static void main(String[] args) {
		try {
			exec3(); // 1 
			System.out.println("예외없이 실행");
		} catch (Exception e) { // 8
			e.printStackTrace();
		}
		
	}
	
	// static을 넣어서 만들면 static 메소드 안에 직접적 호출 가능
	public static void exec1() throws Exception { // 5
		// 예외가 일어날 수 있는 코드가 있다고 가정
		int c = 10/0; // 4
	}
	
	public static void exec2() throws Exception{ // 6
		exec1(); // 3
	}
	
	public static void exec3() throws Exception{ // 7
		exec2(); // 2
	}
}
