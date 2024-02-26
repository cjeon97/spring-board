package aop01;

public class Start {
	public static void main(String[] args) {
		
		Progamer alice = new Progamer();
		Programmer bob = new Programmer();
		
		int usedTime1 = alice.usingComputer("1234");
		System.out.println("alice의 사용시간: " + usedTime1);
		System.out.println();
		
		int usedTime2 = bob.usingComputer("5678");
		System.out.println("bob의 사용시간: " + usedTime2);
	
	}
}
