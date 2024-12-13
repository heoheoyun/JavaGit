package Report2;

//p166 1번문제

// 1. 시작값이 1인 i에 3씩 더해 50이 되기전까지 값을 더한 sum을 계산하는 코드, 425

public class WhileLoop {
	public static void main(String[] args) {
		int sum=0, i=1;
		while (true) {
			if (i>50)
				break;
			sum += i;
			i += 3;
		}
	System.out.println(sum);
	}
} 
