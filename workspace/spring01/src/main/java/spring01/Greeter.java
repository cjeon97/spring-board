package spring01;

public class Greeter {
	
	private String format;
	
	public Greeter() {
		System.out.println("Greeter Constructor");
	}
	
	public String greet(String guest) {
		return String.format(format, guest);
	}
	
	public void setFormat(String format) {
		System.out.println("setFormat function");
		this.format = format;
	}
	
}
