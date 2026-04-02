package com.anudip.Exception;
import java.util.Scanner;
import java.util.InputMismatchException;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("--- SUCCESSFULLY DEPOSITED: $" + amount + " ---");
        } else {
            System.out.println("ERROR: DEPOSIT AMOUNT MUST BE POSITIVE.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("WITHDRAWAL DENIED. INSUFFICIENT FUNDS.");
        } else if (amount <= 0) {
            System.out.println("ERROR: WITHDRAWAL AMOUNT MUST BE POSITIVE.");
        } else {
            balance -= amount;
            System.out.println("--- SUCCESSFULLY WITHDREW: $" + amount + " ---");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class LabException2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount myAccount = new BankAccount(500.00);
        boolean running = true;

        System.out.println("WELCOME TO SIMPLEBANK!");

        while (running) {
            System.out.println("\nCURRENT BALANCE: $" + myAccount.getBalance());
            System.out.println("1. DEPOSIT");
            System.out.println("2. WITHDRAW");
            System.out.println("3. EXIT");
            System.out.print("CHOOSE AN OPTION: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("ENTER DEPOSIT AMOUNT: ");
                        myAccount.deposit(scanner.nextDouble());
                        break;
                    case 2:
                        System.out.print("ENTER WITHDRAWAL AMOUNT: ");
                        myAccount.withdraw(scanner.nextDouble());
                        break;
                    case 3:
                        running = false;
                        System.out.println("THANK YOU FOR USING SIMPLEBANK. GOODBYE!");
                        break;
                    default:
                        System.out.println("INVALID CHOICE. PLEASE SELECT 1, 2, OR 3.");
                }
            } catch (InsufficientFundsException e) {
                System.out.println("TRANSACTION FAILED: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("INVALID INPUT! PLEASE ENTER NUMBERS ONLY.");
                scanner.next(); 
            }
        }
        scanner.close();
    }
}
