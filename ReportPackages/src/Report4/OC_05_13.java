package Report4;

import java.util.Scanner;

abstract class Calc{
	protected String errorMsg;
	protected int a,b;
	abstract public void setValue(int a, int b);
	abstract public int calculate();
}

class Add extends Calc{
	@Override
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
		this.errorMsg = null;
	}

	@Override
	public int calculate() {
		return a+b;
	}
	
}

class Sub extends Calc{
	@Override
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
		this.errorMsg = null;
	}

	@Override
	public int calculate() {
		return a-b;
	}
}

class Mul extends Calc{
	@Override
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
		this.errorMsg = null;
	}

	@Override
	public int calculate() {
		return a*b;
	}
}

class Div extends Calc {
	@Override
	public void setValue(int a, int b) {
		this.a = a;
		if(b==0) { 
			this.errorMsg = "0으로 나눌 수 없음. ";
		}
		this.b = b;
	}

	@Override
	public int calculate() {
		if (b==0) return 0;
		else return a/b;
	}
}
public class OC_05_13 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("두 정수와 연산자를 입력하시오>>");
			int result;
			String errorMsg;
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			String symbol = scanner.next();
			switch (symbol) {
				case "+": {
					Calc cal = new Add();
					cal.setValue(n, m);
					result = cal.calculate();
					errorMsg = cal.errorMsg;
					break;
				}
				case "-": {
					Calc cal = new Sub();
					cal.setValue(n, m);
					result = cal.calculate();
					errorMsg = cal.errorMsg;
					break;
				}
				case "*": {
					Calc cal = new Mul();
					cal.setValue(n, m);
					result = cal.calculate();
					errorMsg = cal.errorMsg;
					break;
				}
				case "/": {
					Calc cal = new Div();
					cal.setValue(n, m);
					result = cal.calculate();
					errorMsg = cal.errorMsg;
					break;
				}
				default:{
					System.out.println("수식기호를 다시 입력해주세요.");
					continue;
				}
			}
			if(errorMsg == null) System.out.println("계산 결과 " + result);
			else {
				System.out.print(errorMsg + "프로그램 종료");
				break;
			}
		}
		scanner.close();
	}
}
