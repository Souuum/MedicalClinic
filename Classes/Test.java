package Classes;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date db1 = new Date();
        Doctor d1 = new Doctor("John", "Doe", "123456789", db1, "1234567890", "yo", "yo");
        System.out.println("Test by creating a first patient");
        System.out.println("-------------------------------");
        Patient p = new Patient("John", "Doe", "123456789", db1, "1234567890", "yo");
        Treatment t1 = new Treatment("Fièvre", "yo", d1, p, db1);
        System.out.println(p.toString());
        System.out.println("-------------------------------");

        System.out.println("Test by adding an appointment");
        System.out.println("-------------------------------");
        Appointment a = new Appointment(t1, db1, "12:00", "1234", "yo", d1, p);
        p.addAppointment(a);
        p.removeAppointment(a);
        System.out.println(p.hasAppointmentWithDoctor(d1));
        System.out.println("-------------------------------");

        System.out.println("Test by adding a billing");
        System.out.println("-------------------------------");
        Billing b = new Billing(p);
        b.addService("Consultation médecin généraliste", 19.9);
        p.addBilling(b);
        p.removeBilling(b);
        System.out.println(p.listBillings());
    }

}
