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
    //Declarion
    private double initialBalance = 1000.0;
    private double[] transactionHistory = new double[100]; // Array to store transaction history
    private int transactionCount = 0; // Counter to keep track of transactions

    // Method to perform a withdrawal
    public double withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: R");
        double withdrawAmount = scanner.nextDouble();
        scanner.nextLine(); 

        Account acc = new Account(initialBalance);
        
        // Check if withdrawal amount exceeds available balance
       if (withdrawAmount > acc.getBalance()) {
        System.out.println("Insufficient funds to withdraw");
        return 0; // Return 0 to indicate withdrawal failure
    } else {
        double withdrawnAmount = acc.withdraw(withdrawAmount);
        transactionHistory[transactionCount++] = withdrawnAmount; // Store negative value for withdrawal
        System.out.println("You have withdrawn: R" + withdrawnAmount);
        System.out.println("Your current balance is: R" + acc.getBalance());
        return withdrawAmount;
    }
      
    }

     // Method to perform a deposit
    public double deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: R");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Account acc = new Account(initialBalance);

        double depositedAmount = acc.deposit(depositAmount);
        transactionHistory[transactionCount++] = depositedAmount; // Store positive value for deposit

        System.out.println("You have deposited: R" + depositedAmount);
        System.out.println("Your current balance is: R" + acc.getBalance());

        return depositedAmount;
        
    }

    // Method to perform a transfer
    public double transfer() {
        Scanner scanner = new Scanner(System.in);
       

        System.out.print("Enter recipient's account number: ");
        String recipientId = scanner.next();
        System.out.print("Enter amount to transfer: R");
        double transferAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        
        //verfication of the account nummber entered
        String defaultAccountnumber = "12345678";
        
        if (recipientId.matches( defaultAccountnumber))
        {
            Account acc = new Account(initialBalance);
          //verfication of the amount entered to transfer
        if (transferAmount > acc.getBalance()){
            System.out.println("Insufficient funds to make an transfer");
        return 0;}else {
        acc.transfer(transferAmount, acc);
          transactionHistory[transactionCount++] = transferAmount; // Store negative value for transfer}
        
        System.out.println("You have succssefully transfered R" +  transferAmount + " to account: " + recipientId );
        System.out.println("Your current balance is: R" + acc.getBalance());
        } 
        }else {
            System.out.println("The account number you entered does not exist plaese try agian...");
        }
       
        return transferAmount;
    }

    // Getter for transaction history
    public double[] getTransactionHistory() {
        return transactionHistory;
    }
}

   
    
    
    
    


