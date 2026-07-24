package ch06;


class Person extends Object {
	
	String name;
	int age;

	Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	void displayInfo() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}
}

class Employee extends Person {
	
	String department;
	
	// Person 클래스에 디폴트 생성자가 없기 때문에 에러 발생
	Employee(String name, int age, String department) {
		super(name, age);
		this.department = department;
	}
	
	@Override // @는 어노테이션(Annotation: 주석, 알림)
	/*오버라이딩(Overriding): 부모클래스에서 선언한 메소드를 자식클래스에서 재정의 하는 것. 반드시 메소드명이 동일해야 함.*/
	void displayInfo() {
		super.displayInfo(); // 부모 메소드에 있는 두 개의 출력도 사용할꺼기 때문에 가져왔다. 필수는 아니다.
		System.out.println("Department: " + department);

	}
	
	
}


public class ConstructorEx4 {
	public static void main(String[] args) {
		Person person = new  Person("조영준", 26);
		person.displayInfo();
		Employee em = new Employee("영준~", 26, "개발자");
		em.displayInfo();
	}
}
