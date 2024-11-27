package bankingSystem;
public class Account extends Customer {
	private int accountNumber;
	private int balance;
	

	public Account(String fname, String lname, int accNumber, int accBal) {
		super(fname, lname);
		this.accountNumber=accNumber;
		this.balance=accBal;
	}
	public int getAccountNum() {
		return accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	
	
	public void deposit(int amount) {
			balance += amount;
	}
	public boolean withdraw(int amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		}
		else {
			System.out.println("Insufficient funds.");
			return false;
		}
	}


}