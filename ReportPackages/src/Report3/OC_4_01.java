package Report3;

class TV {
		private String name;
		private int inch, price;
		TV(String name, int inch, int price) {
			this.name = name;
			this.inch = inch;
			this.price = price; 
		}
		void show() {
			System.out.println(name+"에서 만든 "+ price +"만원짜리의 " + inch + " TV");
		}
}
		
public class OC_4_01 {
	public static void main(String[] args) {
	TV tv = new TV("Samsung", 50, 300); // 300만원 짜리 Samsung에서 만든 50인치 TV
	tv.show();
	}
}
