package Report1;

import java.util.Scanner;

public class OC_02_03 {
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	int dbk;
	int kml;
	int jm;
	long total;
	
	System.out.println("**** 자바 분식입니다. 주문하면 금액을 알려드립니다.");
	System.out.print("떡볶이 몇 인분>>");
	dbk = scanner.nextInt();
	System.out.print("김말이 몇 인분>>");
	kml = scanner.nextInt();
	System.out.print("쫄면 몇 인분>>");
	jm = scanner.nextInt();
	
	total = dbk * 2000 + kml * 1000 + jm * 3000; 
	
	System.out.println("전체 금액은 "+total+"원입니다.");
	scanner.close();
	}
}
