package exam1;

public class CalculatorBody {
	private AddCalculator calculator;

	public void setAddCalculator(AddCalculator calc) {
		this.calculator = calc;
	}
	
	public int calculate(int num1, int num2) {
		return calculator.calc(num1, num2);
	}
	
}
