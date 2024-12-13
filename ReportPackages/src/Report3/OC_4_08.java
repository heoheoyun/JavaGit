package Report3;

class Account{
	private int Balance = 0;
	
	Account(int Meony){
		this.Balance += Meony;
	}
	
	void deposit(int Meony){
		this.Balance += Meony;
	}
	
	void deposit(int[] arr) {
		for(int i=0; i<arr.length;i++) {
			this.Balance += arr[i];
		}
	}
	
	int getBalance() {
		return Balance;
	}
	
	int withdraw(int Money){
		if(this.Balance < Money) {
			this.Balance -= this.Balance;
			return this.Balance;
		}
		else {
			this.Balance -= Money;
			return Money;
		}
	}
}


public class OC_4_08 {
	public static void main(String[] args) {
		Account a = new Account(100);
		a.deposit(5000);
		System.out.println("잔금은"+ a.getBalance()+"원 입니다.");
		
		int bulk[] = { 100, 500, 200, 700 };
		a.deposit(bulk);
		System.out.println("잔금은"+ a.getBalance()+"원 입니다.");
		
		int money = 1000;
		int wMoney = a.withdraw(money);
		if (wMoney < money)
			System.out.println(wMoney + "원만 인출");
		else
			System.out.println(wMoney + "원 인출");
		
		System.out.println("잔금은"+ a.getBalance()+"원 입니다.");

	}
}
