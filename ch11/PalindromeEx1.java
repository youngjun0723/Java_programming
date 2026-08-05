package ch11; // 패키지(클래스가 속한 폴더 개념) 선언

import common.util.StringUtil; // 외부 유틸리티 클래스 임포트 (현재 코드에서는 실제 사용되지 않음)

public class PalindromeEx1 { // PalindromeEx1 클래스 정의
	
	public static final int MAX = 100000; // 탐색할 최대 숫자 범위를 상수로 지정 (100,000)
	
	public static void main(String[] args) { // 프로그램 실행 진입점(main 메서드)
		
		/*
		 * 앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 합니다. 
		 * 대칭수(palindrome)인 585는 2진수로 나타내도 
		 * 1001001001가 되어 여전히 대칭수입니다.
		 */
		
		// 문제1. 10진수의 대칭수인 100,000 이하 숫자의 합은 얼마입니까? (50,045,040)
		System.out.print("1번 : "); // 문제 구분용 텍스트 출력
		int sum = 0; // 10진수 대칭수들의 누적 합을 저장할 변수 초기화
		
		for (int i = 1; i <= MAX; i++) { // 1부터 100,000까지 1씩 증가하며 반복 실행
			String numStr = String.valueOf(i); // 현재 숫자(i)를 10진수 문자열로 변환 (예: 121 -> "121")
			String revStr = new StringBuilder(numStr).reverse().toString(); // 문자열을 뒤집음 (예: "121" -> "121")
			
			if (numStr.equals(revStr)) { // 원본 문자열과 뒤집은 문자열이 같은지 검사 (대칭수 확인)
				sum += i; // 대칭수라면 결과 변수 sum에 현재 숫자(i)를 더함
			}
		}
		System.out.println(sum); // 조건에 만족하는 10진수 대칭수들의 최종 합 출력
		
		// 문제2. 2진수의 대칭수인 100,000 이하 숫자의 합은 얼마입니까? (21,865,050)
		System.out.print("2번 : "); // 문제 구분용 텍스트 출력
		int sum2 = 0; // 2진수 대칭수들의 누적 합을 저장할 변수 초기화
		
		for (int i = 1; i <= MAX; i++) { // 1부터 100,000까지 1씩 증가하며 반복 실행
			String numStr = Integer.toBinaryString(i); // 현재 숫자(i)를 2진수 문자열로 변환 (예: 5 -> "101")
			String revStr = new StringBuilder(numStr).reverse().toString(); // 2진수 문자열을 뒤집음
			
			if (numStr.equals(revStr)) { // 원본 2진수와 뒤집은 2진수가 같은지 검사
				sum2 += i; // 대칭수라면 결과 변수 sum2에 현재 숫자(i)를 더함
			}
		}
		System.out.println(sum2); // 조건에 만족하는 2진수 대칭수들의 최종 합 출력

		// 문제3. 10진수과 2진수으로 모두 대칭수인 100,000 이하 숫자의 합은 얼마입니까? (286,602)
		System.out.print("3번 : "); // 문제 구분용 텍스트 출력
		int sum3 = 0; // 10진수와 2진수 모두 대칭수인 숫자의 누적 합 변수 초기화
		
		for (int i = 1; i <= MAX; i++) { // 1부터 100,000까지 1씩 증가하며 반복 실행
			String numStr10 = String.valueOf(i); // 10진수 문자열 생성
			String revStr10 = new StringBuilder(numStr10).reverse().toString(); // 10진수 문자열 뒤집기
			
			String numStr2 = Integer.toBinaryString(i); // 2진수 문자열 생성
			String revStr2 = new StringBuilder(numStr2).reverse().toString(); // 2진수 문자열 뒤집기
			
			// 10진수도 대칭수이고(&&) 2진수도 대칭수인지 두 조건 모두 검사
			if (numStr10.equals(revStr10) && numStr2.equals(revStr2)) { 
				sum3 += i; // 두 조건 모두 참이면 sum3에 현재 숫자(i)를 더함
			}
		}
		System.out.println(sum3); // 최종 합 출력

	}
}