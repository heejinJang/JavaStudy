package chapter17;

import java.util.concurrent.TimeUnit;

public class ProcessEx {

	public static void main(String[] args) {
		
		try {
			//메모장 실행
//			Process p1 = Runtime.getRuntime().exec("notepad.exe");
			//계산기로 바꾸면 그림판이 먼저 실행 후 바로 종료되고 계산기가 나중에 실행된다. 
			Process p1 = Runtime.getRuntime().exec("calc.exe");
			Thread.sleep(1000);
			//그림판 실행
			Process p2 = Runtime.getRuntime().exec("mspaint.exe");
			
			System.out.println("p1 프로세스가 종료될 때까지 대기");
//			p1.waitFor(); //p1 프로세스가 종료될 때까지 대기
			System.out.println(p1.waitFor(1000, TimeUnit.SECONDS));
			System.out.println("p1 프로세스가 종료되면 실행");
			Thread.sleep(5000);
			p2.destroy(); //p1 프로세스가 종료되면 실행
			System.out.println("p2 프로세스가 종료");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
