/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_demo;

import java.util.Scanner;

/**
 *
 * @author poons
 */
public class Transactions {
    private double initialBalance = 1000.0;
    private double[] transactionHistory = new double[100]; // Array to store transaction history
    private int transactionCount = 0; // Counter to keep track of transactions

    public double withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: $");
        double withdrawAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Account acc = new Account(initialBalance);

        double withdrawnAmount = acc.withdraw(withdrawAmount);

        if (withdrawnAmount > 0) {
            transactionHistory[transactionCount++] = -withdrawnAmount; // Store negative value for withdrawal
            System.out.println("You have withdrawn: $" + withdrawnAmount);
            System.out.println("Your current balance is: $" + acc.getBalance());
        }else if (withdrawAmount >= withdrawnAmount){
           System.out.println("You have insefient funds to withdraw");
           for (int i = 0 ; i > withdrawnAmount; i++){
             transactionHistory[transactionCount++] = -withdrawnAmount; // Store negative value for withdrawal
            System.out.println("You have withdrawn: $" + withdrawnAmount);
            System.out.println("Your current balance is: $" + acc.getBalance());
           }
        }
        return withdrawAmount;
    }

    public double deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: $");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Account acc = new Account(initialBalance);

        double depositedAmount = acc.deposit(depositAmount);
        transactionHistory[transactionCount++] = depositedAmount; // Store positive value for deposit

        System.out.println("You have deposited: $" + depositedAmount);
        System.out.println("Your current balance is: $" + acc.getBalance());

        return depositedAmount;
    }

    public double transfer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter recipient's account number: ");
        String recipientId = scanner.next();
        System.out.print("Enter amount to transfer: $");
        double transferAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Account acc = new Account(initialBalance);

        acc.transfer(transferAmount, acc);
        transactionHistory[transactionCount++] = -transferAmount; // Store negative value for transfer
        
        System.out.println("You have succseeefully transfered R" +  transferAmount + " to account: " + recipientId );
        System.out.println("Your current balance is: $" + acc.getBalance());

        return transferAmount;
    }

    // Getter for transaction history
    public double[] getTransactionHistory() {
        return transactionHistory;
    }
}

   
    
    
    
    


