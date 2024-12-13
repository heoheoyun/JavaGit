package Report4;

interface ShapeN{
	final double PI = 3.14;
	void draw();
	double getArea();
	default public void redraw() {
		System.out.print("--- 다시 그립니다. ");
		draw();
	}
}

class CircleN implements ShapeN{
	private int radius;
	
	CircleN(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.print("반지름이 " + radius + "인 원");
		System.out.println();
	}

	@Override
	public double getArea() {
		return radius*radius*PI;
	}
	
}

class OvalN implements ShapeN{
	private int width , height;
	
	OvalN(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw() {
		System.out.print(width +"x" + height + "에 내접하는 타원");
		System.out.println();
	}

	@Override
	public double getArea() {
		return (PI*width*height)/4;
	}
	
}

class RectN implements ShapeN{
	private int width, height;
	
	RectN(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw() {
		System.out.print(width +"x" + height + "크기의 사각형");
		System.out.println();
	}

	@Override
	public double getArea() {
		return width*height;
	}
	
}

public class OC_05_15 {
	public static void main(String[] args) {
		ShapeN [] list = new ShapeN[3];
		list[0] = new CircleN(5);
		list[1] = new OvalN(20, 30);
		list[2] = new RectN(10, 40);
		for(int i=0; i<list.length; i++) list[i].redraw();
		for(int i=0; i<list.length; i++) System.out.println("면적은 "+ list[i].getArea());
	}
}
