package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class PhoneBook {
    // HashMap to store phone book entries with names as keys and normalized phone numbers as values
    private HashMap<String, String> phoneBook;

    // Constructor initializes the phoneBook HashMap
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Method to load phone book entries from a text file
    public void loadPhoneBookFromFile(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        Pattern pattern = Pattern.compile("(\\+359|0|00359)(87|88|89)[2-9]\\d{6}");
        while ((line = br.readLine()) != null) {
            // Split the line into name and phone number
            String[] parts = line.split(",");
            // Check if the line has the expected format with name and phone number
            if (parts.length == 2) {
                String name = parts[0].trim();
                String phoneNumber = parts[1].trim();
                // Normalize the phone number using the regular expression pattern
                Matcher matcher = pattern.matcher(phoneNumber);
                if (matcher.matches()) {
                    phoneBook.put(name, phoneNumber);
                }
            } else {
                System.out.println("Invalid line format: " + line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    


    // Method to add a new phone book entry
    public void addEntry(String name, String phoneNumber) {
        // Normalize the phone number and add the entry if it is valid
        Pattern pattern = Pattern.compile("(\\+359|0|00359)(87|88|89)[2-9]\\d{6}");
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            phoneBook.put(name, phoneNumber);
        } else {
            System.out.println("Invalid phone number format. Entry not added.");
        }
    }

    // Method to delete a phone book entry by name
    public void deleteEntry(String name) {
        // Remove entry from the phoneBook HashMap
        phoneBook.remove(name);
    }

    // Method to access the phone number for a given name
    public String getPhoneNumber(String name) {
        return phoneBook.get(name);
    }

    // Method to print all phone book entries
    public void printPhoneBook() {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    // Menu
    public static void printMenu(){
        String menu = """
        ++++++++ menu ++++++++++++++
            1. List registry
            2. Add record
            3. Delete record
            4. Search number by name
            5. exit
        ++++++++++++++++++++++++++++
        """;

        System.out.println(menu);
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.loadPhoneBookFromFile("/home/abran/repos/school/java/PhoneRegistry/src/phonebook.txt");

        while(true){
            printMenu();

            System.out.println("Choose an action:");
            int action = scanner.nextInt();
            
            
            String name;
            String phoneNumber;
            switch(action){
                case 1: 
                    clearScreen();
                    System.out.println("+++++++ List Register ++++++");
                    phoneBook.printPhoneBook();
                    break;

                case 2:
                    clearScreen();
                    System.out.println("+++++++ Add A Record +++++++");
                    System.out.println("Enter name:");
                    name = scannerString.nextLine();
                    
                    System.out.println("Enter number");
                    phoneNumber = scannerString.nextLine();

                    phoneBook.addEntry(name, phoneNumber);
                    break;
                
                case 3:
                    clearScreen();
                    System.out.println("+++++++ Delete A Record +++++++");
                    System.out.println("Enter name:");
                    name = scannerString.nextLine();
                
                    phoneBook.deleteEntry(name);
                    break;
                case 4:
                    clearScreen();
                    System.out.println("+++++++ Search A Record ++++++");
                    System.out.println("Enter name:");
                    name = scannerString.nextLine();

                    System.out.println(phoneBook.getPhoneNumber(name)); 
                    break;
                case 5:
                    clearScreen();
                    System.out.println("Goodbye!");
                    scanner.close();
                    scannerString.close();
                    System.exit(0);
            }   
        }
    }
}