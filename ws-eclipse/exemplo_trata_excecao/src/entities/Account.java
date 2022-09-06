package entities;

public class Account {

	int number;
	String holder;
	double balance;
	double withdrawLimit;
	
	public Account() {
	}
	public Account(int number, String holder, double balance, double withdrawLimit) {		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getWithdrawLimit() {
		return withdrawLimit;
	}
	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	
	public void deposit (double amount) throws Exception {		
		this.balance += amount;
	}
	
	public void withdraw (double amount)  throws Exception {
		if(this.balance < amount) {
			throw new Exception("balance unavailable");
		}
		if(this.withdrawLimit < amount) {
			throw new Exception("Exceded limit of withdraw");
		}
		this.balance -= amount;
	}
	
	@Override
	public String toString() {
		return "Account [number=" + number + ", holder=" + holder + ", balance=" + balance + ", withdrawLimit="
				+ withdrawLimit + "]";
	}
		
	
	
}
