/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author ABHAY
 */
import java.io.*;

public class LogReader extends Thread {

    public void run() {
        try {
            FileReader fr = new FileReader("server_logs.txt");
            BufferedReader br = new BufferedReader(fr);
            
            System.out.println("\nERROR Logs:");
            String line;
            
            while((line = br.readLine()) != null) {
                if(line.contains("ERROR")) {
                    System.out.println(line);
                }
            }
            System.out.println("Logs read successfully.");
            
            br.close();
            fr.close(); // These two lines are imp
            
        } catch (Exception ex) {
            System.out.println("Error reading logs: " + ex.getMessage());
        }
    }
}
