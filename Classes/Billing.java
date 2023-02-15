package Classes;

import java.util.ArrayList;

public class Billing {
    private Patient patient;
    private ArrayList<String> services;
    private ArrayList<Double> costs;

    public Billing() {
    }

    public Billing(Patient p, Appointment a, Double c) {
        setPatient(p);
        services = new ArrayList<>();
        costs = new ArrayList<>();
        services.add(a.getTreatment().getName());
        costs.add(c);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        try {
            if (patient == null) {
                throw new IllegalArgumentException("Patient cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.patient = patient;
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public ArrayList<Double> getCosts() {
        return costs;
    }

    public void addService(String service, double cost) {
        services.add(service);
        costs.add(cost);
    }

    public void removeService(String service) {
        int index = services.indexOf(service);
        services.remove(index);
        costs.remove(index);
    }

    public double getTotalCost() {
        double total = 0;
        for (double cost : costs) {
            total += cost;
        }
        return total;
    }

    public void printBill() {
        System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Insurance Company: " + patient.getInsuranceCompany());
        System.out.println("Services: ");
        for (int i = 0; i < services.size(); i++) {
            System.out.println(services.get(i) + " - $" + costs.get(i));
        }
        System.out.println("Total: $" + getTotalCost());
    }

    public void printMedicalHistory() {
        System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Insurance Company: " + patient.getInsuranceCompany());
        System.out.println("Medical History: ");
        for (String medicalHistory : patient.getMedicalHistory()) {
            System.out.println(medicalHistory);
        }
    }

    public void printAppointmentHistory() {
        System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Insurance Company: " + patient.getInsuranceCompany());
        System.out.println("Appointment History: ");
        for (Appointment appointment : patient.getAppointments()) {
            System.out.println(appointment.getDate() + " - " + appointment.getDoctor().getFirstName() + " "
                    + appointment.getDoctor().getLastName());
        }
    }

    @Override

    public String toString() {
        return "Billing{" + "patient=" + patient + ", services=" + services + ", costs=" + costs + '}';
    }

}
