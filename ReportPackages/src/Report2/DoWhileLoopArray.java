package Report2;

//p166 2번문제

public class DoWhileLoopArray {
	public static void main(String[] args) {
		int n[] = {1, -2, 6, 20, 5, 72, -16, 256}, i=0;
		do {
			if(n[i]>0 && n[i] % 4 == 0) {
				System.out.print(n[i] + " ");
			}
			i++;
		} while (i<n.length);
	}
}
