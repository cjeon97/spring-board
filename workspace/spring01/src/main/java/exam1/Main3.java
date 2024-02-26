package exam1;

public class Main3 {
	public static void main(String[] args) {
		CalculatorBody cb = new CalculatorBody();
		cb.setAddCalculator(new AddCalculator()); //주입
		System.out.println(cb.calculate(10, 4));
	}
}
