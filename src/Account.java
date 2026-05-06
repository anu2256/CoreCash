public class Account {
    private double balance;
    private int pin;

    public Account(double initialBalance, int initialPin) {
        this.balance = initialBalance;
        this.pin = initialPin;
    }

    // Balance eka balanna
    public double getBalance() {
        return balance;
    }

    // Salli danna (Deposit)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Salli ganna (Withdraw)
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // PIN eka check karanna
    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }
}