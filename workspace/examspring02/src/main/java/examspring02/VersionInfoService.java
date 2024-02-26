package examspring02;

public class VersionInfoService {
	private int major;
	private int minor;
	
	public void setMajorVersion(int major) {
		this.major = major;
	}
	
	public void setMinorVersion(int minor) {
		this.minor = minor;
	}
	
	public void versionPrint() {
		System.out.printf("프로그램 버전: v%d.%d\n", major, minor);
	}

}
