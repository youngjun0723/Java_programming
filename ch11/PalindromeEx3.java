package ch11;

import java.util.Arrays;
import java.util.Iterator;

import common.util.StringUtil;

public class PalindromeEx3 {
	
	public static final int MAX = 100000;
	
	public static void main(String[] args) {
		int sum[] = new int[3]; 
		
		for (int i = 1; i <= MAX; i++) { 
			boolean dec = isPalindrome(i+""); 
			boolean bin = isPalindrome(Integer.toBinaryString(i)); 
			
			if(dec) sum[0]+=i; // 10진수가 대칭수이면 sum[0]에 i를 누적 (문제1)
			if(bin) sum[1]+=i; // 2진수가 대칭수이면 sum[1]에 i를 누적 (문제2)
			if(dec&&bin) sum[2]+=i; // 10진수와 2진수 모두 대칭수이면 sum[2]에 i를 누적 (문제3)
		}
		
		for (int i = 0; i < sum.length; i++) { // 배열의 크기(3번)만큼 반복문 실행
			System.out.println(StringUtil.addComma(sum[i])); // 합계 숫자에 천 단위 쉼표(,)를 붙여서 출력
		}
	}
	
	//객체 생성 없이 메모리 효율적 관리
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length()/2; i++) { // 문자열의 절반 길이만큼만 앞뒤 비교 반복
			if(s.charAt(i) != s.charAt(s.length()-1-i)) { // 맨 앞 문자와 대응되는 맨 뒤 문자가 다르면
				return false; // 즉시 대칭수가 아니라고 판단하여 false 반환
			}
		}
		return true; // 끝까지 비교를 통과하면 대칭수가 맞으므로 true 반환
	}
}