package Report4;

class Point3D extends Point{
	private int z = 0;
	
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	void moveUp(int z) { this.z += z; }
	void moveDown(int z) { this.z -= z; }
	void move(int x, int y, int z) { super.move(x, y); this.z = z; }
	
	public String toString() {
		return ("("+super.getX()+","+super.getY()+","+this.z+")의 점");
	}
}

public class OC_05_05 {
	public static void main(String[] args) {
		Point3D p = new Point3D(3, 2, 1);
		System.out.println(p.toString() + "입니다.");
		
		p.moveUp(3);
		System.out.println(p.toString() + "입니다.");
		p.moveDown(2);
		System.out.println(p.toString() + "입니다.");
		p.move(5, 5);
		System.out.println(p.toString() + "입니다.");
		p.move(100, 200, 300);
		System.out.println(p.toString() + "입니다.");
	}
}
