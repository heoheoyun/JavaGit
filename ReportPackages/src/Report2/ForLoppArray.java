package Report2;

//p166 2번문제

//1. 배열 n에 저장된 값중 0보다 크면서 4의 배수인 값들을 계산하는 코드, 20 72 256

public class ForLoppArray {
	public static void main(String[] args) {
		int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
		for(int i=0; i<n.length; i++) {
			if(n[i]>0 && n[i] % 4 == 0) {
				System.out.print(n[i] + " ");
			}
		}
	}
}
