package ch12;

// 이건 인터페이스.. 다중 상속..
class Runnable1 implements Runnable {
	String name;
	
	public Runnable1(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i = 0; i  < 10; i++) {
			System.out.println(i + ": " + name);
			try {
				Thread.sleep(100); // 이러면 에러떠서 try-catch해줘야함				
			} catch (InterruptedException e) {
				
			}
		}
	}
}

public class RunnableEx1 {

	public static void main(String[] args) {
		Runnable1 r1 = new Runnable1("BTS");
		Runnable1 r2 = new Runnable1("ROSE");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
