package examspring02;


public class FileProcess{

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


	public void close() throws Exception {
		System.out.println("close() 소멸 메소드");
	}


	public void open() throws Exception {
		System.out.println("open() 초기화메소드 동작");
	}
	
}
