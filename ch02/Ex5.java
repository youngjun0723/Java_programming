package ch02;

public class Ex5 {
	public static void main(String[] args) {
		// Data Type: 기본형(8) + 참조형(class 타입: 무한대) -> SUN제공 + 외부 lib / + 본인이 만든 클래스
		Ex4 ex4 = new Ex4(); // 객체 생성: JVM이 Ex4.class 가지고 생성
		
		// new String(); 으로 인해 메모리에 실제 생성된 데이터 공간.
		// str << 그 객체를 가리키는 참조 변수
		String str = new String(); // new 개수 만큼 객체 생성이 된다.(단, 예외존재)
		
		String str1 = "sdfghsfg";
		String str2 = new String("sdfghsfg");
		
		// 객체 생성의 목적은 결국에는 변수와 메소드 사용이다. 
		System.out.println(str1.length());
		System.out.println(str2.toUpperCase());
		
		//Math 클래스: 수학의 기능을 객체화 ex) PI(원주율: 필드(변수)), 올림, 내림, 반올림, 절대값, sin, con, tan ....
		// 반지름 5인 원의 ㄼ이를 구하시오.
		System.out.println(Math.PI*5*5);
		System.out.println(Math.abs(-10));
	}
}
