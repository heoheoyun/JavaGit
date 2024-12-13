package Report4;

class Point3DColor extends Point{
	private int z;
	private String color;
	
	Point3DColor(int x,int y, int z, String color) {
		super(x,y);
		this.z = z;
		this.color = color;
	}
	
	public void move(Point3DColor po) {
		super.move(po.getX(), po.getY());
		this.z = po.z;
	}
	
	public String toString() { return "("+getX()+","+getY()+","+z+")"+color+ "점"; }
	
	public boolean equals(Point3DColor po){
		boolean result = (super.getX()==po.getX()&&super.getY()==po.getY()&&this.z==po.z&&this.color==po.color);
		return result;
	}
}

public class OC_05_07 {
	public static void main(String[] args) {
		Point3DColor p = new Point3DColor(10,20,30,"RED");
		System.out.println(p.toString()+"입니다.");
		
		Point3DColor q = new Point3DColor(1,2,3,"BLUE");
		p.move(q);
		System.out.println(p.toString()+"입니다.");
		
		Point3DColor r = new Point3DColor(1,2,3,"RED");
		if(p.equals(r))	System.out.println("예. 같은 위치 같은 색깔의 점입니다.");
		else System.out.println("아니오");
	}
}
