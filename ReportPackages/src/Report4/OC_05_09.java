package Report4;

import java.util.Scanner;

class BaseArray{
	protected int array [];
	protected int nextIndex = 0;
	public BaseArray(int size) {
		array = new int [size];
	}
	public int length() { return array.length; }
	public void add(int n) {
		if (nextIndex == array.length) return;
		array[nextIndex] = n;
		nextIndex ++;
	}
	public void print() {
		for(int n : array) System.out.print(n + " ");
		System.out.println();
	}
}

class BinaryArray extends BaseArray{
	private int threshold;
	
	public BinaryArray(int size, int threshold) {
		super(size);
		this.threshold = threshold;
	}
	
	@Override
	public void add(int n) {
		if (nextIndex == array.length) return;
		if (threshold<n)
			array[nextIndex] = 1;
		else
			array[nextIndex] = 0;
		nextIndex ++;
	}
	
	public void print() {
		for(int n : array) System.out.print(n + " ");
		System.out.println();
	}
}

public class OC_05_09 {
	public static void main(String[] args) {
		int threshold = 50;
		BinaryArray bArray = new BinaryArray(10, threshold);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print(">>");
		for(int i=0; i<bArray.length();i++) {
			int n = scanner.nextInt();
			bArray.add(n);
		}
		bArray.print();
		scanner.close();
	}
}
