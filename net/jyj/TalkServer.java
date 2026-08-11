package net.jyj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class TalkServer {

    private ServerSocket server;
    private Vector<TalkThread> vc;
    private int port = 8005;
    private TalkMgr mgr;

    public TalkServer() {
        try {
            server = new ServerSocket(port);
            vc = new Vector<TalkThread>();
            mgr = new TalkMgr();
        } catch (Exception ex) {
            System.err.println("[Server Error] Failed to initialize server.");
            ex.printStackTrace();
            System.exit(1);
        }

        System.out.println("============================");
        System.out.println(" Talk Server Started");
        System.out.println(" Waiting for clients to connect...");
        System.out.println("============================");

        try {
            while (true) {
                Socket clientSocket = server.accept();
                TalkThread thread = new TalkThread(clientSocket);
                thread.start();
                vc.add(thread);
            }
        } catch (Exception ex) {
            System.err.println("[Socket Error] Exception occurred during accept().");
            ex.printStackTrace();
        }
    }

    public void sendAllMessage(String message) {
        for (TalkThread thread : vc) {
            thread.sendMessage(message);
        }
    }

    public void removeClient(TalkThread thread) {
        vc.removeElement(thread);
    }

    // 다이어그램 구조에 맞춘 TalkThread 중첩 클래스
    class TalkThread extends Thread {

        private Socket sock;
        private BufferedReader in;
        private PrintWriter out;
        private String id = "익명";

        public TalkThread(Socket sock) {
            try {
                this.sock = sock;
                this.in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                this.out = new PrintWriter(sock.getOutputStream(), true);
                System.out.println("Client connected: " + sock.getRemoteSocketAddress());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String inputLine;

                // 1단계: 인증
                while ((inputLine = in.readLine()) != null) {
                    int delimiterIdx = inputLine.indexOf(';');
                    if (delimiterIdx != -1) {
                        String userParam = inputLine.substring(0, delimiterIdx);
                        String passParam = inputLine.substring(delimiterIdx + 1);

                        if (mgr.loginChk(userParam, passParam)) {
                            sendMessage("T");
                            this.id = userParam;
                            sendAllMessage("[" + id + "]님이 입장하였습니다.");
                            break;
                        } else {
                            sendMessage("F");
                        }
                    }
                }

                // 2단계: 메시지 중계
                while ((inputLine = in.readLine()) != null) {
                    sendAllMessage("[" + id + "]" + inputLine);
                }

                in.close();
                out.close();
                sock.close();

            } catch (Exception ex) {
                System.err.println("Client disconnected unexpectedly: " + sock.getRemoteSocketAddress());
            } finally {
                removeClient(this);
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }

    public static void main(String[] args) {
        new TalkServer();
    }
}