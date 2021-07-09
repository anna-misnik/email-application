package com.company;
import  java.util.Scanner;

public class Email {
    //encapsulation, variables cannot be accessed openly but via class instead
    private String firstanme;
    private String lastname;
    private String password;
    private String alternativeEmail;
    private String department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 8;

    //Constructor
    public Email (String firstname, String lastname){
        this.firstanme = firstname;
        this.lastname = lastname;

        //to make sure it's working
        System.out.println("Email created: " + this.firstanme + " " + this.lastname);

        //call the method asking for a department + return the department
        this.department = setDepartment();
        System.out.println("Department is " + this.department);

        //call the method that return a random password
        this.password = setPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);

        //combine elements to generate an email adress
        System.out.println("Your new email is " +this.firstanme.toLowerCase()+ '.' + this.lastname.toLowerCase() + '@' + this.department + ".company.com");


    }

    //ask for the department
    private String setDepartment(){
        System.out.println("Enter the department: \n1 for Sales \n2 for Development \n3 for Accounting \n4 for none");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option){
            case 1: return "sales";
            case 2: return "dev";
            case 3: return "acct";
            case 4: return " ";
            default:
                System.out.println("Invalid option, try again!");
                setDepartment();
                break;
        }
        return null;
    }

    //generate a random password
    private String setPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNQRSTUVWXZY0123456789!@#$%^&*())_-=+";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int) (Math.random()*passwordSet.length()); //generates a random position
            password[i] = passwordSet.charAt(rand); //insert values at the certain position into a password array
        }
        return new String(password);
    }

    //set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //set the altern. emal
    public void setAlternativeEmail(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an alternative email: ");
        this.alternativeEmail = scanner.nextLine();
        System.out.println("The alternative email is " + this.alternativeEmail);
    }

    public int getMailboxCapacity(){return this.mailboxCapacity;}

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public String getPassword() {
        return password;
    }

    //change the passord
    public void setNewPassword(){
        System.out.println("Password options: \n1 to change password \n2 to keep current password");
        Scanner scanner2 = new Scanner(System.in);
        int option2 = scanner2.nextInt();
        if (option2==1)
            this.password = setPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);
    }
}
