package Report1;

import java.util.Scanner;

public class Rect {
	public static void main(String[] args) {
		int x1=10 ,y1=10, x2=200, y2=300;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("두 정수 입력");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		if((x2>x && x>x1)&&(y2>y && y>y1)) System.out.println("사각형 안에 있습니다.");
		else if((x2>=x && x>=x1)&&(y1==y||y2==y)) System.out.println("선상에 있습니다.");
		else if((y2>=y && y>=y1)&&(x1==x||x2==x)) System.out.println("선상에 있습니다.");
		else System.out.println("사각형 밖에 있습니다.");
		
		scanner.close();
	}
}
