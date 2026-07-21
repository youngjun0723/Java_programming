package ch02;
// 단어에 빨간색들은 모두 "예약어"이다.
// 클래스명은 반드시 첫 번째 단어는 반드시 대문자 -> 클래스명.java
public class Ex1 {

	public static void main(String[] args) {
		// 변수: 반드시 변수타입 변수명
		int a; // 변수 선언
		a = 10;
		int b = 5;
		// int c = 3.14;
		String str = "자바";
		System.out.println(a);
		System.out.println(b);
		System.out.println(str);
		
		int x, y, z;
		x = 10;
		
		// 정수 (Integer-int)의 최대 최소 값 출력
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		// Ex2 클래스를 객체 생성
		// JVM(자바 가상 머신 - 실행 엔진)이 Ex2.class를 가지고 와서 메모리 객체를 생성
		Ex2 ex = new Ex2();
	}

}
