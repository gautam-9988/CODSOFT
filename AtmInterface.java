/*  
he ATM Interface Project is a software implementation that simulates the functionality of an Automated Teller Machine (ATM). An ATM is a banking device that allows users to perform various financial transactions without the need for direct interaction with a bank teller. The project involves creating a user-friendly interface for the ATM and implementing the core functionalities commonly found in real-world ATMs.
*/

import java.util.Scanner;//This line imports the Scanner class from the java.util package, which is used to read user input.

//The BankAccount class includes methods for depositing, withdrawing, and checking the balance of the account.
class BankAccount {
    private double balance;// private instance variable to store account balance

    public BankAccount(double initialBalance) {// This is the constructor for the BankAccount class. It takes an initial balance as a parameter and initializes the account's balance with that value.
        balance = initialBalance;
    }

    public boolean deposit(double amount) {// If the amount is positive, it adds the amount to the account's balance.
        if (amount > 0) {
            balance += amount;
            return true;// return true indicates that the deposit is successful
        }
        return false;// return false indicates that the deposit is unsuccessful
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {// This condition checks if the amount is positive and if the account balance is sufficient for the withdrawal
            balance -= amount;
            return true;// returns true indicates that the withdrawal was successful.
        }
        return false;// returns false indicates that the withdrawal was unsuccessful.
    }

    public double checkBalance() {// This method returns the current account balance
        return balance;
    }
}

//The ATM class, which handles the user interface and interaction.
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {//The constructor initializes the bankAccount and creates a new Scanner object to read user input from the console.
        bankAccount = account;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {//switcch statement to toggle between choices
                case "1": //withdraw chioce
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    if (bankAccount.withdraw(withdrawAmount)) {//if returns true
                        System.out.println("Withdrawal successful.");
                    } else {//if returns false
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;

                case "2": //deposit choice
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    if (bankAccount.deposit(depositAmount)) {//if returns true
                        System.out.println("Deposit successful.");
                    } else {//if returns false
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case "3": //balanceCheck choice
                    double balance = bankAccount.checkBalance();
                    System.out.println("Your account balance: Rupees: " + balance);
                    break;

                case "4": //exit choice
                    System.out.println("Thank you for using the ATM.");
                    scanner.close();//
                    return;//It will exit the loop using returrn statement

                default: //executed when non valid option is entered
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

class Main {//Main Class where main function resides
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//To take input
        System.out.print("Enter initial account balance: ");
        double initialBalance = Double.parseDouble(sc.nextLine());//Taking initial balance as input

        BankAccount userAccount = new BankAccount(initialBalance);//parametrises constructor
        ATM atm = new ATM(userAccount);//user account object passed in parametrised constructor of ATM Class
        atm.run();//Overall working in run function
        sc.close();//It is is important to close Scanner object for proper resource management and to prevent potential issues such as memory leak, blocking resources
    }
}