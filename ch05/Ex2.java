package ch05;

public class Ex2 {
	public static void main(String[] args) {
		// 다차원 배열: n * for(중첩)
		// 대괄호 개수 만큼 n차 배열
		int arr[][] = new int[2][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = i + j;
				System.out.println("arr["+i+"]["+j+"]: " + arr[i][j]);
			}
		}
		//문제1. arr2의 모든 요소의 합을 구하시오.
		int arr2[][] = {{1,2},
				                {3,4,5},
				                {6},
				                {7,8},
				                {9,10}};
		int sum = 0;
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				sum += arr2[i][j];
			}
		}
		System.out.println(sum);
		
		//문제3. arr4의 평균과 합을 각각 구하시오.
		sum = 0;
		int check = 0;
		int arr4[][][] = { { {1, 2, 3}, {4, 5}, {6, 7, 8, 9}},
				                     { {10, 11}, {12, 13, 14}, {15}, {22}},
				                     { {16, 17, 18, 19, 20},{22, 23, 24}}
									};
		for (int i = 0; i < arr4.length; i++) {
			for (int j = 0; j < arr4[i].length; j++) {
				for (int k = 0; k < arr4[i][j].length; k++) {
					sum += arr4[i][j][k];
					check++;
				}
			
			}
		}
		System.out.println("arr4 평균: " + sum / check );
		System.out.println("arr4 합: " + sum);
		
		// 배열예외
		int arr5[] = {0, 1, 2};
		System.out.println(arr5[3]);
	}
}
