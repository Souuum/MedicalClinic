package Classes;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Patient menu = new Patient();
        Doctor menu2 = new Doctor();
        Appointment menu3 = new Appointment();
        Billing menu4 = new Billing();

        System.out.println("===============================================");
        System.out.println("Welcome to the medical center management system");
        System.out.println("===============================================");

        int option = 0;

        while (option != 4) {
            System.out.println("===============================================");
            System.out.println("Please choose an option:");
            System.out.println("===============================================");
            System.out.println("1. Display patients menu");
            System.out.println("2. Display doctors menu");
            System.out.println("3. Display medical records menu");
            System.out.println("4. Quit");
            System.out.println("===============================================");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("You choose to display patients menu.");
                    System.out.println("===============================================");
                    menu.menuPatient();
                    break;
                case 2:
                    System.out.println("You choose to display doctors menu.");
                    System.out.println("===============================================");
                    menu2.menuDoctor();
                    break;
                case 3:
                    System.out.println("You choose to display medical records menu.");
                    System.out.println("===============================================");
                    menu3.menuAppointment();
                    break;
                case 4:
                    System.out.println("You choose to quit.");
                    System.out.println("===============================================");
                    menu4.menuBilling();
                    break;
                default:
                    System.out.println("Please choose a valid option");
                    System.out.println("===============================================");
            }
        }
        System.out.println("Thank you for using our system");
        sc.close();

    }
}
