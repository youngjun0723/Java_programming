package ch11;

import java.util.Vector;

public class WrapperEx1 {
	
	public static void main(String[] args) {
		//Wrapper 클래스: 자바 기본형 8개를 객체화 시킨 클래스의 집합
		// byte, short, long, float, double, boolean, int, char
		int a = 10;
		Integer it = Integer.valueOf(a); //Int형에서 Integer형 변환
		Integer it2 = a; // Auto Boxing
		int b = it2; // Auto UnBoxing
		
		Vector vec = new Vector(); // 객체를 저장하는 클래스
		vec.add(new String("하하"));
		vec.add(new Object());
		vec.add(a); // Auto Boxing <- Integer 타입을 변환저장
		
		
		
		Integer it3 = new Integer(a);
		Integer it4 = new Integer("22");
		Integer it5 = Integer.valueOf(a);
		Integer it6 = Integer.parseInt("23");
		
		
		//왜 int형을 integer형으로 변환하는가?
		// Integer는 참조형이기 때문에.
		int d = Integer.parseInt("24");
		System.out.println("2진수");
		
		
		
	}

}
