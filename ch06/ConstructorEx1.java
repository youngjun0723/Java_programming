package ch06;



class Constructor1 {
	/*생성자(Constructor): 객체를 생성하는 아주 특별한 메소드 
	 * 반드시 클래스명과 동일한 이름으로 선언. 메소드 리턴 타입 선언 자체가 없음
	 * JVM이 컴파일 시점에서 생성자가 하나라도 선언되지 않았으면,
	 * 디폴트 생성자(매개변수 x, 기능 x)를 추가하여 컴파일함.
	*/

	Constructor1() {
		System.out.println("디폴트 생성자");
	}
	Constructor1(int a) {
		System.out.println("디폴트 생성자");
	}
	Constructor1(String s) {
		System.out.println("디폴트 생성자");
	}
}




public class ConstructorEx1 {
	
	public static void main(String[] args) {
		Constructor1 c1 = new Constructor1();
	}
}
