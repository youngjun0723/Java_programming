package ch03;

public class Ex6 {
	public static void main(String[] args) {
		//삼항 연산자
		int a = 10;
		/*
		if(a % 2 == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		*/
		System.out.println((a%2==0) ? "짝수":"홀수");
		
		int b = Math.min(10, 20);
		System.out.println(b);
	}
}
