package ch04;

public class Ex8 {
	public static void main(String[] args) {
		/*문제1.for문을 이용해서 1~10까지의 합을 구하시오.(식과 함께)
		 * 1 + 2 +.... + 10 = 55*/
		int sum = 0;
		for(int i = 1; i < 11; i++) {
			if(i == 10) {
				sum+= i;
				System.out.print(i + " = ");
				break;
			}
			System.out.print(i + " + ");
			sum += i;
		}
		System.out.println(sum);
		
		/* 문제2. 1~50사이의 3, 6, 9 게임의 합은? 
		* Hint : %와 /를 사용. 33/10 => 3 
		* sum : 627
		*/
		sum = 0;
		for(int i = 1; i < 51; i++) {
			if(i / 10 == 3) {
				sum += i;
			} else if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				sum += i;
			}
		}
		System.out.println("sum : " + sum);
		
		/* 문제3. for문을 이용해서 1부터 200까지의 값 중에서
		 * 각 자리 숫자의 합이 10인 숫자들의 합을 구하시오. (while)
		 * 예: 19, 28, 37...109, 118, 127...
	     * sum : 1990
		 */
		sum = 0;
		int i = 1;
		while(i < 201) {
			int a = i / 100;
			int b = (i / 10) % 10;
			int c = i % 10;
			if(a + b + c == 10) {
				sum += i;
			}
			i++;
		}
		System.out.println("sum : " + sum);
		
		
		
		
		// 범위가 1 ~ 1000이고 합의 숫자는 10
		// 범위가 1 ~ 10000이고 합의 숫자는 15
		
		System.out.println(digitSum(10, 1000));
	}
	
	public static int digitSum(int condition, int range) {
		int sum = 0;
		for(int i = 1; i < range + 1; i++) {
			int num = i;
			int digitsum = 0; // 현재 숫자의 자리수 합
			while(num > 0) {
				digitsum += num % 10;
				num /= 10;
			}
			if(digitsum == condition) {
				sum +=i;
			}
		}
		return sum;
	}
}
