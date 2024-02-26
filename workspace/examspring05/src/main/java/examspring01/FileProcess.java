package examspring01;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class FileProcess implements InitializingBean, DisposableBean{

	private String file;
	
	public FileProcess() {
		System.out.println("FileProcess() Constructor");
	}
	
	public void setFile(String file) {
		System.out.println("FileProcess.setFile() executed");
		this.file=file;
	}
	
	public void write(String data) {
		System.out.println(data + "를 " + file + "에 저장");
	}

	@Override // DisposableBean
	public void destroy() throws Exception {
		System.out.println("destroy() 소멸 메소드");
	}

	@Override // InitializingBean
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() 초기화메소드 동작");
	}
	
}
