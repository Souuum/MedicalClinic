package Classes;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientManager menu = new PatientManager();
        DoctorManager menu2 = new DoctorManager();

        System.out.println("===============================================");
        System.out.println("Welcome to the medical center management system");
        System.out.println("===============================================");

        int option = 0;

        while (option != 3) {
            System.out.println("===============================================");
            System.out.println("Please choose an option:");
            System.out.println("===============================================");
            System.out.println("1. Display patients menu");
            System.out.println("2. Display doctors menu");
            System.out.println("3. Quit");
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
                    System.out.println("You choose to quit.");
                    System.out.println("===============================================");
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
