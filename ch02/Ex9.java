package ch02;

import java.util.Scanner;

public class Ex9 {
	public static void main(String[] args) {
		/*Scanner와 while(true)를 활용해 사용자가 0을 입력할 때까지 
		 * 숫자를 계속 받아 짝수/홀수를 판별하고, 0 입력 시 프로그램을 종료하는 코드를 작성하세요.*/
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("End-");
				break;
			}
			if(input % 2 == 0) {
				System.out.println("짝수입니다");
			}
			else {
				System.out.println("홀수입니다.");
			}
		}
	}
}
