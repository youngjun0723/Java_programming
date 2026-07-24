package ch06;

import java.awt.Dialog;
import java.awt.Frame;

class Constructor2 {
	/*JVM은 생성자가 하나라도 선언 되어 있으면 default 생성자를 제공 안함.
	 * SUN 제공되는 클래스 중에 디폴트 생성자가 없는 클래스도 존재
	 * 결론: 반드시 생성자는 한 개 필요*/

	Constructor2(int a) {}
}
public class ConstructorEx2 {
	public static void main(String[] args) {
		
		Constructor2 c1 = new Constructor2(1);
		
		Dialog d = new Dialog(new Frame());
	
	}
}
