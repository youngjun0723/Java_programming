package ch04;

// 조건문(선택문): if-else, switch
public class Ex2 {
	public static void main(String[] args) {
		String month = "february";
		// switch는 break가 없으면 밑에 case가 가는 성질이 있다.
		switch (month) {
		case "january": 
			System.out.println("1월");
			break;
		case "february": 
			System.out.println("2월");
			break;
		case "march": 
			System.out.println("3월");
			break;
		default:
			System.out.println("4월달 이후..");
		}
		System.out.println("************************");
		// switch를 if-else로
		if(month.equals("january")) {
			System.out.println("1월달");
		}else if(month.equals("february")) {
			System.out.println("2월달");
		}else if(month.equals("march")) {
			System.out.println("3월달");
		}else {
			System.out.println("4월달 이후..");
		}
	}

}
