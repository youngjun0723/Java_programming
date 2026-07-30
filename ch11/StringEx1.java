package ch11;

public class StringEx1 {
	public static void main(String[] args) {
		int a = 10, b = 10;
		System.out.println(a==b); // true
		System.out.println("------------------");
		String s = new String("Java");
		String s1 = new String("Java");
		System.out.println(s==s1);
		System.out.println(s.equals(s1));
		System.out.println("------------------");
		/*
		 * String은 new 연산자없이 객체를 생성하는 유일한 클래스이다.
		 * new 연산자없이 선언된 값들은 String 저장소 공간에 선언되고, 
		 * 동일한 값을 새로운 변수로 선언하면? 값이 재사용된다.
		 * 위와 같은 약점을 보완한 클래스가 StringBuffer이다.
		 */
		String s2 = "Java";
		String s3 = "Java";
		System.out.println(s2==s3);
		System.out.println(s2.equals(s3));
		String s4 = "apple";
		String s5 = "APPLE";
		//대소문자 무시하고 같은지 검색
		System.out.println(s4.equalsIgnoreCase(s5));
	}
}
