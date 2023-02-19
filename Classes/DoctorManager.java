package Classes;

public class DoctorManager {

    public void menuDoctor() {
        int option = 0;
        System.out.println("Choose an option :");

        while (option != 12) {
            System.out.println("1. List all doctors sort by first name");
            System.out.println("2. Search and display a doctor");
            System.out.println("3. Add a doctor");
            System.out.println("4. Add doctor by file");
            System.out.println("5. Download doctor file");
            System.out.println("6. Update a doctor");
            System.out.println("7. Delete a doctor");
            System.out.println("8. Create a billing for a patient");
            System.out.println("9. List all billings");
            System.out.println("10. Search and display all billing for a patient");
            System.out.println("11. Search and display all billing for a doctor");
            System.out.println("12. Return to main menu");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("List all doctors sort by first name");
                    System.out.println("====================================");
                    sortDoctorsByFirstName();
                    listAllDoctors();
                    break;
                case 2:
                    System.out.println("Search and display a doctor");
                    System.out.println("====================================");
                    searchDoctor();
                    break;
                case 3:
                    System.out.println("Add a doctor");
                    System.out.println("====================================");
                    addDoctor();
                    break;
                case 4:
                    System.out.println("Add doctor by file");
                    System.out.println("====================================");
                    addDoctorByFile();
                    break;
                case 5:
                    System.out.println("Download doctor file");
                    System.out.println("====================================");
                    downloadDoctorFile();
                    break;
                case 6:
                    System.out.println("Update a doctor");
                    System.out.println("====================================");
                    updateDoctor();
                    break;
                case 7:
                    System.out.println("Delete a doctor");
                    System.out.println("====================================");
                    deleteDoctor();
                    break;
                case 8:
                    System.out.println("Create a billing for a patient");
                    System.out.println("====================================");
                    createBillingForPatient();
                    break;
                case 9:
                    System.out.println("List all billings");
                    System.out.println("====================================");
                    listAllBillings();
                    break;
                case 10:
                    System.out.println("Search and display all billing for a patient");
                    System.out.println("====================================");
                    searchAllBillingsForPatient();
                    break;
                case 11:
                    System.out.println("Search and display all billing for a doctor");
                    System.out.println("====================================");
                    searchAllBillingsForDoctor();
                    break;
                case 12:
                    System.out.println("Return to main menu");
                    System.out.println("====================================");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

}
