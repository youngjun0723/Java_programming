package ch03;

public class Ex2_1 {
	public static void main(String[] args) {
		//Ex2를 응용하여 모든 한글을 출력하시오.
		// 한 행에 20자 출력(while 안에 for문 특별한 조건에 return;)
		// 가 ~ 힣
		
		char c = '가';
		while(true) {
			for(int i = 0; i < 20; i++) {
				System.out.print((c++) + "\t");
				if(c == '힣' + 1 ) {
					return;
				}
			}
		}
	}
}
