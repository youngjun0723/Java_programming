package ch12;

// Thread: 하나의 프로세스 안에 세부적인 일의 단위
// 반드시 extends Thread해야하고 반강제적으로 run메소드를 오버라이딩해서 run메소드에 해야할 일을 만들어줘야한다.
// 상속
class Thread1 extends Thread {
	
	String name;
	
	public Thread1(String name) {
		this.name = name;
	}
	
	
	
	
	@Override
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
public class ThreadEx1 {
	
	public static void main(String[] args) {
		Thread1 th = new Thread1("아이브");
		Thread1 th2 = new Thread1("리센느");
		// th.run();       // 직접적인 호출은 멀티쓰레드 기능안됨.  
		// th2.run();
		
		// JVM 안에 쓰레드 스케줄러가 존재한다. 여기에 등록을 하는 것이 start이고, 
		// run 메소드 호출은 내부적으로 알아서 실행해준다.
		th.start(); // 쓰레드 스케줄러 등록
		th2.start();
	}
}
