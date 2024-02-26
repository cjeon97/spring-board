package exam3;

public class CalculatorBody {
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public int calculate(int num1, int num2) {
		return calculator.calc(num1, num2);
	}
	
}
