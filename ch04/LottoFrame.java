package ch04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Random;

class MyFrame extends Frame{
	
	public MyFrame() {
		setSize(400, 200);
		setTitle("로또생성기 v1.0");
		setBackground(Color.DARK_GRAY);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		setVisible(true);
	}
}

public class LottoFrame extends MyFrame implements ActionListener{
	
	Button btn;
	int lotto[];
	
	public LottoFrame() {
		btn = new Button("Lotto Click");
		btn.addActionListener(this);
		add(btn,BorderLayout.SOUTH);
		validate();
	}

	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		Font f = new Font("궁서체",Font.BOLD,25);
		g.setFont(f);
		if(lotto==null){
			g.drawString("로또 버튼을 클릭하세요.", 50, 100);
			return;
		}
		for (int i = 0, x =50; i < lotto.length; i++, x+=50) {
			g.drawString(lotto[i]+"", x , 100);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		lotto = getLotto();
		repaint();
	}

	public int[] getLotto(){
		int lotto[] = new int[6];
		for(int i = 0; i < lotto.length; i++) {
			// 0~1 이하의 값을 랜덤으로 생성. double로 생성하기 때문에, 앞에 int를 붙이는 것
			// (Math.random() * 45) << 최대값은 44.999999...
			lotto[i] = (int)(Math.random() * 45) + 1;  // 중복 난수 발생
			
			// 로또 중복 제거 로직
			for(int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					// i--를 해줘야 전체를 체크할 수 있음
					i--;
					break;
				}
			}
		}
		
		Arrays.sort(lotto);
		
		return lotto;
	}
	
	public static void main(String[] args) {
		new LottoFrame();
	}

}
