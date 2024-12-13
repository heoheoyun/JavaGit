package Report3;

import java.util.Scanner;

class DayDiary {
	private String content;
	void set(String work) {this.content = work;}
	String get() {return content;}
}

class MonthDiary {
	private int year,month;
	DayDiary[] dayDiary = new DayDiary[30];
	
MonthDiary(int year, int month) {
	this.year = year;
	this.month = month;
	for (int i=0; i<dayDiary.length;i++) {
		dayDiary[i] = new DayDiary();
		dayDiary[i].set("...");
	}
}

void getMenu() {
	Scanner scanner = new Scanner(System.in);
	System.out.print("기록:1, 보기:2, 종료:3>>");
	int n = scanner.nextInt();
	switch (n) {
		case 1: {	
			int day;
			String wContent;
			System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
			while(true) {
				day = scanner.nextInt();
				wContent = scanner.next();
				scanner.nextLine();
				if(wContent.length()==0)
					wContent = "";
				if(wContent.length()<=4) 
					break;
				else
					continue;
			}
			dayDiary[day-1].set(wContent);
			break;
		}
		case 2:{
			this.show();
			break;
		}
		case 3:{
			System.out.println("프로그램을 종료합니다.");
			break;
		}
		default:
			System.out.println("1,2,3 중에 입력해주세요!");
			break;
		}	
	if(n!=3)
		this.getMenu();
	scanner.close();
	}
	
void show() {
	for(int i=0; i<dayDiary.length; i++) {
		System.out.print(dayDiary[i].get()+"\t");
		if((i%7)-6==0)
			System.out.println();
	}
	System.out.println();
}

void run() {
	System.out.println("***** "+year+"년 "+month+"월 다이어리 *****");
	this.getMenu();
}

}

public class OC_4_10 {
	public static void main(String[] args) {
		MonthDiary monthDiary = new MonthDiary(2024, 10);
		monthDiary.run();	
	}
}
