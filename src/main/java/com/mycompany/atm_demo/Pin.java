/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm_demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

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
        boolean quit = false;

        System.out.println("Welcome to the Atm interface program!");
       
        // Loop until correct PIN is entered or maximum attempts reached
        while (attempts < MAX_ATTEMPTS) {
            // Prompt the user to enter the PIN
            System.out.print("Please enter your PIN: ");
            enteredPin = scanner.nextLine();
            
            if (attempts >= MAX_ATTEMPTS) {
            System.out.println("Maximum attempts reached. Access denied!");
            quit = true;
            break; // Exit the loop when maximum attempts are reached
            }
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
        }
         if (quit) {
        System.out.println("Access is denied");
    }
               
        

        System.out.println("Maximum attempts reached. Access denied!");
        
   }
    
    public void changePin(int index) {
   
        Scanner scanner = new Scanner(System.in);
        String userId;
        

       System.out.print("Enter current PIN: ");
       String currentPin = scanner.nextLine();
       
        if (currentPin.equals(pin)) {
            while (true) {
                System.out.println("Ensure that the pin is 5 digits long.");
                System.out.print("Enter new PIN: ");
                String newPin = scanner.nextLine();
                System.out.print("Confirm new PIN: ");
                String confirmPin = scanner.nextLine();
                
                if (newPin.equals(confirmPin)) {
                    if (newPin.length() != 5 || !newPin.matches("\\d{5}")) {
                        System.out.println("PIN must be 5 digits long.");
                    } else {
                        try {
                            String hashedPin = hashPin(newPin);
                            saveToTextFile(hashedPin);
                            pin = hashedPin; // Update PIN
                            System.out.println("PIN changed successfully.");
                            break; // Exit the loop when PIN is successfully changed
                        } catch (NoSuchAlgorithmException e) {
                            e.printStackTrace();
                            System.out.println("Error occurred while hashing the PIN.");
                            break; // Exit the loop due to error
                        }
                    }
                } else {
                    System.out.println("PINs do not match. Please try again.");
                } break;
            }
        } else {
            System.out.println("Incorrect PIN. Please try again.");
        }
        
        scanner.close(); // Close the scanner
    }

    private static String hashPin(String newPin) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(newPin.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hashedBytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }

    private static void saveToTextFile(String encryptedPin) {
        String fileName = "encrypted_pin.txt";
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(encryptedPin.getBytes());
            System.out.println("Encrypted PIN saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save encrypted PIN to file.");
        }
    }
}