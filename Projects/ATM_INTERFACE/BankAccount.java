package ATM_INTERFACE;
import java.util.ArrayList;

public class BankAccount {
    private String userId;
    private double balance;
    private ArrayList<String> transactions;

    public BankAccount(String userId) {
        this.userId = userId;
        this.balance = 1000.0; // initial balance
        this.transactions = new ArrayList<>();
    }

    public void printTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String txn : transactions) {
                System.out.println(txn);
            }
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactions.add("Withdrew: $" + amount);
            System.out.println("Withdrawal successful. New Balance: $" + balance);
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            transactions.add("Deposited: $" + amount);
            System.out.println("Deposit successful. New Balance: $" + balance);
        }
    }

    public void transfer(String recipientId, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactions.add("Transferred: $" + amount + " to " + recipientId);
            System.out.println("Transfer successful. New Balance: $" + balance);
        }
    }
}
