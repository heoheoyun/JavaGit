package Report2;

//p167 6번

import java.util.Scanner;

public class OC_3_06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n[] = new int[10], number,sum=0,digit=0;
		System.out.print("양의 정수 10개 입력>>");
		for(int i=0; i<n.length; i++) {
			number = scanner.nextInt();
			if(number<1)
				i--;
			n[i] = number;
		}
		System.out.print("자리수의 합이 9인 것은...");
		for(int i=0; i<n.length; i++) {
			digit = n[i];
			while(true) {
				sum += digit%10;
				if(digit/10==0)
					break;
				digit /=10;
			}
			if(sum%9==0)
				System.out.print(n[i]+" ");
			digit = 0;
			sum = 0;
		}
		scanner.close();
	}
}
