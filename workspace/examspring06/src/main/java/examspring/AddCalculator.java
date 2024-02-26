package examspring;

public class AddCalculator implements Calculator{

	@Override
	public int calc(int num1, int num2) {
		System.out.println("핵심 기능 동작(덧셈)");
		return num1+num2;
	}

}
