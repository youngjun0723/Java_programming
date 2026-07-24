package ch06;


class Method2{
	/*오버로딩(Overloading): 한 클래스 내에 동일한 메소드명으로 매개변수의 개수와 타입을 달리 선언하는 것*/
	
	void prn(int a) {
		System.out.println(a);
	}
	
	void prn(int a, int b) {
		System.out.println(a + " " + b);
	}

	void prn(int a, int b, int c) {
		System.out.println(a + " " + b +  " " + c);
	}
	
	void prn(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}
	
	// 가변인수    자동배열 될 것이다. 
	void prnf(int...arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}
}


public class MethodEx2 {
	public static void main(String[] args) {
		int a = Math.max(10, 20);
		double b = Math.max(3.14, 5.24);
		
		// 출력 자체가 메소드 오버로딩이다.. 충격!
		System.out.println(1);
		System.out.println("하하");
		System.out.println(true);
		
		Method2 mt = new Method2();	
		mt.prn(1);
		mt.prn(1, 2);
		mt.prn(1, 2, 3);
		
		mt.prnf(1);
		mt.prnf(1, 2);
		mt.prnf(1, 2, 3);
		mt.prnf(1, 2, 3, 4, 5, 6, 7, 8);
	}
}
