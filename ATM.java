import java.util.Scanner;

public class ATM {
    private static String[] accountNumbers = {"123456", "789012", "345678"};
    private static double[] accountBalances = {1000.0, 2000.0, 1500.0};
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("1. Log in");
            System.out.println("2. Create new account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void login() {
        System.out.print("Enter your account number (or 'exit' to cancel): ");
        String accountNumber = scanner.nextLine();
        
        if (accountNumber.equalsIgnoreCase("exit")) {
            System.out.println("Canceled login.");
            return;
        }

        int index = findAccountIndex(accountNumber);
        if (index == -1) {
            System.out.println("Invalid account number. Please try again.");
            return;
        }

        System.out.println("Welcome, Account Number: " + accountNumber);
        System.out.println("Your balance is: $" + accountBalances[index]);

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
            return;
        }

        if (amount > accountBalances[index]) {
            System.out.println("Insufficient funds. Please try again.");
            return;
        }

        accountBalances[index] -= amount;
        System.out.println("Withdrawal successful. New balance: $" + accountBalances[index]);
    }

    private static void createAccount() {
        System.out.print("Enter a new account number: ");
        String newAccountNumber = scanner.nextLine();

        if (findAccountIndex(newAccountNumber) != -1) {
            System.out.println("Account already exists. Please choose a different account number.");
            return;
        }

        // Add the new account number and balance to the arrays
        String[] newAccountNumbers = new String[accountNumbers.length + 1];
        double[] newAccountBalances = new double[accountBalances.length + 1];

        System.arraycopy(accountNumbers, 0, newAccountNumbers, 0, accountNumbers.length);
        System.arraycopy(accountBalances, 0, newAccountBalances, 0, accountBalances.length);

        newAccountNumbers[newAccountNumbers.length - 1] = newAccountNumber;
        newAccountBalances[newAccountBalances.length - 1] = 0.0; // Initial balance is 0

        accountNumbers = newAccountNumbers;
        accountBalances = newAccountBalances;

        System.out.println("Account created successfully. Welcome!");
    }

    private static int findAccountIndex(String accountNumber) {
        for (int i = 0; i < accountNumbers.length; i++) {
            if (accountNumbers[i].equals(accountNumber)) {
                return i;
            }
        }
        return -1; // Account not found
    }
}
