package ch04;

import java.util.Arrays;

public class LuckyLotto3 {
	public static void main(String[] args) {
		
	}
	
	public static int[] getLotto () {
		int lotto[] = new int[6];
		for(int i = 0; i < lotto.length; i++) {
			int num = (int)(Math.random() * 45) + 1;  // 중복 난수 발생
			if(isDuplication(lotto, num)) {
				i--;  // 중복일 때
			}else {
				lotto[i] = num;   // 중복이 아닐 때
			}
		}
		
		Arrays.sort(lotto);
		return lotto;
	}
	
	// "12 45 3 34".contains("2"): 중복이면 true, 아니면 false
	public static boolean isDuplication(int arr[], int num) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str += arr[i] + " "; // int형 배열을 문자열로 변환. 구분자는 공백문자
		} // "12 45 3 34"
		// String.valueOf <- 정수값을 문자열로 변환
		return str.contains(String.valueOf(num));
	}
}
