package utilitarios;

public class BankAccount {
    private String accountNumber;
    private String holder;
    private double balance;

    public BankAccount(String accountNumber, String holder) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = 0.0;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    // Business logic
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " completed successfully!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " completed successfully!");
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber +
               " | Holder: " + holder +
               " | Balance: $" + String.format("%.2f", balance);
    }
}
