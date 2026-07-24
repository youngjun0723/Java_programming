package ch06;


class Method1 {
	
	//method: 객체의 반복적인 기능. 최대한 세분화
	
	// public : 제어자     int : 리턴 타입     abs : 메소드 명     int num : 매개변수
	public int abs(int num) {
		if(num < 0) {
			num = -num;
		}
		return  num;
	}
	
	void prn (int a, int b) {
		System.out.println(a + " + " + b + " = " + (a+b));
	}
	
}






public class MethodEx1 {
	
	public static void main(String[] args) {
		Method1 mt = new Method1();
		int a = mt.abs(-23);
		System.out.println(a);
		mt.prn(10, 20);
		
	}
}
