package ch11; // 패키지 선언

class Member { // Member 클래스 정의
	
	String id; // 회원의 아이디를 저장할 필드(변수) 선언
	
	public Member(String id) { // 아이디를 전달받아 객체를 생성하는 생성자
		this.id = id; // 전달받은 id 매개변수 값을 클래스의 id 필드에 저장
	}
	
	@Override // Member 타입이고 id 값이 같은 객체이면 true 리턴 (Object 클래스의 equals 메서드 재정의)
	public boolean equals(Object obj) {
		//instanceof 연산자: 타입을 비교 연산자
		if(obj instanceof Member) { // 비교 대상(obj)이 Member 타입의 객체인지 확인
			Member member = (Member)obj; // Object 타입을 Member 타입으로 형변환 (매개변수 타입이 Member임을 확인했으므로 safe casting)
			if(id.equals(member.id)) { // 현재 객체의 id 문자열과 비교 대상 객체의 id 문자열이 같은지 비교
				return true; // id 값이 같으면 두 객체를 같은 것으로 판단하여 true 반환
			}
		} 
		return false; // 비교 대상이 Member 타입이 아니거나 id 값이 다르면 false 반환
	}
}

public class ObjectEx3 { // 메인 클래스 정의
	public static void main(String[] args) { // 프로그램 실행 진입점(main 메서드)
		Member m1 = new Member("aaa"); // id가 "aaa"인 Member 객체 생성 후 m1 변수에 참조 주소 저장
		Member m2 = new Member("aaa"); // id가 "aaa"인 또 다른 Member 객체 생성 후 m2 변수에 참조 주소 저장
		Member m3 = new Member("bbb"); // id가 "bbb"인 Member 객체 생성 후 m3 변수에 참조 주소 저장
		
		if(m1.equals(m2)) { // 재정의된 equals 메서드를 호출하여 m1과 m2의 id("aaa" == "aaa") 비교
			System.out.println("m1, m2는 같다"); // equals 결과가 true이므로 "m1, m2는 같다" 출력
		} else {
			System.out.println("m1, m2는 다르다"); // false일 경우 출력되는 구문 (실행되지 않음)
		}
		
		if(m1.equals(m3)) { // 재정의된 equals 메서드를 호출하여 m1과 m3의 id("aaa" == "bbb") 비교
			System.out.println("m1, m3는 같다"); // true일 경우 출력되는 구문 (실행되지 않음)
		} else {
			System.out.println("m1, m3는 다르다"); // equals 결과가 false이므로 "m1, m3는 다르다" 출력
		}
	}
}