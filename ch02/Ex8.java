package ch02;

import java.util.Scanner;

public class Ex8 {
	public static void main(String[] args) {
		int a = 10;
		int b = 23;
		
		// 동적인 값 입력하기 위한 기능
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.nextLine(); // cmd에서 입력받은 이름 리턴
		System.out.print("나이: ");
		int age = sc.nextInt();
		System.out.printf("\n %s님의 나이는 %d살 입니다.", name, age);
	}
}
