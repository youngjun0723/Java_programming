package ch02;

public class Ex6 {
	public static void main(String[] args) {
		int i = 10;
		String s = "대한민국";
		boolean b = true;
		double d = 3.14;
		System.out.println(i +  " : " + s + " : " + b + " : " + d);
		System.out.println();
		// format 출력: %d(숫자), %s(문자), %b(불린), %f(실수)
		System.out.printf("%d : %s : %b : %f", i, s, b, d);
	}
}
