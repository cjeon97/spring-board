package aop10;

import java.util.Scanner;


public class Programmer implements Person {
	
	@Override
	public int usingComputer(String pwd) {
		//System.out.println("[컴퓨터 부팅 후 " + pwd + "를 입력하여 로그인]");
		
		//try {
			System.out.println("[코딩을 한다]");
			Scanner in = new Scanner(System.in);
			System.out.print("상태 입력: ");
			int state = in.nextInt();
			if(state == 1) {
				throw new RuntimeException("오류!");
			}
			
			//System.out.println("[코딩 종료]");
		//}catch(Exception e) {
		//	if(e.getMessage().equals("부팅 오류")) {
		//		System.out.println("[AS를 신청한다]");
		//	}
		//}
		
		//System.out.println("[컴퓨터 종료]");
		return 200;
	}
}
