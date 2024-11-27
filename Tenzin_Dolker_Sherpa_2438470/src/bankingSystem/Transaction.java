package bankingSystem;
public class Transaction {

	public static boolean transfer(Account fromAccount, Account toAccount, int amount) {
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        } else {
            return false;
        }
    }
}

