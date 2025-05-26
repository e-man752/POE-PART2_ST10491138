/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class ChatAppTest {
    
    public ChatAppTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class ChatApp.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ChatApp.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class ChatApp.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String administrator = "";
        String password = "";
        boolean expResult = false;
        boolean result = ChatApp.login(administrator, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class ChatApp.
     */
    @Test
    public void testSendMessage() {
        System.out.println("Hi Mike, can us for dinner tonight");
        ChatApp.sendMessage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveMessagesToJSON method, of class ChatApp.
     */
    @Test
    public void testSaveMessagesToJSON() {
        System.out.println("saveMessagesToJSON");
        ChatApp.saveMessagesToJSON();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showRecentlySentMessages method, of class ChatApp.
     */
    @Test
    public void testShowRecentlySentMessages() {
        System.out.println("Message ready to send.");
        ChatApp.showRecentlySentMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("Message exceeds 250 characters by X [enter number here], please reduce size.");
    }
 @Test
    public void testCheckRecipient_validNumber() {
        String valid = "+12345678901";
        String result = invokeCheckRecipient(valid);
        assertEquals(valid, result);
        System.out.println("Cell phone number successfully captured.");
    }

    @Test
    public void testCheckRecipient_invalidNumber() {
        String invalid = "123456"; // No + and too short
        String result = invokeCheckRecipient(invalid);
        assertNull(result); 
       System.out.println("Cell phone number is incorrectly formattted or does not contain an international code. Please correct the number and try again.");
}

    private String invokeCheckRecipient(String valid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
