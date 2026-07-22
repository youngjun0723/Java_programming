package ch03;

public class Ex7 {
	public static void main(String[] args) {
		// 기본값: 0
		int arr[] = new int[3];
		// 배열 값 할당
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
			System.out.println(arr[i]);
		}
		
		// 배열 선언과 동시에 값을 할당
		String subject[] = {"Java", "HTML", "C++", "Jsp", "Python"};
		for(String str : subject) {
			System.out.println(str);
		}
	}
}
