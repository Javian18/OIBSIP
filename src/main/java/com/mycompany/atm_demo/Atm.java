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
public class Atm {
    
   public void menu(Transactions transactions){
    int choice;
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        
        while (!quit) {
            System.out.println("\n1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer");
            System.out.println("4. Transactions History");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                     transactions.withdraw();
                    break;
                case 2:
                    transactions.deposit();
                    break;
                case 3:
                    transactions.transfer();
                    break;
                case 4:
             
                    // View all transactions
                    viewTransactionHistory(transactions);
                    break;
                case 5:
                    quit = true;
                    System.out.println("Thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
   
     public void viewTransactionHistory(Transactions transactions) {
        double[] history = transactions.getTransactionHistory();
        
        System.out.println("Transaction History:");
        for (int i = 0; i < history.length; i++) {
            if (history[i] != 0) {
                if (history[i] > 0) {
                    System.out.println("Deposit: $" + history[i]);
                } else {
                    System.out.println("Withdrawal/Transfer: $" + (-history[i]));
                }
            }
        }
    }
   
}
