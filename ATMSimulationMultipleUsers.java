import java.util.Scanner;

class Account {
    private String accountNumber;
    private int pin;
    private double balance;

    public Account(String accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean checkPin(int enteredPin) {
        return pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Error: Insufficient balance!");
        }
    }
}

public class ATMSimulationMultipleUsers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        Account[] accounts = {
            new Account("1001", 1111, 1500.0),
            new Account("1002", 2222, 2500.0),
            new Account("1003", 3333, 3500.0)
        };

        System.out.println("Welcome to Java ATM!");

       
        System.out.print("Enter account number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        Account loggedInAccount = null;
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accNo) && acc.checkPin(pin)) {
                loggedInAccount = acc;
                break;
            }
        }

        if (loggedInAccount == null) {
            System.out.println("Authentication failed! Exiting...");
            sc.close();
            return;
        }

       
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: $" + loggedInAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    if (depositAmount > 0)
                        loggedInAccount.deposit(depositAmount);
                    else
                        System.out.println("Invalid amount!");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    loggedInAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using Java ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
} 