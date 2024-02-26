package examspring;

public class Main {
	public static void main(String[] args) {
		Calculator cal = new AddCalculator();
		int result = cal.calc(1,1);
		
		System.out.println("Result: " + result);
		
	}
}
