package ch04;

import java.util.TreeSet;

public class LuckyLotto2 {
	public static void main(String[] args) {
		Object arr[] = getLotto();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}
	
	public static Object[] getLotto() {
		// TreeSet(자료구조): 중복과 정렬이 자동으로 만들어지는 클래스
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for (int i = 0; ts.size() < 6 /*data 개수*/; i++) {
			// add 때문에 중복허용 x
			ts.add((int)(Math.random() * 45) + 1);
		}
		Object[] obj = ts.toArray();
		return obj;
	}
}
