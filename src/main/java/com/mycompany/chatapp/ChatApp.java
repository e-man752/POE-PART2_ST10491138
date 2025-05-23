 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author RC_Student_lab
 */
public class ChatApp {
    private static boolean exit;
    private static int Total_messages = 0;
    private static int Message_count;
    private static int messageCounter = 0;
    private static final JSONArray messageStorage = new JSONArray();

    public static void main(String[] args) {
        String[] Options = {"Send message", "Show Recently Sent Message", "Quit"};
        int Choice = JOptionPane.showOptionDialog(null, "Choose an option:", "QuickChat Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]);
        
        switch (Choice) {
            case 1 -> //Coming soon
                 JOptionPane.showMessageDialog(null, "Coming Soon.");
            case 2 -> //Quit
                exit = true;
            default -> JOptionPane.showMessageDialog(null,"Invalid Option.");
        }
        
JOptionPane.showMessageDialog(null, "Total Message sent: " + Total_messages);
    }
    
    static boolean login(String administrator, String string) {
        String User_name = JOptionPane.showInputDialog("Enter Username:");
        String pass_word = JOptionPane.showInputDialog("Enter passsword:");
        
        if ("administrator".equals(User_name) && "5678".equals(pass_word)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Login failed.");
            return false;
        }
      }
    static void sendMessage() {
        long messageId = 10000000000L + new Random().nextInt(900000000);
        messageCounter++;
        
        String recipient = JOptionPane.showInputDialog("Enter recipient number (+CCXXXXXXXXXX) :");
        if (recipient == null || !recipient.matches("\\+\\d{9,12}")) {
            JOptionPane.showMessageDialog(null,"Invalid number. Must include international code and be <= 12 digits.");
            return;
        }
        String message = JOptionPane.showInputDialog("Enter your message (max 250 chars) :");
        if (message == null || message.length() > 250) {
             JOptionPane.showMessageDialog(null,"Please enter a message of less than 250 characters.");
            return;
        }
        
       String [] words = message.trim().split("\\s+");
       String hash = String.format("%02d:%d:%s%s",
               Long.valueOf(Long.toString(messageId).substring(0, 2)),
               messageCounter,
               words[0].toUpperCase(),
               words.length > 1 ? words[words.length - 1].toUpperCase(): "");
       
       String[] actions = {"Send", "Disregard", "Store"};
       int action = JOptionPane.showOptionDialog(null,
               "Choose what to do with this message:",
               "Message Options",
               Total_messages, Message_count, null, actions, actions[0]);
       
       if (action == 1) {
           JOptionPane.showMessageDialog(null,"Message disregarded.");
           return;
       }
       
       JSONObject jsonMessage = new JSONObject();
       jsonMessage.put("MessageID", messageId);
       //jsonMessage.put("MessageHash", hash);
       jsonMessage.put("Recipient", recipient);
       jsonMessage.put("Message", message);
       
       if (action == 2) {
           messageStorage.add(jsonMessage);
                   JOptionPane.showMessageDialog(null, "Message stored.");
           return;
       }
       
       Total_messages++;
       
       JOptionPane.showMessageDialog(null,
               """
               Message Sent!
               Message ID: """ + messageId + "\n" +
                       //"Message Hash: " + hash + "\n" +
                       "Recipient: " + recipient + "\n" +
                       "Message: " + message);
    }
    
    static void saveMessagesToJSON() {
        try (FileWriter file = new FileWriter("storedMessages.json")) {
            file.write(messageStorage.toJSONString());
            file.flush();
            System.out.println("Stored messages saved to storedMessages.json");
        } catch (IOException e) {
            e.printStackTrace();
            
            
        }
    }
    
}
