/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_demo;

/**
 *
 * @author poons
 */
public class Account {
    // Variable declerartion
    private double balance;
    private String type;
    private double amount;

    // Constructor to initialize the account balance
    public Account( double balance) {
        this.balance = balance;
        balance = 1000.0;
    }

    // Method to retrieve the current balance of the account
    public double getBalance() {
        return balance;
    }

    // Method to deposit funds into the account
    public double deposit(double amount ) {
        balance += amount;
        return balance;
    }

    // Method to withdraw funds from the account
    public double withdraw(double amount) {
        if (amount <= balance) { //Check if there are sufficient funds in the account
            balance -= amount;
           System.out.println("You have sussefully made an withdraw");
        } else {
            System.out.println("Insufficient balance");
        }
        return amount;
    }

    // Method to transfer funds from the current account to another account
    public void transfer(double amount, Account recipient) {
        if (amount <= balance) { // Check if there are sufficient funds in the account
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

    

