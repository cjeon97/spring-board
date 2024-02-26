package aop15;

public class Target {
	public Integer process(String param) {
		System.out.println(param + "전달받아 핵심 기능 동작");
		return 100;
	}
}
