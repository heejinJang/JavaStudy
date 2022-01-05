package chapter17;

public class ThreadEx9 {

	public static void main(String[] args) {
		
		YieldThread t1 = new YieldThread();
		YieldThread t2 = new YieldThread();
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
		
		t1.isContinue = false; // t1 양보
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
		
		t1.isContinue = true; // t1 다시 실행
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {}
		
		//스레드 종료
		t1.isBreak = true;
		t2.isBreak = true;
		
	}

}

class YieldThread extends Thread{
	boolean isBreak = false;
	boolean isContinue = false;
	
	@Override
	public void run() {
		while(!isBreak) { // 스레드가 멈추지 않을 때만(isn't Break)
			if(isContinue) {
				System.out.println(getName()+" 실행 중");
			}else {
				Thread.yield();
			}
		}
		System.out.println(getName()+" 종료");
	}
}