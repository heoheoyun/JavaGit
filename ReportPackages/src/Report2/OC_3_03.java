package Report2;

//p167 3번

import java.util.Scanner;

public class OC_3_03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		
		for(int i=0;i<1;i--) {
			System.out.print("양의 정수 입력>>");
			number = scanner.nextInt();
			if(number>0)
				break;
		}
		for(int i = number; i>0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		scanner.close();
	}
}
