package ch10;

public class ExceptionEx1 {
	public static void main(String[] args) {
		try {//예외가 일어날 가능성이 있는 코드 영역
			int a = 10, b = 0;
			System.out.println(a+b);
			System.out.println(a-b);
			System.out.println(a*b);
			System.out.println(a/b);
			System.out.println(a%b);
		} catch (Exception e) {//일어난 예외를 처리하기 위한 영역.e 변수가 발생된 예외객체 레퍼런스
			System.err.println("예외가 발생");
			System.err.println(e.getMessage());
		}
		System.out.println("End~~");
		

		
	}
}
