package chapter17;

public class ThreadEx {

	public static void main(String[] args) {
		
		//스레드 생성하는 방법
		
		//1.Thread 상속
		ThreadExtend t1 = new ThreadExtend();
		
		//2.Runnable 구현
		//상속은 한 클래스밖에 못받기 때문에 보통 2번을 더 많이 사용한다. 
		Runnable r = new RunnableImple();
		//Thread 생성자 매개변수로 전달
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();

	}

}

class ThreadExtend extends Thread{
	
	public void run() {
		System.out.println("Thread 상속받는 방법");
		for (int i = 0; i < 50; i++) {
			System.out.println("ThreadExtend : "+i);
		}
	}
	
}

class RunnableImple implements Runnable{
	public void run() {
		System.out.println("Runnable 구현하는 방법");
		for (int i = 0; i < 50; i++) {
			System.out.println("RunnableImple : "+i);
		}
	}
}