package javaapplication2;

import java.util.*;

public class JavaApplication2 {

    public static void main(String[] args) {
        LogWriter writer = new LogWriter();
        LogReader reader = new LogReader();

        try {
            writer.start();
            writer.join();
            
            reader.start();
        } catch (Exception ex) {
            System.out.println("Interrupted Exception: " + ex.getMessage());
        }

    }

}
