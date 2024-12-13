package Report2;

//p168 8번

import java.util.Scanner;

public class OC_3_08 {
	public static void main(String[] args) {
		int ar, sum = 0, random, overlap=0;
		
		System.out.print("정수 몇 개 저장하시겠습니까>>");
		Scanner scanner = new Scanner(System.in);
		ar = scanner.nextInt();		
		int n[] = new int[ar];
		
		System.out.print("랜덤한 정수들...");
		
		for(int i=0;i<n.length;i++) {
			random = (int)(Math.random()*100+1);
			for(int j=0; j<=i; j++) {
				if(n[j]==random) {
					overlap++;
					break;
				}
			}
			if (overlap==0) {
				n[i] = random;
				System.out.print(n[i]+ " ");
				sum += random;
			}
			else {
				i--;
				overlap=0;
			}
		}
		System.out.println();
		System.out.println("평균은 "+((double)sum/n.length));
		scanner.close();
	}
}
