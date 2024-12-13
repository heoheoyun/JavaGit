package Report4;

class ColorPoint2 extends Point{
	private String color;
	
	ColorPoint2() {
		super(0, 0);
		this.color = "WHITE";
	}
	
	ColorPoint2(int x, int y){
		super(x, y);
		this.color = "BLACK";
	}
	
	ColorPoint2(int x, int y, String color){
		super(x, y);
		this.color = color;
	}
	
	void set(String color) { this.color = color; }
	void set(int x, int y) { super.move(x, y); }
	
	public String toString() { return (color+"색의 "+"("+getX()+","+getY()+")의 점"); }
	
	double getDistance(ColorPoint2 cp) {
		int dX, dY;
		dX = super.getX() - cp.getX();
		dY = super.getY() - cp.getY();
		double Distance = Math.sqrt(dX*dX + dY*dY);
		return Distance;
	}
}

public class OC_05_04 {
	public static void main(String[] args) {
		ColorPoint2 zeroPoint = new ColorPoint2();
		System.out.println(zeroPoint.toString() + "입니다.");
		
		ColorPoint2 cp = new ColorPoint2(10, 10, "RED");
		
		cp.set("Blue");
		cp.set(10,20);
		System.out.println(cp.toString()+"입니다.");
		
		ColorPoint2 thresholdPoint = new ColorPoint2(100,100);
		System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
	}
}
