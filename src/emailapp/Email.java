package emailapp;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
public class Email {

    public Scanner sc = new Scanner(System.in);

    // Setting up the variables
    // Defined as 'private' so that these cannot be accessed directly
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alterEmail;

    // Constructor to receive the first name and the last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("\nPlease enter a department code to set an employee email---" +
                "");

        // Call a method asking for the department - return the department
        this.department = this.setDept();

        // Call a method that returns a random password
        this.password = this.generatePassword(8);

        // Combine elements to generate an email
        this.email = this.generateEmail();
    }

    // Generating the email according to the given syntax
    private String generateEmail() {
        return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase()
                + ".company.com";
    }

    // Ask for the department
    private String setDept() {
        System.out.println("\n***DEPARTMENT CODES***");
        System.out.println(
                "----------------------\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None");
        boolean flag = false;
        do {
            System.out.print("Enter Department Code: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("**INVALID CHOICE**");
            }
        } while (!flag);
        return null;
    }

    // Generating a random password
    private String generatePassword(int length) {
        Random r = new Random();

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars + Small_chars + numbers + symbols;

        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    // Change the password
    public void setPassword() {
        boolean flag = false;
        do {
            System.out.print("ARE YOU SURE YOU WANT TO CHANGE YOUR PASSWORD? (Y/N) : ");
            char choice = sc.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.print("Enter current password: ");
                String temp = sc.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = sc.next();
                    System.out.println("PASSWORD CHANGED SUCCESSFULLY!");
                } else {
                    System.out.println("Incorrect Password!");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("PASSWORD CHANGE CANCELED!");
            } else {
                System.out.println("**ENTER A VALID CHOICE**");
            }
        } while (!flag);
    }

    // Set the mailbox capacity
    public void setMailCapacity() {
        System.out.println("Current capacity = " + this.mailCapacity + "mb");
        System.out.print("Enter new capacity: ");
        this.mailCapacity = sc.nextInt();
        System.out.println("MAILBOX CAPACITY CHANGED SUCCESSFULLY!");

    }

    // Set the alternate email
    public void alternateEmail() {
        System.out.print("Enter new alternate email: ");
        this.department = sc.next();
        System.out.println("ALTERNATE EMAIL SET SUCCESSFULLY!");
    }

    // Displaying the employee's information
    public void getInfo() {
        System.out.println("***EMPLOYEE INFORMATION DISPLAYING***" );
        System.out.println("--------------------------------------");
        System.out.println("NAME: " + this.firstName + " " + this.lastName );
        System.out.println("DEPARTMENT: " + this.department);
        System.out.println("EMAIL: " + this.email);
        System.out.println("PASSWORD: " + this.password);
        System.out.println("MAILBOX CAPACITY: " + this.mailCapacity);
        System.out.println("ALTER EMAIL: " + this.alterEmail);
    }

    public void storeFile() {
        try {
            FileWriter in = new FileWriter("info.txt");
            in.write("First Name: "+this.firstName + "\n");
            in.append("Last Name: "+this.lastName+ "\n");
            in.append("Email: "+this.email+ "\n");
            in.append("Password: "+this.password+ "\n");
            in.append("Capacity: "+this.mailCapacity+ "\n");
            in.append("Alternate mail: "+this.alterEmail+ "\n");
            in.close();
            System.out.println("Stored..");
        }catch (Exception e){System.out.println(e);}
    }

    public void readFile() {
        try {
            FileReader f1 = new
                    FileReader("info.txt");
            int i;
            while ((i = f1.read()) != -1) {
                System.out.print((char) i);
            }

            System.out.println();
            f1.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();

    }
}