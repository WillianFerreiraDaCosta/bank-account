import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import utilitarios.BankAccount;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        int option = -1;

        while (option != 0) { // <- corrigido
            showMenu();
            try {
                option = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (option) {
                    case 1 -> createAccount(sc, accounts);
                    case 2 -> deposit(sc, accounts);
                    case 3 -> withdraw(sc, accounts);
                    case 4 -> checkBalance(sc, accounts);
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid option!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine(); // clear invalid input
            }
        }

        sc.close();
    }

    private static void showMenu() {
        System.out.println("\n=== BANK MENU ===");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void createAccount(Scanner sc, ArrayList<BankAccount> accounts) { // <- corrigido
        System.out.print("Account number: ");
        String number = sc.nextLine();
        System.out.print("Account holder: ");
        String holder = sc.nextLine();
        accounts.add(new BankAccount(number, holder));
        System.out.println("Account created successfully!");
    }

    private static void deposit(Scanner sc, ArrayList<BankAccount> accounts) {
        BankAccount account = findAccount(sc, accounts);
        if (account != null) {
            System.out.print("Deposit amount: ");
            double amount = readDouble(sc);
            account.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void withdraw(Scanner sc, ArrayList<BankAccount> accounts) {
        BankAccount account = findAccount(sc, accounts);
        if (account != null) {
            System.out.print("Withdrawal amount: ");
            double amount = readDouble(sc);
            account.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void checkBalance(Scanner sc, ArrayList<BankAccount> accounts) {
        BankAccount account = findAccount(sc, accounts);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found!");
        }
    }

    private static BankAccount findAccount(Scanner sc, ArrayList<BankAccount> accounts) {
        System.out.print("Enter account number: ");
        String number = sc.nextLine();
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(number)) return acc;
        }
        return null;
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            try {
                double v = sc.nextDouble();
                sc.nextLine(); // clear buffer
                return v;
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid amount: ");
                sc.nextLine();
            }
        }
    }
}