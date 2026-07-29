package ch10;

public class ExceptionEx7 {
	
	int a = 100;
	public void divide(int b) throws Exception{
		if(b == 0 ) {
			// 실제 예외객체가 생성되고, 그 예외객체를 던진다.
			throw new Exception("a를 0으로 나누면 안되요.");
		}else {
			System.out.println(a + " / " + b + " = " + a/b);
		}
	}
	
	
	public static void main(String[] args) {
		ExceptionEx7 e7 = new ExceptionEx7();
		// 예외는 일어날 수도 있고, 안 일어날 수도 있기 때문에 무조건 try-catch 써야한다.
		try {
			e7.divide(2);
			e7.divide(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
