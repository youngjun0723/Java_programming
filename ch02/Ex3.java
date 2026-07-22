package ch02;

public class Ex3 {
	public static void main(String[] args) {
		// 데이터 타입(Data Type): 기본형(8) + 참조형(클래스 타입)
		// 정수형(4)
		byte b = 10;
		// System.out.println(byte.MAX_VALUE); // 127
		short s = 20;
		// short의 최대 최소
		System.out.println(Short.MAX_VALUE); // 32767
		int i = 30;
		long l = 40;
		
		// 실수형(2)
		float f = 3.14f;
		double d = 3.15;
		
		//문자형(2)
		char c = 'c';
		String str = "안녕"; // 참조형
		System.out.println(str.length()); // 참조형은 클래스 타입이기 때문에 변수와 메소드를 가지고있음.
		
		// true/false
		boolean bl = true;
		
		//byte형과 double형의 최대, 최소값을 출력
		System.out.println(Byte.MIN_VALUE + "~" +Byte.MAX_VALUE);
		System.out.println(Double.MIN_VALUE + "~" + Double.MAX_VALUE);
		
		int i1 = 200;
		long l1 = i1;
		
		long l2 = 300;
		int i2 = (int)l2;
		
	}
}
