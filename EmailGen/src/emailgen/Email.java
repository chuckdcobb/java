package emailgen;

import java.util.Scanner;

public class Email {
    private  String firstName;
    private  String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 8;
    private String companyName = "cobb.com";

    // Constructor to receive the first and last names
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
        

        //Call Method Requesting Department
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        //Method call to set random password
        this.password = randomPassword(defaultPasswordLength);
        //System.out.println("Your password is: "+ this.password);

        //Generate Email first.last@department.company.com
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companyName;
        //System.out.println("Your email is: " + email);
    }
    
   
    //Request Department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice == 1) {return "sales"; }
        else if (depChoice == 2) { return "dev";}
        else if (depChoice == 3) {return "accounting";}
        else {return "";}

    }
    //Generate Password Randomly
    private String randomPassword(int length){
        String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    public String showInfo() {
        return "Name: " + firstName + " " + lastName + "\nDepartment: " + department + "\nEmail: " + email + " " + "\nPassword: "+ password;
    }
}