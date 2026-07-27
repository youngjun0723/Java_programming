package ch07;

public class CastingEx1 {
	public static void main(String[] args) {
		
		// 자바 기본형 형변환
		System.out.println(Short.MAX_VALUE);
		int a = 32768;
		long l = a;
		short s = (short)a;
		System.out.println(l);
		System.out.println(s);
	}

}
