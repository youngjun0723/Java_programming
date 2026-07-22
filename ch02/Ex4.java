package ch02;

public class Ex4 {
	public static void main(String[] args) {
		// 자바의 인코딩은 UTF-8(유니코드)
		// 인코딩: 컴퓨터는 0,1이해 <- 다양한 방법은 문자, 숫자, 특수문자를 0과1로 변환 과정
		/* 유니코드(UTF-8): 1~4바이트 가변 길이 변환 방식
		 * 1바이트: 영문자, 숫자, 기본특수문자
		 * 2바이트: 라틴, 그리스, 아랍어 문자
		 * 3바이트: 한글, 일어, 동아시아 문자
		 * 4바이트: 이모지, 고대문자, 희귀문자
		 * */
	
		int 키, 나이;
		출력하기("오늘은 즐거운 수요일");
	}
	
	public static void 출력하기(String 문자) {
		System.out.println(문자);
	}
}
