package event;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EventEx7 extends MFrame {
	
	Checkbox red, green, cyan;
	CheckboxGroup grp;

	public EventEx7() {
		Panel p = new Panel();
		grp = new CheckboxGroup();
		p.add(red = new Checkbox("Red", false, grp));
		p.add(green = new Checkbox("Green", false, grp));
		p.add(cyan = new Checkbox("Cyan", true, grp));
		//EventEx6 동일한 기능으로 익명클래스 방식으로 구현
	}
	
	public static void main(String[] args) {
		new EventEx7();
	}
}



