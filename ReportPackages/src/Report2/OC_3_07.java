package Report2;

//p167 7번

public class OC_3_07 {
	public static void main(String[] args) {
		int n[] = new int[10], sum = 0, random;
		
		System.out.print("랜덤한 정수들...");
		
		for(int i=0;i<n.length;i++) {
			random = (int)(Math.random()*9)+11;
			n[i] = random;
			System.out.print(n[i]+ " ");
			sum += random;
		}
		System.out.println();	
		System.out.println("평균은 "+(sum/n.length));
	}
}
