package Report2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OC_3_17 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	String coffee[] = {"핫아메리카노", "아이스아메리카노","카푸치노", "라떼"};
	int price[] = {3000, 3500, 4000, 5000};
	
	System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");
	
	while (true) {
		int howMuch = 0;
		System.out.print("주문>>");
		String menu = scanner.next();
		if (menu.equals("그만")) {
			break;
		}
		
		try {
			howMuch = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("잔 수는 양의 정수로 입력해주세요.");
			continue;
		}
		
		int index = -1;
		
		for(int i=0; i<coffee.length;i++) {
			if(coffee[i].equals(menu)) 
				index = i;
		}
		
		if  (index >= 0) 
			System.out.println( "가격은 " + price[index]* howMuch + "원입니다.");
		else 
			System.out.println( menu +"은 없는 메뉴입니다.");
		
	}
	scanner.close();
	}
}
