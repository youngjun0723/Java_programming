package ch09;

/*중첩(내부) 클래스
 * 1.클래스 안에 클래스 선언(70%)
 * 2.클래스 안에 선언하지만 static 클래스 선언(0.1%)
 * 3.메소드 안에 클래스 선언(0.1%) # 메소드 안에 메소드 선언은 구조적으로 안됨
 * 4.메소드 안에 선언을 하지만 이름이 없는 익명클래스(30% - 그래픽 이벤트) <- 추상클래스, 인터페이스
 * */

interface MyInter1{
	void prn();
}

//외부클래스: 외부클래스.class,  외부클래스$내부클래스.class, 외부클래스$1.class
class Outer1{
	
	/*1*/ class Inner1{}
	/*2*/ static class Inner2{}
	
	void method(){
		/*3*/ class Inner3{}
		/*4*/ new MyInter1() {
			@Override
			public void prn() {}
		};
	}
}//Outer1

public class InnerEx1 {

}







