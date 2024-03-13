/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.atm_demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PinTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setUpClass() {
        // Setup code here if needed
    }

    @Test
    public void testLoginUser() {
        Pin pin = new Pin();
        String expectedOutput = "Login successful.......";
        System.setOut(new PrintStream(outContent));
        pin.loginUser("12345", 0);
        assertEquals(expectedOutput, outContent.toString().trim());
        System.setOut(originalOut);
    }

    @Test
    public void testLoginPin() {
        Pin pin = new Pin();
        String expectedOutput = "Access granted! You entered the correct PIN.";
        System.setOut(new PrintStream(outContent));
        pin.loginPin("12345", 0);
        assertTrue(outContent.toString().contains(expectedOutput));
        System.setOut(originalOut);
    }

    @Test
    public void testChangePin() throws NoSuchAlgorithmException, IOException {
        Pin pin = new Pin();
        String expectedOutput = "PIN changed successfully.";
        System.setOut(new PrintStream(outContent));
        Scanner scanner = new Scanner("12345\n12345\n12345");
        pin.changePin(0);
        assertTrue(outContent.toString().contains(expectedOutput));
        System.setOut(originalOut);
    }
}
