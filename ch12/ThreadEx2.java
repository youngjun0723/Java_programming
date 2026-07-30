package ch12;


class NoThread2 {
	
	String name;
	
	public NoThread2(String name) {
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
	
	public void start() {
		run();
	}
	
	
}
public class ThreadEx2 {
	
	public static void main(String[] args) {
		NoThread2 t1 = new NoThread2("블핑");
		NoThread2 t2 = new NoThread2("에스파");
		t1.start();
		t2.start();
	}
}
