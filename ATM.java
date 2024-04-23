import java.util.Scanner;

public class ATM {

  private static String[] accountNumbers = { "123456", "789012", "345678" };
  private static double[] accountBalances = { 1000.0, 2000.0, 1500.0 };
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

    while (true) {
      System.out.println("1. Check Balance");
      System.out.println("2. Withdrawal");
      System.out.println("3. Balance Inquiry");
      System.out.println("4. Deposit");
      System.out.println("5. Transfer Money");
      System.out.println("6. Mini-Statements");
      System.out.println("7. PIN Change");
      System.out.println("8. Bill Payments");
      System.out.println("9. Mobile Recharge");
      System.out.println("10. Language Selection");
      System.out.println("11. Log out");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline character

      switch (choice) {
        case 1:
          checkBalance(index);
          break;
        case 2:
          withdraw(index);
          break;
        case 3:
          balanceInquiry(index);
          break;
        case 4:
          deposit(index);
          break;
        case 5:
          transferMoney(index);
          break;
        case 6:
          miniStatements(index);
          break;
        case 7:
          pinChange(index);
          break;
        case 8:
          billPayments(index);
          break;
        case 9:
          mobileRecharge(index);
          break;
        case 10:
          languageSelection(index);
          break;
        case 11:
          System.out.println("Logged out.");
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private static void checkBalance(int index) {
    System.out.println("Your balance is: $" + accountBalances[index]);
  }

  private static void withdraw(int index) {
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
    System.out.println(
      "Withdrawal successful. New balance: $" + accountBalances[index]
    );
  }

  private static void balanceInquiry(int index) {
    System.out.println("Balance Inquiry: $" + accountBalances[index]);
  }

  private static void deposit(int index) {
    System.out.print("Enter amount to deposit: ");
    double amount = scanner.nextDouble();
    scanner.nextLine(); // Consume newline character

    if (amount <= 0) {
      System.out.println("Invalid amount. Please try again.");
      return;
    }

    accountBalances[index] += amount;
    System.out.println(
      "Deposit successful. New balance: $" + accountBalances[index]
    );
  }

  private static void transferMoney(int senderIndex) {
    System.out.print("Enter recipient's account number: ");
    String recipientAccountNumber = scanner.nextLine();
    int recipientIndex = findAccountIndex(recipientAccountNumber);

    if (recipientIndex == -1) {
      System.out.println("Recipient's account not found.");
      return;
    }

    System.out.print("Enter amount to transfer: ");
    double amount = scanner.nextDouble();
    scanner.nextLine(); // Consume newline character

    if (amount <= 0) {
      System.out.println("Invalid amount. Please try again.");
      return;
    }

    if (amount > accountBalances[senderIndex]) {
      System.out.println("Insufficient funds. Please try again.");
      return;
    }

    accountBalances[senderIndex] -= amount;
    accountBalances[recipientIndex] += amount;
    System.out.println(
      "Transfer successful. New balance: $" + accountBalances[senderIndex]
    );
  }

  private static void miniStatements(int index) {
    System.out.println("Mini-Statements:");
    System.out.println("Recent transactions:");

    // Since we don't have transaction history, just display the current balance
    System.out.println("Your current balance is: $" + accountBalances[index]);
  }

  private static void pinChange(int index) {
    System.out.println("PIN Change: (Enter new PIN)");
    String newPIN = scanner.nextLine(); // Assume user enters a new PIN
    System.out.println("PIN changed successfully.");
  }

  private static void billPayments(int index) {
    System.out.println("Bill Payments: (Enter bill amount)");
    double billAmount = scanner.nextDouble();
    scanner.nextLine(); // Consume newline character
    if (billAmount <= 0) {
      System.out.println("Invalid amount. Please try again.");
      return;
    }
    if (billAmount > accountBalances[index]) {
      System.out.println("Insufficient funds. Please try again.");
      return;
    }
    accountBalances[index] -= billAmount;
    System.out.println(
      "Bill payment successful. New balance: $" + accountBalances[index]
    );
  }

  private static void mobileRecharge(int index) {
    System.out.println("Mobile Recharge: (Enter recharge amount)");
    double rechargeAmount = scanner.nextDouble();
    scanner.nextLine(); // Consume newline character
    if (rechargeAmount <= 0) {
      System.out.println("Invalid amount. Please try again.");
      return;
    }
    if (rechargeAmount > accountBalances[index]) {
      System.out.println("Insufficient funds. Please try again.");
      return;
    }
    accountBalances[index] -= rechargeAmount;
    System.out.println(
      "Mobile recharge successful. New balance: $" + accountBalances[index]
    );
  }

  private static void languageSelection(int index) {
    System.out.println(
      "Language Selection: (Select language: 1. English, 2. Yoruba, 3. French)"
    );
    int languageChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    switch (languageChoice) {
      case 1:
        System.out.println("Language set to English.");
        break;
      case 2:
        System.out.println("Language set to Yoruba.");
        break;
      case 3:
        System.out.println("Language set to French.");
        break;
      default:
        System.out.println("Invalid choice. Language remains unchanged.");
    }
  }

  private static int findAccountIndex(String accountNumber) {
    for (int i = 0; i < accountNumbers.length; i++) {
      if (accountNumbers[i].equals(accountNumber)) {
        return i;
      }
    }
    return -1; // Account not found
  }

  private static void createAccount() {
    System.out.print("Enter a new account number: ");
    String newAccountNumber = scanner.nextLine();

    if (findAccountIndex(newAccountNumber) != -1) {
      System.out.println(
        "Account already exists. Please choose a different account number."
      );
      return;
    }

    // Add the new account number and balance to the arrays
    String[] newAccountNumbers = new String[accountNumbers.length + 1];
    double[] newAccountBalances = new double[accountBalances.length + 1];

    System.arraycopy(
      accountNumbers,
      0,
      newAccountNumbers,
      0,
      accountNumbers.length
    );
    System.arraycopy(
      accountBalances,
      0,
      newAccountBalances,
      0,
      accountBalances.length
    );

    newAccountNumbers[newAccountNumbers.length - 1] = newAccountNumber;
    newAccountBalances[newAccountBalances.length - 1] = 0.0; // Initial balance is 0

    accountNumbers = newAccountNumbers;
    accountBalances = newAccountBalances;

    System.out.println("Account created successfully. Welcome!");
  }
}
