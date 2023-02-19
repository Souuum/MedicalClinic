package Classes;

/**
 * @author Souuum
 */

import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends Person {

    private String specialty;
    private Schedule schedule;
    private ArrayList<Billing> billings;
    private Scanner sc = new Scanner(System.in);

    public void menuDoctor() {
        int option = 0;
        System.out.println("Choisissez une option :");

        while (option != 5) {
            System.out.println("1. Générer une facture");
            System.out.println("2. Consulter mes rendez-vous");
            System.out.println("3. Consulter mes factures");
            System.out.println("4. Consulter mon dossier médical");
            System.out.println("5. Quitter");
            option = sc.nextInt();
            sc.nextLine();

        }

    }

    public Doctor() {
    }

    public Doctor(String f, String l, String s, Date d, String p, String i, String sp, Schedule sc) {
        super(f, l, s, d, p);
        this.specialty = sp;
        this.schedule = sc;

    public Doctor(String f, String l, String s, String d, String p, String i, String sp) {
        super(f, l, s, d, p);
        setSpecialty(sp);
        billings = new ArrayList<>();
        this.schedule = new Schedule();
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getScheduleString() {
        return this.getName() + "'s schedule\n" + this.schedule.toString();
    }

    public void generateBilling(Patient patient, Date date, double amount) {
        // Vérifier si le patient a un rendez-vous avec ce médecin à cette date
        Appointment appointment = null;
        for (Appointment a : this.schedule.getAllAppointments()) {
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
                + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", specialty=" + specialty
                + ", schedule : " + this.getScheduleString() + '}';
    }

}
