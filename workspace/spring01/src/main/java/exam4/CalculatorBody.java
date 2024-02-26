package exam4;

public class CalculatorBody {
	private Calculator calculator;

	public CalculatorBody() {
		System.out.println("CalculatorBody()");
	}

	public CalculatorBody(Calculator calculator) {
		System.out.println("CalculatorBody(Calculator)");
		this.calculator = calculator;
	}

	public void setCalculator(Calculator calculator) {
		System.out.println("setCalculator(Calculator)");
		this.calculator = calculator;
	}
	
	public int calculate(int num1, int num2) {
		return calculator.calc(num1, num2);
	}
	
}
