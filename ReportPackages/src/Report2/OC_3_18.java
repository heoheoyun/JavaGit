package Report2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OC_3_18 {
	public static void main(String[] args) {
		
		int number[] = new int[10];
		int score[] = new int[10];		
		
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		System.out.println("10명의 학생의 학번과 점수 입력");
		
		int n = -1, s = 101;
		
		
		for (i=0; i<number.length; i++) {
			System.out.print((i+1)+">>");
			try {
				n = scanner.nextInt();
				s = scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner.nextLine();
				i--;
				System.out.println("학번과 점수를 양의 정수로 입력해주세요.");
			}	
			for(int j=0; j<i;j++) {
				if(n==number[j]) {
					i--;
					System.out.println("학번이 중복되었습니다. 중복학번:" + number[j]);
					continue;
				}
			}
			if(s>100) {
				i--;
				System.out.println("점수는 100점을 초과할 수 없습니다.");
				continue;
			}
			if ( n<0 || s<0 ) {
				i--;
				System.out.println("학번과 점수를 양의 정수로 입력해주세요.");
				continue;
			}
			number[i] = n;
			score[i] = s;
			scanner.close();
		}
		Scanner scanner2 = new Scanner(System.in);
		while (true) {
			System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
			int serach = 0, answer = 0, index = -1;
			try {
				answer = scanner2.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("1,2,3 중에 입력해주세요.");
			}
			switch (answer) {
				case 1: 
					System.out.print("학번>>");
					try {
						serach = scanner2.nextInt();
						if (serach>0) {
							for(i=0; i<number.length;i++) {
								if(number[i] == serach) 
									index = i;
							}
							if(index>0)
								System.out.println(score[index]+"점");
							else {
								System.out.println(serach+"의 학생은 없습니다.");
							}
						}
						else {
							System.out.println("양의 정수를 입력하세요!");
						}
					} catch (InputMismatchException e) {
						System.out.println("경고!! 정수를 입력하세요!");
					}
				case 2:
					System.out.print("점수>>");
					try {
						serach = scanner2.nextInt();
						if (serach>0) {
							System.out.print("점수가 "+serach+"인 학생은");
							for(i=0; i<score.length;i++) {
								if(score[i] == serach) {
									System.out.print(score[i]);
									index += (i+1);
								}
							}
							if(index<0) {
								System.out.println(" 없습니다.");
							}
						}
						else {
							System.out.println("양의 정수를 입력하세요!");
						}	
					} catch (InputMismatchException e) {
						System.out.println("경고!! 정수를 입력하세요!");
					}
				case 3:
					break;
				default:
					System.out.println("1,2,3 중에 입력해주세요.");
					continue;
			}		
			scanner2.close();	
		}
	}
}
