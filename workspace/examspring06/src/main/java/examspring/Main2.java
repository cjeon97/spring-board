package examspring;

public class Main2 {
	public static void main(String[] args) {
		Calculator cal = new ProxyCalculator(new AddCalculator());
		
		int result = cal.calc(1, 3);
		System.out.println("Result: " + result);
		
	}
}
