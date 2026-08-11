package net.jyj;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MDialog extends Dialog implements ActionListener {

    Button ok;
    TalkClient tc;

    public MDialog(TalkClient tc, String title, String message) {
        super(tc, title, true);
        this.tc = tc;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setLayout(new GridLayout(2, 1));
        add(new Label(message, Label.CENTER));

        ok = new Button("확인");
        ok.addActionListener(this);
        add(ok);

        layset();
        setVisible(true);
        validate();
    }

    public void layset() {
        int px = tc.getX();
        int py = tc.getY();
        int pw = tc.getWidth();
        int ph = tc.getHeight();
        setBounds(px + (pw / 2) - 100, py + (ph / 2) - 50, 200, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tc != null && tc.sendTf != null) {
            tc.sendTf.setText("");
        }
        dispose();
    }
}