package net.jyj;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkAWT extends MFrame implements ActionListener {

    TextField idTf;
    TextField pwTf;
    Label logo;
    Label idl;  // ID label
    Label pwl;  // PWD label 
    Label msgl; // message label
    Button logBtn;
    Socket sock;
    BufferedReader in;
    PrintWriter out;
    String id;
    String ip = "127.0.0.1"; // 기본 로컬 IP 설정
    int port = 8005;
    String title = "Talk 1.0";
    String label[] = {"아이디/비밀번호를 입력하세요.", "아이디/비밀번호를 확인하세요."};

    public TalkAWT() {
        super(400, 400, new Color(100, 150, 200));
        setLayout(null);
        setTitle(title);

        logo = new Label(title);
        logo.setFont(new Font("Dialog", Font.BOLD, 50));

        idl = new Label("ID:");
        pwl = new Label("PWD:");
        idTf = new TextField("aaa");
        pwTf = new TextField("1234");
        logBtn = new Button("로그인");
        msgl = new Label(label[0]);

        add(logo);
        add(idl);
        add(pwl);
        add(idTf);
        add(pwTf);
        add(logBtn);
        add(msgl);

        logo.setBounds(90, 50, 250, 100);
        idl.setBounds(100, 200, 50, 20);
        pwl.setBounds(100, 230, 50, 20);
        idTf.setBounds(150, 200, 100, 20);
        pwTf.setBounds(150, 230, 100, 20);
        logBtn.setBounds(100, 260, 150, 40);
        msgl.setBounds(90, 300, 200, 40);

        logBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource(); // 올바른 이벤트 소스 취득
        try {
            if (obj == logBtn) {
                if (sock == null) {
                    sock = new Socket(ip, port);
                    in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                    out = new PrintWriter(sock.getOutputStream(), true);
                }
                out.println(idTf.getText() + ";" + pwTf.getText());
                String readData = in.readLine();
                if ("T".equals(readData)) { // 로그인 성공
                    id = idTf.getText();
                    dispose();
                    new TalkClient(in, out, id); // TalkClient 실행
                } else if ("F".equals(readData)) { // 로그인 실패
                    msgl.setForeground(Color.red);
                    msgl.setText(label[1]);
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TalkAWT();
        new TalkAWT();
        
    }
}