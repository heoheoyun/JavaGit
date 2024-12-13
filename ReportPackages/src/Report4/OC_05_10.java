package Report4;

import java.util.Scanner;

class SortedArray extends BaseArray{
	public SortedArray(int size) {
        super(size);
    }

    @Override
    public void add(int value) {
        super.add(value);
        sort();
    }

    private void sort() {
        for (int i = 0; i < nextIndex - 1; i++) {
            for (int j = 0; j < nextIndex - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}


public class OC_05_10 {
	public static void main(String[] args) {
		SortedArray sArray = new SortedArray(10);
		
		Scanner scanner = new Scanner(System.in);
		System.out.print(">>");
		for(int i=0; i<sArray.length();i++) {
			int n = scanner.nextInt();
			sArray.add(n);
		}
		sArray.print();
		scanner.close();
	}
}
