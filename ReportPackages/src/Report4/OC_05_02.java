package Report4;

class SmartTV extends ColorTV{
	private String ip;
	
	public SmartTV (String ip, int size, int color) {
		super(size, color);
		this.ip = ip;
	}
	public void printProperty() {
		System.out.println("나의 smartTV는 "+ip + "주소의 "+getSize()+"인치 "+getColor()+"컬러");
	}
}

public class OC_05_02 {
	public static void main(String[] args) {
		SmartTV smartTV = new SmartTV("192.168.0.5", 77,20000000);
		smartTV.printProperty();
	}
}
