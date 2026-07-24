package ch06;

// 클래스명(풀네임): ch06.Car1
// 같은 파일에 여러 개의 클래스 정의는 가능하나, 각자의 .class가 만들어짐. ex)Car.class, CarEx1.class

// 클래스 선언: 객체를 만드는 틀
// 클래스 구성: 필드, 메소드
class Car1 /*클래스명(대소문자 구분)*/{
	//필드(field): 객체의 속성 <- 무조건() 없음. 소문자 시작. 카멜표기법
	// 기본값; 참조형: null, 기본형: 0
	String caName;
	int velocity;
	String carColor;
	
	// 메소드(methods): 객체의 기능(동작) <- 무조건(). 소문자 시작.  카멜표기법
	// SUN 제공되는 메소드 패턴: 동사 + 명사 ex) (설정하다)setBackground, (받다)getColor, (~있다)isEmpty
	void speedUp() {
		velocity++;
		System.out.println("속도 증가! 현재 속도: " + velocity);
	}
	
	void speedDown() {
		velocity--;
		System.out.println("속도 감소.. 현재 속도: " + velocity);
		if(velocity < 0) {
			velocity = 0;
		}
	}
	
	void stop() {
		velocity = 0;
	}
	
	void print() {
		System.out.println(velocity);
	}	

}

// 파일명은 반드시 main 있는 클래스명으로 선언을 해야하고 다른 클래스(Car1)public을 붙이면 안됨
public class CarEx1 {
	// 프로그램 실행을 위해서는 반드시 main필요
	public static void main(String[] args) {
		// c1: 래퍼런스 변수.       new: 객체 생성 키워드
		Car1 c1 = new Car1();
		Car1 c2 = new Car1();
		System.out.println(c1);
		System.out.println(c2);
		c1.caName = "그랜저";
		c1.carColor = "카키";
		c1.speedUp();
		System.out.println(c1.caName);
		System.out.println(c1.carColor);
	}
}
