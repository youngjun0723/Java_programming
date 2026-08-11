package net.jyj;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TalkClient extends MFrame implements ActionListener, Runnable {

    Button saveBtn, sendBtn;
    TextField sendTf;
    TextArea ta;
    Panel p1, p2;
    BufferedReader in;
    PrintWriter out;
    String id;
    String title = "Talk 1.0";

    public TalkClient(BufferedReader in, PrintWriter out, String id) {
        super(350, 400);
        this.in = in;
        this.out = out;
        this.id = id;
        setTitle(title + " - [" + id + "]님 환영합니다.");

        // 상단 패널
        p1 = new Panel();
        p1.setBackground(new Color(200, 100, 200));
        saveBtn = new Button("SAVE");
        p1.add(saveBtn);

        // 하단 패널
        p2 = new Panel();
        p2.setBackground(new Color(200, 100, 200));
        p2.add(new Label("CHAT ", Label.CENTER));
        sendTf = new TextField("", 25);
        sendBtn = new Button("SEND");
        p2.add(sendTf);
        p2.add(sendBtn);

        // 이벤트 연결
        sendTf.addActionListener(this);
        saveBtn.addActionListener(this);
        sendBtn.addActionListener(this);

        // 배치
        add(p1, BorderLayout.NORTH);
        ta = new TextArea();
        add(ta, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        new Thread(this).start();
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == saveBtn) {
            String logs = ta.getText();
            long timestamp = System.currentTimeMillis();
            try {
                FileWriter fw = new FileWriter("net/" + timestamp + ".txt");
                fw.write(logs);
                fw.close();
                ta.setText("");
                new MDialog(this, "Save", "대화내용을 저장하였습니다.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (source == sendTf || source == sendBtn) {
            String message = sendTf.getText();
            if (filterMgr(message)) {
                new MDialog(this, "경고", "입력하신 글자는 금지어입니다.");
                return;
            }
            sendMessage(message);
            sendTf.setText("");
            sendTf.requestFocus();
        }
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    @Override
    public void run() {
        try {
            String received;
            while ((received = in.readLine()) != null) {
                ta.append(received + "\n");
                sendTf.requestFocus();
            }
        } catch (Exception e) {
            System.err.println("[Client Error] Socket communication interrupted.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public boolean filterMgr(String msg) {
        String[] forbiddenWords = { "바보", "개새끼", "새끼", "자바", "java" };
        StringTokenizer st = new StringTokenizer(msg);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            for (String word : forbiddenWords) {
                if (word.equalsIgnoreCase(token)) {
                    return true;
                }
            }
        }
        return false;
    }
}