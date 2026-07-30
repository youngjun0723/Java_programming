package ch13;

import java.util.Vector;

//Vector(동적배열-자료구조): Collection의 대표 클래스. 데이터를 저장하고 관리하는 역할.
//배열과 차이점: 같은 아니어도 되고 크기가 자유롭다. 추가,삭제 가능
public class VectorEx1 {
	
	public static void main(String[] args) {
		Vector vec = new Vector();//저장 용량 10개
		System.out.println(vec.capacity());//용량 크기
		System.out.println(vec.size());//요소크기
		System.out.println("-----------");
		boolean result = vec.add("하하");//1.2 
		System.out.println(result);
		vec.addElement(new String("호호"));//1.0 버전
		vec.add(22);
		vec.add(Integer.valueOf(23));
		System.out.println(vec.size());
		System.out.println("----------");
		//배열과 Vector 밑에 반드시 머가 있다? for문
		for (int i = 0; i < vec.size(); i++) {
			System.out.println(vec.get(i));
		}
		System.out.println("-----------");
		for (Object obj : vec) {
			System.out.println(obj);
		}
	}
}












