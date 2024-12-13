package Report2;

//p170 13번

import java.util.Scanner;

public class OC_3_13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String course[] = {"C", "C++", "Python", "Java", "HTML5"};
		String grade[] = {"A", "B+", "B", "A+", "D"};
		
		while (true) {
			System.out.print("과목>>");
			String courseName = scanner.nextLine();
			
			if (courseName.equals("그만"))
				break;
			
			int index = -1;
			 
			for(int i=0; i<course.length;i++) {
				if(course[i].equals(courseName)) 
					index = i;
			}
			
			if  (index >= 0) 
				System.out.println( course[index] + " 학점은 " + grade[index]);
			else 
				System.out.println( courseName +"는 없는 과목입니다.");
		}
		scanner.close();
	}
}
