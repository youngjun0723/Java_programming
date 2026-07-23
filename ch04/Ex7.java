package ch04;

import java.util.Iterator;

public class Ex7 {
	public static void main(String[] args) {
		//for문을 이용해서 1~10까지 합을 구하시오.
		int sum = 0;
		for(int i = 1; i < 11; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		for(;;) {
			System.out.println("무한반복");
		}
		// int k = 10; // 논리적인 에러 <- 컴파일 시점 why? 앞에 무한루프가 걸려있기 때문에 17line은 수행되지 않음
		
	}
}
