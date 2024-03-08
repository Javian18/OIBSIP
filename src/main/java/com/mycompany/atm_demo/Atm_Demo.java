/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.atm_demo;

import java.util.Scanner;

/**
 *
 * @author poons
 */
public class Atm_Demo {
 static String DEFAULT_pin= "12345";
 private static String pin = DEFAULT_pin; // Current PIN
    public static void main(String[] args) {
         
         
          //static final String PIN_FILE = "pin.txt"; // File to store the PIN
         String pin = null;
         Pin Pin = new Pin();
         
         Pin.loginPin(pin, 0);
         
         Atm atm =  new Atm();
         Transactions bank = new Transactions();
         atm.menu(bank);
         
 }
     
}