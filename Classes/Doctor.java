package Classes;

/**
 * @author Souuum
 */

import java.util.Date;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends Person {

    private String specialty;
    private ArrayList<Appointment> appointments;
    private ArrayList<Billing> billings;
    private Scanner sc = new Scanner(System.in);
    DoctorManager d = new DoctorManager();

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
                    d.sortDoctorsByFirstName();
                    d.listAllDoctors();
                    break;
                case 2:
                    System.out.println("Search and display a doctor");
                    System.out.println("====================================");
                    d.searchDoctor();
                    break;
                case 3:
                    System.out.println("Add a doctor");
                    System.out.println("====================================");
                    d.addDoctor();
                    break;
                case 4:
                    System.out.println("Add doctor by file");
                    System.out.println("====================================");
                    try {
                        d.addDoctorByFile("Classes/Doctors.txt");
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Download doctor file");
                    System.out.println("====================================");
                    try {
                        d.downloadDoctorFile("DownloadedDoctors.txt");
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Update a doctor");
                    System.out.println("====================================");
                    d.updateDoctor();
                    break;
                case 7:
                    System.out.println("Delete a doctor");
                    System.out.println("====================================");
                    d.deleteDoctor();
                    break;
                case 8:
                    System.out.println("Create a billing for a patient");
                    System.out.println("====================================");
                    d.createBillingForPatient();
                    break;
                case 9:
                    System.out.println("List all billings");
                    System.out.println("====================================");
                    d.listAllBillings();
                    break;
                case 10:
                    System.out.println("Search and display all billing for a patient");
                    System.out.println("====================================");
                    d.searchAllBillingsForPatient();
                    break;
                case 11:
                    System.out.println("Return to main menu");
                    System.out.println("====================================");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

    public Doctor() {
    }

    public Doctor(String f, String l, String s, String d, String p, String sp) {
        super(f, l, s, d, p);
        setSpecialty(sp);
        appointments = new ArrayList<>();
        billings = new ArrayList<>();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        try {
            if (specialty == null || specialty.isEmpty()) {
                throw new IllegalArgumentException("Specialty cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.specialty = specialty;
    }

    public void generateBilling(Patient patient, Date date, double amount, String description) {
        // Vérifier si le patient a un rendez-vous avec ce médecin à cette date
        Appointment appointment = null;
        for (Appointment a : appointments) {
            if (a.getDoctor().equals(this) && a.getPatient().equals(patient) && a.getDate().equals(date)) {
                appointment = a;
                break;
            }
        }
        if (appointment == null) {
            System.out.println("Aucun rendez-vous trouvé pour ce patient avec ce médecin à cette date");
            return;
        }

        // Ajouter la facture pour le patient
        Billing billing = new Billing(patient, appointment, amount);
        billings.add(billing);
        System.out.println("Facture générée pour " + patient.getFirstName() + " pour un montant de " + amount + "€");
    }

    @Override
    public String toString() {
        return "Doctor{" + "firstName=" + firstName + ", lastName=" + lastName + ", socialNumber=" + socialNumber
                + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", specialty=" + specialty + '}';
    }

}
