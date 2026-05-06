import java.util.Scanner;

public class CoreCash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Default account ekak hadamu (Balance: 1000, PIN: 1234)
        Account myAccount = new Account(1000.00, 1234);

        System.out.println("--- Welcome to CoreCash ATM ---");
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (myAccount.validatePin(enteredPin)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\n--- Main Menu ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: Rs." + myAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double dAmount = scanner.nextDouble();
                        myAccount.deposit(dAmount);
                        System.out.println("Successfully deposited.");
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double wAmount = scanner.nextDouble();
                        if (myAccount.withdraw(wAmount)) {
                            System.out.println("Please collect your cash.");
                        } else {
                            System.out.println("Insufficient balance or invalid amount.");
                        }
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Thank you for using CoreCash!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("Incorrect PIN. Access Denied.");
        }
        
        scanner.close();
    }
}