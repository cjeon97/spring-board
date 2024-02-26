package examspring;

public class ProxyCalculator implements Calculator{

	private Calculator delegate;
	
	public ProxyCalculator(Calculator calc) {
		this.delegate = calc;
	}
	
	@Override
	public int calc(int num1, int num2) {
		System.out.println("Param: " + num1 + ", " + num2);
		int result = delegate.calc(num1, num2);
		System.out.println("계산 로그 기록");
		return result;
	}

}
