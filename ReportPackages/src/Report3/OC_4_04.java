package Report3;

class Average{
	private int nextIndex = 0;
	double sum = 0.0;
	int number[] = new int[10];
	
	void put(int number) {
		sum += number;
		this.number[nextIndex] = number;
		nextIndex++;
	}
	
	void showAll () {
		System.out.println("***** 저장된 데이터 모두 출력 *****");
		for(int i=0; i<nextIndex; i++) {
			System.out.print(number[i]+" ");
		}
		System.out.println();
	}
	double getAvg() {
		return (sum/nextIndex);
	}
}

public class OC_4_04 {
	public static void main(String[] args) {
		Average avg = new Average();
		avg.put(10);
		avg.put(15);
		avg.put(100);
		avg.showAll();
		System.out.print("평균은 "+ avg.getAvg());
	}
}
