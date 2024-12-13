package Report2;

//p170 14번

import java.util.Scanner;

public class OC_3_14 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("***** 갬블링 게임을 시작합니다. *****");
		
		String question = "";
		
		while (true) {
			System.out.print("엔터키 입력>>");
			scanner.nextLine();
			
			int a = (int)(Math.random()*3);
			int b = (int)(Math.random()*3);
			int c = (int)(Math.random()*3);
			
			System.out.println(a+" "+b+" "+c);
			
			if ((a==b)&&(b==c)) {
				System.out.println("성공! 대박났어요!");
			System.out.print("계속하시겠습니까?(yes/no)>>");	
				while (true) {
				question =  scanner.nextLine();
				
				if(question.equals("yes")||question.equals("no"))
					break;
				}
				
				if(question.equals("no")) {
					System.out.print("게임을 종료합니다.");
					break;
				}
			}
				
		}
		scanner.close();	
	}
}
