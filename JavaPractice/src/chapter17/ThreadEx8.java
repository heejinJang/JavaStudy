package chapter17;

public class ThreadEx8 {

	public static void main(String[] args) {
		
		Sum t1 = new Sum();
		Sum t2 = new Sum();
		
		t1.start();
		t2.start();
		
		try {
			t1.join(); // t1 스레드가 종료될 때까지 대기
			t2.join(); // t2 스레드가 종료될 때까지 대기
		}catch(InterruptedException e) {}
		
		//만약 join()이 없으면 0, 5050, 10100 중 무작위로 나온다. 
		
		System.out.println("두 스레드의 sum 합계 : "+(t1.sum+t2.sum));

	}

}

class Sum extends Thread{
	int sum = 0;
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
	}
}