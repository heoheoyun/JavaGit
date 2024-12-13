package Report2;

//p171 15번 문제

import java.util.InputMismatchException;

import java.util.Scanner;

public class OC_3_15 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int a, b;
		while (true) {
			System.out.print("곱하고자 하는 정수 2개 입력>>");
			try {
				a = scanner.nextInt();
				b = scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				
				System.out.println("정수를 입력하세요!");
				continue;
			}	
		System.out.println( a + "x" + b + "=" + a*b);
		break;
		}
		scanner.close();
	}
}
