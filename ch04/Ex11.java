package ch04;

public class Ex11 {
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("i : " + i + "j : " + j);
			}
		}
		System.out.println("**********************");
		
		/*i와 j의 합이 10 초과인 값을 제외한 숫자를 표시*/
		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				if(i + j >10) {
					break;
				}
				System.out.println(i + " + " + j + " = " + (i+j));
			}
		}
		
		// 중첩 반복문 시작할 때 라벨값을 지정
		aaa:
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j < 10; j++) {
				if(i + j > 10) {
					break aaa;
				}
			}
		}
		
		
		//문제:중첩 for 문을 이용해서 i+j의 합이 30이 넘어가면 빠져나오시오.
		for (int i = 1; i < 31; i++) {
			for (int j = 1; j < 31; j++) {
				if(i + j > 30) {
					break;
				}
				System.out.println(i + " + " + j + " = " + (i+j));
			}
		}
	}
}
