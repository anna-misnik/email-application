package com.company;

public class EmailApp {

    public static void main(String[] args) {
	Email email1 = new Email("Anna", "Misnik");
        //call the method to change the password
        email1.setNewPassword();
        email1.setAlternativeEmail();
        email1.setMailboxCapacity(1000);
    }
}
