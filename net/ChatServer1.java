package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer1 {

	static  final int PORT = 8001;
	Vector<Client1> vc; // 접속한 Client 객체를 저장하는Vector
	ServerSocket server;
	
	public ChatServer1() {
		try {
			server = new ServerSocket(PORT);
			vc = new Vector<Client1>();
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("***********************************");
		System.out.println("*********ChatServer v1.0 Start*********");
		System.out.println("***********************************");
		try {
			while(true) {
				Socket sock = server.accept();
				Client1 ct = new Client1(sock);
				ct.start();
				// 접속한 Client 객체를 Vector 저장
				vc.add(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 접속이 끊어지면 Vector에서 Client 제거 기능
	public void removeClient(Client1 ct) {
		vc.remove(ct);
	}
	
	// 접속한 모든 사용자에게 메시지 보내는 기능
	public void sendAllMessage(String msg) {
		for(Client1 ct : vc) {
			ct.sendMessage(msg);
		}
	}
	
	
	class Client1 extends Thread{
		 
		Socket sock;
	    BufferedReader in;
	    PrintWriter out;
		
	    public Client1(Socket sock) {
	    	 try {
	                this.sock = sock;
	                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	                out = new PrintWriter(sock.getOutputStream(), true);
	                System.out.println(sock + "Connected.....");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
		}
	    
	    @Override  // 실제 Client와 통신을 하는 기능
	    public void run() {
	    	try {
				// Client에게 최초로 보내는 메시지
	    		sendMessage("반갑습니다. 사용할 아이디를 입력하세요.");
	    		// Client가 보낸 id를 리턴
	    		String id = in.readLine();
	    		// 접속한 모든 Client에게 welcome 메시지를 전달
	    		sendAllMessage("[" + id + "]님이 입장 하였습니다.");
	    		// 본격적인 채팅
	    		String line = "";
	    		while(true) {
	    			line = in.readLine();
	    			if(line == null) break;
	    			sendAllMessage("[" + id + "] " + line);
	    		}
	    		in.close();
	    		out.close();
	    		sock.close();
	    		
			} catch (Exception e) {
				// Client 접속이 끊어지면 Vector에서 자신을 제거시켜야 한다.
				removeClient(this);
				System.out.println(sock + " Disconnected... ");
			}
	    }
	    
	    public void sendMessage(String msg) {
	    	out.println(msg);
	    }
	
	
	
	}
	
	public static void main(String[] args) {
		new ChatServer1();
	}
}
