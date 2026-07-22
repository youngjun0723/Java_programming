package ch04;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1 ~ 20 사이의 숫자 중에 3, 6, 9이면 해당하는 숫자는 '짝'으로 표시를 해라.
		while(true) {
			System.out.print("3, 6, 9 게임 숫자를 입력하세요: ");
			int a = sc.nextInt();
			int b = a % 10; // 10의 자리 수를 버리는 로직
			if(b == 3 || b == 6 || b == 9) {
				System.out.println("짝");
			}else {
				System.out.println(a);
			}
		}
	}
}
