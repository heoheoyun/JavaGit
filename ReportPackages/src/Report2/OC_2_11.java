package Report2;

//p113 11번

import java.util.Scanner;

public class OC_2_11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String state;
		System.out.print("냉장고 상태 입력>> ");
		state = scanner.next();
		byte stateTo2 = Byte.parseByte(state,2);
		
		if((stateTo2 & 0b00000001) == 0)
			System.out.print("전원 꺼져 있음. ");
		else 
			System.out.print("전원 켜져 있음. ");
		
		if((stateTo2 & 0b00000010) == 0)
			System.out.print("문 열려 있음. ");
		else 
			System.out.print("문 닫혀 있음. ");
		
		if((stateTo2 & 0b00000100) == 0)
			System.out.print("전구 손상 상황. ");
		else 
			System.out.print("전구 정상 작동. ");
		
		if((stateTo2 & 0b00001000) == 0)
			System.out.print("냉장고 온도 3도 이상. ");
		else 
			System.out.print("냉장고 온도 3도 미만. ");
		scanner.close();
	}
}
