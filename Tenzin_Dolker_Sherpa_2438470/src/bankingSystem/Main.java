package bankingSystem;
import java.util.*;


public class Main {
	public static void main(String[] args) {
      //part1
//		Account acc1 = new Account("Jeffrey","Ting",1,2000);
//		Account acc2 = new Account("Hiran","Patel",2,1000);
//		System.out.println("Part 1");
//		System.out.println("");
//		
//		System.out.println("Account 1 balance: "+acc1.getBalance());
//		System.out.println("Account 2 balance: "+acc2.getBalance());
//		System.out.println("");
//		
//		acc1.deposit(250);
//		System.out.println("Account 1 balance after deposit: "+acc1.getBalance());
//				
//		acc2.withdraw(500);
//		System.out.println("Account 2 balance after withdrawal: " + acc2.getBalance());
//		System.out.println("");
//
//		int transferAmount = 250;
//		if (Transaction.transfer(acc1, acc2, transferAmount)) {
//			System.out.println("Transfer of " + transferAmount + " from Account 1 to Account 2 successful.");
//		} 
//		else{
//			System.out.println("Transfer failed.");
//		}
//		System.out.println("");
//		System.out.println("Account 1 balance: "+acc1.getBalance());
//		System.out.println("Account 2 balance: "+acc2.getBalance());
//		        
//		
		System.out.println("Part 2");
		System.out.println("");
		String file = "C:\\Users\\Admin\\eclipse-workspace\\Tenzin_Dolker_Sherpa_2438470\\Accounts.csv";
		ReadAccounts readAccounts = new ReadAccounts(file);
		LinkedList<String> firstNames = readAccounts.getFirstNames();
		LinkedList<String> lastNames = readAccounts.getLastNames();
		LinkedList<Integer> accountList = readAccounts.getAccountNumbers();
		LinkedList<Integer> balanceList = readAccounts.getBalances();

		LinkedList<Account> accounts = new LinkedList<>();

		for (int i = 0; i < firstNames.size(); i++) {
			Account account = new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i));
		    accounts.add(account);
		}

		for (Account account : accounts) {
			System.out.println("Account Details:");
			System.out.println("");
		    System.out.println("First Name: " + account.getFirstName());
		    System.out.println("Last Name: " + account.getLastName());
		    System.out.println("Account Number: " + account.getAccountNum());
		    System.out.println("Balance: " + account.getBalance());
		    System.out.println();
		}
	}
}
