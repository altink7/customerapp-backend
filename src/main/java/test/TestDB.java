package test;

import at.altin.fullstackweb.model.Customer;
import java.io.*;
import java.util.*;

public class TestDB {
    public static void main(String[] args) {
        loadCustomersFromCSVFile("src/main/java/test/testfiles/altindb_customer.csv");
    }

    public static List<Customer> loadCustomersFromCSVFile(String filename) {
        List<Customer> positions = new LinkedList<Customer>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {

             String line = in.readLine();
             if (line != null) {
                 while ((line != null)) {
                     System.out.println(line);
                     line = in.readLine();
                     }
                 }
             } catch (IOException e) {
             e.printStackTrace();
        }
        return positions;
    }
}
