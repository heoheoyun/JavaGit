package Report2;

//p168 9번

public class OC_3_09 {
	public static void main(String[] args) {
		System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
		
		int n[][] = new int[4][4];
		
		for(int i=0; i<n.length;i++) {
		for(int j=0; j<n[i].length; j++) {
			n[i][j]=(int)(Math.random()*256);
			System.out.print(n[i][j]);
			System.out.print("\t");
			}
		System.out.println();
		}
	}
}
