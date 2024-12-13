package Report3;

class ArrayUtil{
	static int[] concat(int[] a, int[] b) {
		int c[] = new int[a.length+b.length-1];
		for(int i=0; i<a.length; i++) {
			c[i] = a[i];
			}
		for(int i=0; i<b.length; i++) {
			c[i+a.length-1] = b[i];
		}
		
		return c;
	}
	public static void print(int[] a) {
		System.out.print("[ ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.print("]");
	}
}

public class OC_4_11 {
	public static void main(String[] args) {
		int [] array1 = { 1, 5, 7, 9};
		int [] array2 = { 3, 6, -1, 100, 77};
		int [] array3 = ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);
	}
}
