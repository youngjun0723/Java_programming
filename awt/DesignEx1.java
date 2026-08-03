package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

public class DesignEx1 extends MFrame {
	
	Label label;
	Checkbox cb1, cb2, cb3;
	CheckboxGroup cbg;
	Button btn1, btn2;
	
	public DesignEx1() {
		super(250, 150);
		setLayout(new BorderLayout());
		setTitle("디자인 예제1");
		
		Panel p1, p2, p3;
		
		p1 = new Panel();
		p1.setBackground(Color.green);
		label = new Label("과일중에 선택");
		p1.add(label);
		
		p2 = new Panel();
		cb1 = new Checkbox("사과");
		cb2 = new Checkbox("딸기", true);
		cb3 = new Checkbox("앵두");
		p2.add(cb1);
		p2.add(cb2);
		p2.add(cb3);
		
		p3 = new Panel();
		p3.add(btn1 = new Button("Start"));
		p3.add(btn2 = new Button("End"));

		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		validate();
	}	
	
	public static void main(String[] args) {
		new DesignEx1();
	}
}




