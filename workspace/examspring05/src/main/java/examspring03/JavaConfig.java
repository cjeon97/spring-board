package examspring03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {

	@Bean(initMethod = "open", destroyMethod = "destroy")
	@Scope("prototype")
	public FileProcess fileProcess() {
		System.out.println("fileProcess");
		FileProcess fp = new FileProcess();
		fp.setFile("C:\\save");
		return fp;
	}
	
	@Bean(destroyMethod = "destroy")
	public FileProcess fileProcess2() {
		System.out.println("fileProcess2");
		FileProcess fp = new FileProcess();
		fp.setFile("D:\\save");
		return fp;
	}
	
}
