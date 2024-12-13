package Report1;

import java.util.Scanner;

public class OC_02_04 {
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	
	int people;
	int days;
	long airfare;
	long roomPay;
	int needRoom;
	long totalPay;
	
	System.out.print("여행지>>");
	String place = scanner.nextLine();
	
	System.out.print("인원수>>");
	people = scanner.nextInt();
	
	System.out.print("숙박일>>");
	days = scanner.nextInt();
	
	System.out.print("1인당 항공료>>");
	airfare = scanner.nextInt();
	
	System.out.print("1방 숙박비>>");
	roomPay = scanner.nextInt();
	
	if(people%2==0) {
		needRoom = people /2; 
	}	
	else {
		needRoom = people/2 +1;
	}
	
	totalPay = people * airfare + days * needRoom * roomPay;
	
	System.out.println(people+"명의 "+place+" " +days+"박 "+ (days+1)+"일 여행에는 방이 "
					   +needRoom+"개 필요하며 경비는 "+ totalPay +"원입니다.");
	scanner.close();
	}
}
