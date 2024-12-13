package Report4;

class PositivePoint extends Point{

	PositivePoint (int x, int y) {
		super(1, 1);
		if(x>=0&&y>=0) {
			super.move(x, y);	
		}
	}

	public void move(int x, int y) {
		if(x>=0&&y>=0)
			super.move(x, y);
	}

	public String toString() {
		return ("("+super.getX()+","+super.getY()+")의 점");
	}
}

public class OC_05_06 {
	public static void main(String[] args) {
		PositivePoint p = new PositivePoint(10,10); // 10,10의 점
		p.move(5,5);
		System.out.println(p.toString()+"입니다.");
		
		p.move(2,-2); // 점 p는 양수 공간만 가능. 그러므로 이동 없음
		System.out.println(p.toString()+"입니다.");
		
		PositivePoint q = new PositivePoint(-10, -10); // 음수 점 불가. 디폴트 (1,1)점 생성
		
		System.out.println(q.toString()+"입니다.");
	}
}
