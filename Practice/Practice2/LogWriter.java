package javaapplication2;

import java.io.*;
public class LogWriter extends Thread {

    public void run() {
        String logs[] = {
            "Server started successfully",
            "ERROR: Database connection failed",
            "User logged in",
            "ERROR: Unable to load configuration",
            "Backup completed"
        };
        try {
            FileWriter fw = new FileWriter("server_logs.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(String log : logs) {
                bw.write(log);
                bw.newLine();
            }
            System.out.println("Logs written successfully.");
            
            bw.close();
            fw.close(); // These two lines are imp
            
        } catch(Exception ex) {
            System.out.println("Error writing logs: " + ex.getMessage());
        }

    }
}
