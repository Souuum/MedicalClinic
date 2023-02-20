package Classes;

/**
 * @author Souuum
 */

import java.util.Date;
import java.util.ArrayList;

public class Doctor extends Person {

    private String specialty;
    private Schedule schedule = new Schedule();
    private ArrayList<Appointment> appointments;
    private ArrayList<Billing> billings;

    public Doctor() {
    }

    public Doctor(String f, String l, String s, Date d, String p, String sp, Schedule sc) {
        super(f, l, s, d, p);
        this.specialty = sp;
        this.schedule = sc;
    }

    public Doctor(String f, String l, String s, Date d, String p, String sp) {
        super(f, l, s, d, p);
        setSpecialty(sp);
        appointments = new ArrayList<>();
        billings = new ArrayList<>();
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

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getScheduleString() {
        return this.getName() + "'s schedule\n" + this.schedule.toString();
    }

    public void generateBilling(Doctor doctor, Patient patient, Date date, double amount) {
        // Vérifier si le patient a un rendez-vous avec ce médecin à cette date
        Appointment appointment = null;
        for (Appointment a : appointments) {
            if (a.getDoctor().equals(doctor) && a.getPatient().equals(patient) && a.getDate().equals(date)) {
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

    public String toJSON() {
        return "{\n" +
                "  \"firstName\" : \"" + firstName + "\",\n" +
                "  \"lastName\" : \"" + lastName + "\",\n" +
                "  \"socialNumber\" : \"" + socialNumber + "\",\n" +
                "  \"birthDate\" : \"" + birthDate + "\",\n" +
                "  \"phoneNumber\" : \"" + phoneNumber + "\",\n" +
                "  \"specialty\" : \"" + specialty + "\",\n" +
                "  \"schedule\" : " + schedule.toJSON() + "\n" +
                "}";
    }

    @Override
    public String toString() {
        return "Doctor{" + "firstName :" + firstName + ", lastName :" + lastName + ", socialNumber :" + socialNumber
                + ", birthDate :" + birthDate + ", phoneNumber :" + phoneNumber + ", specialty :" + specialty
                + ", schedule : " + this.getScheduleString() + '}';
    }

}
