package ch04;

class A3 {
	
}

public class Ex3 {
	public static void main(String[] args) {
		// Data Type: 기본형 + 참조형(클래스)
		A3 a = new A3();
		A3 b = new A3();
		// 참조형에서 ==는 객체 주소값 비교
		System.out.println(a == b); // false
	}
}
