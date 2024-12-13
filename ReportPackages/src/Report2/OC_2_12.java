package Report2;

//p114 12번

import java.util.Scanner;

public class OC_2_12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int state;
		int temp;
		
		System.out.print("자동차 상태 입력>> ");
		
		state = scanner.nextInt();
		temp = state%32;		
		
		if((state & 0b10000000) == 0)
			System.out.print("자동차는 정지 상태이고 ");
		else 
			System.out.print("자동차는 달리는 상태이고 ");
		
		if((state & 0b01000000) == 0)
			System.out.print("에어컨이 꺼진 상태이고 ");
		else 
			System.out.print("에어컨이 켜진 상태이고 ");
		
		System.out.println("온도는 "+temp+"도이다.");
		
		scanner.close();
	}
}
