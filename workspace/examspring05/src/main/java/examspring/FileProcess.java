package examspring;

public class FileProcess {

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
	
}
