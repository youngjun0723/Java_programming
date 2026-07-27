package ch06;

/*cmd 실행
 * 1. 컴파일: javac -d . PackageEx1.java -> ch06/PackageEx1.class 생성
 * -d는 패키지 옵션
 * .  컴파일 파일 저장 위치. 상대경로, 절대경로 가능 ex) javac -d C:\Java 파일명.java
 * 
 * 2. 실행: java ch06.PackageEx1
 * 패키지 폴더가 보이는 곳에서 패키지명.클래스명 실행함. 
 * */

/*
 * 패키지명: 도메인 거꾸로 선언
 * String의 full name java.lang.String
 * mysql에서 제공되는 String의 full name com.mysql.ultil.String
 * 
 * */
public class PackageEx1 {
	
	public static void main(String[] args) {
		System.out.println("ddd");
	}
}
