package ATM_INTERFACE;
import java.util.Scanner;

public class ATMInterface {
    private BankAccount account;

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the ATM");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (authenticate(userId, pin)) {
            account = new BankAccount(userId);
            showMenu(sc);
        } else {
            System.out.println("Authentication Failed. Exiting...");
        }

        sc.close();
    }

    private boolean authenticate(String userId, String pin) {
        // For demo: static check
        return userId.equals("user123") && pin.equals("1234");
    }

    private void showMenu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.printTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = sc.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = sc.nextDouble();
                    account.deposit(depositAmt);
                    break;
                case 4:
                    System.out.print("Enter recipient's User ID: ");
                    sc.nextLine(); // consume newline
                    String recipientId = sc.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmt = sc.nextDouble();
                    account.transfer(recipientId, transferAmt);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
