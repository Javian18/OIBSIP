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
    private double balance;
    private String type;
    private double amount;

  

    public Account( double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
        return amount;
    }

    public void transfer(double amount, Account recipient) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

    

