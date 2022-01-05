package chapter17;

public class ThreadEx10 {

	public static void main(String[] args) {
		
		//게임 객체 생성
		SmartPhoneGame game = new SmartPhoneGame();
		
		//플레이어1 객체 생성 후 스레드 실행
		Player1 p1 = new Player1();
		p1.setSmartPhoneGame(game);
		p1.start();
		
		//플레이어2 객체 생성 후 스레드 실행
		Player2 p2 = new Player2();
		p2.setSmartPhoneGame(game);
		p2.start();

	}

}

class SmartPhoneGame {
	private int level;
	
	public int getLevel() {
		return this.level;
	}
	
	public void increaseLevel() { 
		//혹은 public synchronized void increaseLevel(). 플레이어끼리 레벨을 각자 가지게 하려면 동기화 키워드 사용.  
		while(true) {
			this.level++;
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
			
			//현재 스레드 이름과 레벨 출력
			System.out.println(Thread.currentThread().getName()+" Level : "+this.level);
			//레벨이 10의 배수가 되면 종료
			if(this.level % 10 == 0) break;
		}
	}
}

class Player1 extends Thread{
	private SmartPhoneGame game;
	
	public void setSmartPhoneGame(SmartPhoneGame game) {
		this.setName("Player1");
		this.game = game;
	}
	
	@Override
	public void run() {
		game.increaseLevel();
	}
}

class Player2 extends Thread{
	private SmartPhoneGame game;
	
	public void setSmartPhoneGame(SmartPhoneGame game) {
		this.setName("Player2");
		this.game = game;
	}
	
	@Override
	public void run() {
		game.increaseLevel();
	}
}