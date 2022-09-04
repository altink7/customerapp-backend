package test;

import at.altin.fullstackweb.model.Customer;
import java.io.*;
import java.util.*;

public class TestDB {
    public static void main(String[] args) {
        loadCustomersFromCSVFile("src/main/java/test/testfiles/altindb_customer.csv");
    }

    public static List<Customer> loadCustomersFromCSVFile(String filename) {
        List<Customer> customers = new LinkedList<Customer>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {

             String line = in.readLine();
             if (line != null) {

                 while ((line != null)) {

                     System.out.println(line);
                     customers.add(parseCustomer(line));

                     line = in.readLine();
                     }
                 }
             } catch (IOException e) {
             e.printStackTrace();
        }
        return customers;
    }

    public static Customer parseCustomer(String line){
        String[] parts = line.split(",");

        Customer c= new Customer(parts[4],Boolean.parseBoolean(parts[1]),parts[2],parts[5],parts[3]);

        c.setId(Long.valueOf(parts[0]));
        return c;
    }
}
