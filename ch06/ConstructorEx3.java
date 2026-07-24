package ch06;

// Object는 1대 클래스(최상위 클래스로서 9개의 메소드를 가지고 있음)
// Super3은 2개 클래스
class Super3  extends Object{
	Super3() {
	
	}
}

// Sub3는 3대 클래스
class Sub3 extends Super3 {
	
	Sub3() {
		super(); // 상위클래스 생성자 호출이 생략되어있는 상태. !! 반 드 시 첫 번째 라인에 있어야함 !!
	}
}

public class ConstructorEx3 {
	public static void main(String[] args) {
		Super3 s1 = new Super3();
		Sub3 s2 = new Sub3();
		
	}
}
