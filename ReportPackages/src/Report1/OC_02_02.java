package Report1;

import java.util.Scanner;

public class OC_02_02 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		long ymd;
		long year;
		long month;
		long day;
	
		System.out.print("생일 입력 하세요>>");
		ymd = scanner.nextLong();
		year = ymd/10000;
		month = (ymd%10000)/100;
		day = ymd%100;
		System.out.println(year+"년 "+month+"월 "+day+"일");
		scanner.close();
	}
}
