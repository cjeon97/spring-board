package exam2;

public class Main0 {
	public static void main(String[] args) {
		CalculatorBody cb = new CalculatorBody();
		
		cb.setCalculator(new AddCalculator());
		int result = cb.calculate(1, 2);
		System.out.println(result);
		
		
		cb.setCalculator(new MinCalculator());
		System.out.println(cb.calculate(10, 3));
	}
}
