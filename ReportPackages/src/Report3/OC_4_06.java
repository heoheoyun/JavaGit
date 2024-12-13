package Report3;

class Rectangle {
	private int x,y,width,height;
	
	Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	boolean isSquare() {
		return width==height;
	}
	
	boolean contains(Rectangle r) {
		return this.x <= r.x && this.y <= r.y && (this.x + this.width) >= (r.x + r.width) && (this.y + this.height) >= (r.y + r.height);
	}
	
	void show(){
		System.out.println("("+x+","+y+")에서 크기가 "+width+"x"+height+"인 사각형");
	}
}

public class OC_4_06 {
	public static void main(String[] args) {
		Rectangle a = new Rectangle(3, 3, 6, 6);
		Rectangle b = new Rectangle(4, 4, 2, 3);
		
		a.show();
		if(a.isSquare()) System.out.println("a는 정사각형 입니다.");
		else System.out.println("a는 직사각형 입니다.");
		if(a.contains(b)) System.out.println("a는 b를 포함합니다.");
	}

}
