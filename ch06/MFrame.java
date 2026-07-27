package ch06;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MFrame extends Frame {

	MFrame() {
		this(300, 300, new Color(230, 230, 230));
	}

	MFrame(int w, int h) {
		this(w, h, new Color(230, 230, 230));
	}

	MFrame(Color c) {
		// super(); 이건 있을 수가 없다. super와 this는 둘 다 첫 번째 라인에 와야하는데, 부딪히기 때문에 불가능.
		// 그리고 원론적으로 this를 가면 MFrame 코어에 가게 되는데, 거기에 super가 생략되어있다.
		this(300, 300, c);
	}

	MFrame(int w, int h, Color c) {
		setTitle("제목");
		setSize(w, h);
		setBackground(c);
		setResizable(false);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		validate();
	}

	public static void main(String[] args) {
		MFrame mf = new MFrame(Color.GREEN);

	}
}
