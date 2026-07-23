package ch04;

import java.util.Arrays;

public class LuckyLotto {
	public static void main(String[] args) {
		int arr[] = getLotto();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	
	
	// 1~45 사이의 중복되지 않는 6개의 난수를 오름차순으로 리턴
	public static int[] getLotto () {
		int lotto[] = new int[6];
		for(int i = 0; i < lotto.length; i++) {
			// 0~1 이하의 값을 랜덤으로 생성. double로 생성하기 때문에, 앞에 int를 붙이는 것
			// (Math.random() * 45) << 최대값은 44.999999...
			lotto[i] = (int)(Math.random() * 45) + 1;  // 중복 난수 발생
			
			// 로또 중복 제거 로직
			for(int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					// i--를 해줘야 전체를 체크할 수 있음
					i--;
					break;
				}
			}
		}
		
		Arrays.sort(lotto);
		return lotto;
	}
}
