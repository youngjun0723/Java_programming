package ch04;

public class Ex10 {
	public static void main(String[] args) {
		//break, continue
		
		/*for과 break를 사용하여 1에서 n까지의 합이 100이상 최대한 가까운 합을 리턴*/
		int sum = 0;
		for(int i = 1; true; i++) {
			if(sum >= 100) {
				System.out.println("i : " + (i  - 1));
				break;
			}
			sum += i;
		}
		System.out.println("sum : " + sum);
		
		
		/*for 문을 이용하여 순차적으로 1에서 n까지의 합이 100이하에 가장 가까운 n과 sum 값 리턴*/
		
		
		
		/*1~10사이의 짝수를 출력하시오*/
		for(int i = 1; i < 11; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		
		/*1~10사이의 짝수를 출력하시오(continue 꼭 사용)*/
		for(int i = 1; i < 11; i++) {
			if( i % 2 != 0) {
				continue;
			}
			System.out.print( i + " ");
		}
		System.out.println();
		
		/*1~20사이에 3의 배수의 식과 합을 출력하시오.(continue)
		  * 3 + 6 + 9 + 12 + 15 + 18 = 63 */
		sum = 0;
		for(int i = 1; i < 21; i++) {
			if(i % 3 != 0) {
				continue;
			}
			sum += i;
			System.out.print(i + " + ");
		}
		System.out.println(sum);
		
	}
}
