package Report3;

class Cube{
	private int width, length, height;
	
	Cube(int width, int length, int height){
		this.width = width;
		this.length = length;
		this.height = height;
	}
	
	int getVolume() {
		return width*length*height;
	}
	
	void increase(int w, int l, int h) {
		width += w;
		length += l;
		height +=h;
	}
	
	boolean isZero(){
		return (width*length*height)==0;
	}
}



public class OC_4_02 {
	public static void main(String[] args) {
		Cube cube = new Cube(1,2,3); 	// 가로, 세로, 높이가 각각 1,2,3인 객체 생성
		System.out.println("큐브의 부피는 " + cube.getVolume());
		cube.increase(1,2,3); 	// 가로, 세로, 높이가 각각 1,2,3 씩 증가
		System.out.println("큐브의 부피는 " + cube.getVolume());
		if (cube.isZero())
			System.out.println("큐브의 부피는 0");
		else
			System.out.println("큐브의 부피는 0이 아님");
	}
}
