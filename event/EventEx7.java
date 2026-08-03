package event;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// 받아오기
public class EventEx7 extends MFrame {
	
	Checkbox red, green, cyan;
	CheckboxGroup grp;

	public EventEx7() {
		Panel p = new Panel();
		grp = new CheckboxGroup();
		p.add(red = new Checkbox("Red", false, grp));
		p.add(green = new Checkbox("Green", false, grp));
		p.add(cyan = new Checkbox("Cyan", true, grp));
		
		add(p, BorderLayout.SOUTH);
		
		// 익명클래스로 구현. Checkbox는 ItemListener로 구현!!
		// 앞에 Button을 했을 땐 addActionListener를 사용했음. 각각의 쓰임이 다른 것임.
		red.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
				setBackground(Color.RED);
				}
			}
		});
		green.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				 if(e.getStateChange() == ItemEvent.SELECTED) {
						setBackground(Color.green);
						p.setBackground(Color.green);
				 }
			}
		});
		cyan.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				 if(e.getStateChange() == ItemEvent.SELECTED) {
						setBackground(Color.cyan);
						p.setBackground(Color.cyan);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new EventEx7();
	}
}



