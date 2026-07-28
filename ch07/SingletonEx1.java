package ch07;

// 싱글톤: 전체 프로그램에서 특정 클래스의 객체(인스턴스)를 단 하나만 만들어 공유해서 쓰도록 보장하는 디자인 패턴

class Singleton1 {
	
	private static Singleton1 instance = null;
	// 외부에서 객체 생성 불가능하게.
	private Singleton1() {	}
	
	// 필드 instance 객체가 null이면 객체를 생성하고 null이 아니면 Singleton1 객체를 return
	public static Singleton1 getInstance() {
		if(instance==null) {
			instance = new Singleton1();
		}
		return instance;
	}
}


public class SingletonEx1 {
	
	public static void main(String[] args) {
		// 생성자가 private이기 때문에 직접적인 생성 불가능
		// Singleton1 st = new SingletonEx1();
		Singleton1 st1 = Singleton1.getInstance();
		Singleton1 st2 = Singleton1.getInstance();
		System.out.println(st1);
		System.out.println(st2);
	}
}
