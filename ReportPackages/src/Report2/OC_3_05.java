package Report2;

//p167 5번

import java.util.Scanner;

public class OC_3_05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n[] = new int[10], number;
		System.out.print("양의 정수 10개 입력");
		for(int i=0; i<n.length; i++) {
			System.out.print(">>");
			number = scanner.nextInt();
			if(number<1)
				i--;
			n[i] = number;
		}
		System.out.print("3의 배수는...");
		for(int i=0; i<n.length; i++) {
			if(n[i]%3==0)
				System.out.print(n[i]+" ");
		}
		scanner.close();
	}
}
