package Report2;

//p172 16번

import java.util.Scanner;

public class OC_3_16 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);	
		
		System.out.print("양의 정수를 입력하세요. -1은 입력 끝>>");
		
		String Array[] = {""};
		
		for(int n=0;n<Array.length;n++) {
			Array[n] = scanner.next();
			if (Array[n].equals("-1")) {
				break;
			}
		}
		
		int i = 0, sum = 0, index = 0;
		
		try {
			for(i=0; i<Array.length;i++ ) {
				if (Integer.parseInt(Array[i])>0) {
					sum+= Integer.parseInt(Array[i]);
					index++;
				}
				else if (Integer.parseInt(Array[i]) != -1) {
					System.out.println(Array[i] + " 제외");
				}
			}	
		} catch (NumberFormatException e) {
			System.out.println(Array[i] + " 제외");
		}	
		
		
	    System.out.println("평균은 "+ (sum/index));
		scanner.close();
	}
}
