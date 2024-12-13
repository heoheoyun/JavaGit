package Report1;

import java.util.Scanner;

public class dollor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dollor;
		long won;
		
		System.out.print("$1=1200원입니다. 달러를 입력하세요>>");
		dollor = scanner.nextInt();
		won = dollor * 1200;
		
		System.out.println("$"+dollor+"는 "+won+"원입니다.");
		scanner.close();
	}
}
