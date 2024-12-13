package Report2;

//p168 10번

import java.util.Scanner;

public class OC_3_10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int threshold;
		
		System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
		
		int n[][] = new int[4][4];
		
		for(int i=0; i<n.length;i++) {
			for(int j=0; j<n[i].length; j++) {
				n[i][j]=(int)(Math.random()*256);
				System.out.print(n[i][j]);
				System.out.print("\t");
				}
			System.out.println();
		}
		
		System.out.print("임계값 입력>>");
		threshold = scanner.nextInt();
		
		for(int i=0; i<n.length;i++) {
			for(int j=0; j<n[i].length; j++) {
				if (n[i][j]>threshold) {
					n[i][j] = 255;
					System.out.print(n[i][j]);
					System.out.print("\t");
				}
				else {
					n[i][j] = 0;
					System.out.print(n[i][j]);
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	scanner.close();
	}
}
