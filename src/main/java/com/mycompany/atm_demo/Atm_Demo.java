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

    public static void main(String[] args) {
         Atm atm =  new Atm();
         Transactions bank = new Transactions();
        atm.menu(bank);
 }
     
}