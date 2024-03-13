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
   
   // Method to display the main menu and handle user interactions
   public void menu(Transactions transactions){
       //Declartions
        int choice;
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        
        // Main loop to display the menu and handle user choices inputs
        while (!quit) {
            System.out.println("\n1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer");
            System.out.println("4. Transactions History");
            System.out.println("5. Change Pin");
            System.out.println("6. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            
            // Switch statement to execute corresponding functionality based on user's choice
            switch (choice) {
                case 1:
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
                    Pin pin = new Pin();
                    pin.changePin(choice);
                    break;
                case 6:
                    quit = true;
                    System.out.println("Thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        
        }
    }
        
   }
   
    // Method to view transaction history
     public void viewTransactionHistory(Transactions transactions) {
        double[] history = transactions.getTransactionHistory(); // Get transaction history array from Transactions class.
        
        // Display transaction history
        System.out.println("Transaction History:");
        for (int i = 0; i < history.length; i++) {
            if (history[i] != 0) {
                if (history[i] > 0) {
                    System.out.println("Deposit: R" + history[i]);
        
                } else {
                    System.out.println("Withdrawal: R" + (-history[i]));
                    System.out.println("Transfer: R" + (-history[i]));
                }
            }
        }
    }
   
}
