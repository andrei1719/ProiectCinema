package view;

import java.util.Scanner;

public class PersonalOperations {

    private PersonalOperations() {

    }

    public static void PersonalOperations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Logare:");
        System.out.println("User:");
        String user =scanner.nextLine();
        System.out.println("Parola:");
        String parola = scanner.nextLine();

        if(user.equals("user") && parola.equals("1234")){
            PersonalOperations.PersonalOperations();
        } else {
            System.out.println("User sau parola gresite");
        }
    }
}
