package Report3;

import java.util.Scanner;

class Grade {
	private String name;
	private int java, web, os;
	
	Grade (String name, int java, int web, int os) {
		this.name = name;
		this.java = java;
		this.web = web;
		this.os = os;
	}
	
	String getName() {
		return name;
	}
	
	double getAverage() {
		return (java+web+os)/3;
	}
}

public class OC_4_03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력");
		String name = scanner.next();
		int java = scanner.nextInt();
		int web = scanner.nextInt();
		int os = scanner. nextInt();
		Grade st = new Grade(name, java, web, os);
		System.out.print(st.getName()+ "의 평균은 "+ st.getAverage());
		scanner.close();
		
	}
}