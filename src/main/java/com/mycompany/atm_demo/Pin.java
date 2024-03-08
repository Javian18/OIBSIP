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
public class Pin {

   private static String DEFAULT_pin = "12345"; // Default PIN
   private static String pin = DEFAULT_pin; // Current PIN
    
    public void loginUser(String pin, int index)
          { 
              Scanner input = new Scanner(System.in);
             //inputs password to  login
             
             System.out.print("Enter PIN: ");
             String userpin = input.nextLine();

        if (userpin.equals(pin)) {
            System.out.println("Login successful.......");
            //menuOptions(transactions, index);
        } else {
            System.out.println("Incorrect pin entered, please try again ");
            loginUser(pin, index); // Recursive call to userlogin until correct PIN is entered
        }
          }
    
    public  void loginPin(String pin, int index){
      // Declaration
        Scanner scanner = new Scanner(System.in);
        String enteredPin;
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        System.out.println("Welcome to the PIN program!");

        // Loop until correct PIN is entered or maximum attempts reached
        while (attempts < MAX_ATTEMPTS) {
            // Prompt the user to enter the PIN
            System.out.print("Please enter your PIN: ");
            enteredPin = scanner.nextLine();

            // Check if the entered PIN matches the default PIN
            if (enteredPin.equals(Atm_Demo.DEFAULT_pin)) {
                System.out.println("Access granted! You entered the correct PIN.");
               Atm_Demo tt = new Atm_Demo();
             // tt.menu();
                return; // Exit method when correct PIN is entered
            }  else {
                System.out.println("Access denied! Incorrect PIN.");
                attempts++; // Increment attempts
            }
            
             

        System.out.println("Maximum attempts reached. Access denied!");
        scanner.close();
        }
   }
    
    public void changePin(int index) {
   
        Scanner scanner = new Scanner(System.in);
        String userId;
        

       System.out.print("Enter current PIN: ");
       String currentPin = scanner.nextLine();
       
        if (currentPin.equals(pin)) {
            while (pin.length() != 5 || !pin.matches("\\d{5}")) {
            System.out.println("Ensure that the pin is 5 digits long.");
            System.out.print("Enter new PIN: ");
            String newPin = scanner.nextLine();
            System.out.print("Confirm new PIN: ");
            String confirmPin = scanner.nextLine();  
            if (newPin.equals(confirmPin)) {
                pin = newPin; // Update PIN
                System.out.println("PIN changed successfully.");
            } else {
                System.out.println("PINs do not match. Please try again.");
                changePin(index); // Retry changing PIN
            }
            }    
        } else {
            System.out.println("Incorrect PIN. Please try again.");
            changePin(index); // Retry changing PIN
        }

        

     
      
    }
}
    