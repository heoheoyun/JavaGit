package Report2;

//p168 11번

import java.util.Scanner;

public class OC_3_11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int mistake = 0;
		
		System.out.println("***** 구구단을 맞추는 퀴즈입니다. *****");
		
		while (true) {
			int a = (int)(Math.random()*9+1);
			int b = (int)(Math.random()*9+1);
			System.out.print(a+"x"+b+"=");
			int answer = scanner.nextInt();
			if(answer == (a*b)) {
				System.out.println("정답입니다. 잘했습니다.");
			}
			else {
				mistake++;
				System.out.print(mistake+"번 틀려습니다. ");
				if (mistake >2) {
					System.out.println("퀴즈를 종료합니다.");
					break;
				}
				else {
					System.out.println("분발하세요.");
				}
			}	
			
		}
		scanner.close();
	}
}
