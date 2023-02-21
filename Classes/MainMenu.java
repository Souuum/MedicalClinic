package Classes;

import java.util.Scanner;

public class MainMenu {

    private static Scanner sc = new Scanner(System.in);
    private static PatientManager pm = new PatientManager();
    private static DoctorManager dm = new DoctorManager(pm);

    public static void test() {
        Patient p1 = new Patient("Jean", "Dupont", "03213452123", "03/11/1980", "0102030405", "Aetna");

        System.out.println("...........................");
        System.out.println("Adding patient from object");
        dm.getPatientManager().addPatient(p1);
        dm.getPatientManager().listAllPatients();
        System.out.println("...........................");
        System.out.println("imoprting patients from JSON file");
        dm.getPatientManager().addPatientByJSON("Data/patients.json");
        dm.getPatientManager().listAllPatients();
        System.out.println("...........................");
        System.out.println(" Importing doctors from JSON file");
        dm.addDoctorByJSON("Data/doctors.json");
        dm.listAllDoctors();

    }

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println("Welcome to the medical center management system");
        System.out.println("===============================================");

        int option = 0;

        while (option != 5) {
            System.out.println("===============================================");
            System.out.println("Please choose an option:");
            System.out.println("===============================================");
            System.out.println("1. Display patients menu");
            System.out.println("2. Display doctors menu");
            System.out.println("3. Display medical records menu");
            System.out.println("4. Run demo");
            System.out.println("5. Quit");
            System.out.println("===============================================");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("You choose to display patients menu.");
                    System.out.println("===============================================");
                    dm.getPatientManager().menuPatient();
                    break;
                case 2:
                    System.out.println("You choose to display doctors menu.");
                    System.out.println("===============================================");
                    dm.menuDoctor();
                    break;
                case 3:
                    System.out.println("You choose to display medical records menu.");
                    System.out.println("===============================================");
                    break;
                case 4:
                    MainMenu.test();
                    break;
                case 5:
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
