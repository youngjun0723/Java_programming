package awt;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx2 extends MFrame implements ItemListener{

	Choice air, city;
	String sair[] = {"대한항공","아시아나","에어부산","진에어"};
	String scity[] = {"서 울","대 전","대 구","부 산","제주도"};
	
	public ChoiceEx2() {
		super(400, 400, new Color(200,200,250));
		setTitle("Choice 예제2");
		air = new Choice();
		for (int i = 0; i < sair.length; i++) {
			air.add(sair[i]);
		}
		city = new Choice();
		for (int i = 0; i < sair.length; i++) {
			city.add(scity[i]);
		}
		//city 아이템에 수정이 일어나면 itemStateChanged() 메소드 호출
		city.addItemListener(this);
		add(air);
		add(city);
		validate();
	}
	
	@Override
	//컴포넌트가 아닌 것들을 그려줄 때 paint에서 작성한다. 컴포넌트는 add하는 순간 그려짐.
	public void paint(Graphics g) {
		super.paint(g);
		if(air==null || city == null) { // air, city 객체가 생성되기 전에 그리면 안됨.
			return;
		}
		g.setColor(Color.blue); // 붓에 파란색을 세팅
		String str = "항공사 선택: " + air.getSelectedItem(); // get - 가져온다/ selected - 선택해서/ item - 아이템을
		g.drawString(str, 30, 120); // 30, 120은 좌표값이다.
		
		g.setColor(Color.red); // 붓에 파란색을 세팅
		String str2 = "도시 선택: " + city.getSelectedItem(); // get - 가져온다/ selected - 선택해서/ item - 아이템을
		g.drawString(str2, 30, 220); // 30, 120은 좌표값이다.
	}
	
	// city에만 event를 주면 된다.
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("호출");
	}
	
	
	public static void main(String[] args) {
		new ChoiceEx2();
	}
}
