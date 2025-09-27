import java.util.Scanner;

class ATM {
    float Balance = 0; 
    final int PIN = 1234; 

    public void checkpin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your pin:");
        
        if (sc.hasNextInt()) {
            int enteredpin = sc.nextInt();
            if (enteredpin == PIN) {
                System.out.println("Login Successful!");
                menu();
            } else {
                System.out.println("Invalid PIN. Please try again.");
                checkpin(); 
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            checkpin();
        }
    }

    public void menu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("Enter your choice:");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. EXIT");
        System.out.println("----------------");

        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    checkbalance();
                    break;
                case 2:
                    withdrawmoney();
                    break;
                case 3:
                    depositmoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye! ");
                    break; 
                default:
                    System.out.println("Enter a valid choice (1-4).");
                    menu(); 
                    break;
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            menu();
        }
    }

    public void checkbalance() {
        System.out.printf("Current Balance: ", Balance);
        menu(); 
    }

    public void withdrawmoney() {
        System.out.println("Enter amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextFloat()) {
            float amount = sc.nextFloat();
            
            if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else if (amount > Balance) {
                System.out.println("Insufficient Balance. Your current balance is: " + Balance);
            } else {
                Balance = Balance - amount;
                System.out.printf("Money Withdrawal Successful. Remaining Balance: " +Balance);
            }
        } else {
             System.out.println("Invalid input. Please enter a numerical amount.");
        }
        menu(); 
    }

    public void depositmoney() {
        System.out.println("Enter the Amount to deposit:");
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextFloat()) {
            float amount = sc.nextFloat();
            if (amount <= 0) {
                System.out.println("Deposit amount must be positive.");
            } else {
                Balance = Balance + amount;
                System.out.printf("Money Deposited Successfully. New Balance: "+ Balance);
            }
        } else {
            System.out.println("Invalid input. Please enter a numerical amount.");
        }
        menu(); 
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkpin(); 
    }
}