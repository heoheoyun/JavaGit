package Report5;

import java.util.Scanner;
import java.util.Vector;

public class OC_7_01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vector<Integer> v = new Vector<Integer>();
		
		System.out.print("정수 입력(-1이면 입력 끝)>>");
		while(true) {
			int n = sc.nextInt();
			if(n==-1) break;
			if(n<0) continue;
			v.add(n);
		}
		sc.close();
		
		int min = v.firstElement();
		for(int i=0; i<v.size();i++) {
			Integer n = v.get(i);
			if(min > n) min = n;
		}
		System.out.println("제일 작은 수는 " + min);
	}
}
