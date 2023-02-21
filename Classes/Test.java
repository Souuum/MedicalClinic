package Classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws IOException {

        // Patient p = new Patient("John", "Doe", "123456789", new Date(), "123456789",
        // "Aetna");
        // Doctor d = new Doctor("Jane", "Doe", "987654321", new Date(), "987654321",
        // "Aetna", "Cardiology");
        // Drugs dr = new Drugs("Aspirin", "Pain", 3, 1, 3, new Date());
        // Drugs dr2 = new Drugs("Ibuprofen", "Pain", 3, 1, 2, new Date());
        // Treatment t = new Treatment("Treatment", "Description", d, p, new
        // Date(2022,), new Date());

        // t.addDrugs(dr);
        // t.addDrugs(dr2);

        // System.out.println(t.toString());

        // int day = 31 + 14;
        // day = day % 7 == 0 ? 6 : day % 7 - 1;

        // System.out.println(day);

        Patient p = new Patient("John", "Doe", "123456789", new Date(), "123456789", "Aetna");
        Patient p1 = new Patient("Hugo", "Soum", "89732193", new Date(), "87889799", "Aetna");

        Doctor d = new Doctor("Jane", "Doe", "987654321", new Date(), "987654321", "Cardiology");
        Doctor doctor1 = new Doctor("John", "Doe", "123456789", new Date(), "123456789", "Cardiology");

        Date d1 = new Date();
        Date d2 = new Date(2023 - 1900, 11, 24); // Date is deprecated and the constructor set the year to 1900 + the
        System.out.println(d2);
        // year you pass as parameter and month is month-1 because it starts at 0

        Appointment a = new Appointment(d, p, d1, 14);
        Appointment a2 = new Appointment(d, p, d2, 15);

        d.getSchedule().addAppointment(a);
        d.getSchedule().addAppointment(a);
        d.getSchedule().addAppointment(a2);
        System.out.println(d.getScheduleString());

        System.out.println(d);

        PatientManager pm = new PatientManager();

        pm.addPatient(p);
        pm.addPatient(p1);

        pm.addPatientByJSON();

        pm.writeFile("Data/patients2.json");

        DoctorManager dm = new DoctorManager(pm);

        dm.addDoctor(d);
        dm.addDoctor(doctor1);

        dm.addDoctorByJSON();

        dm.writeFile("Data/doctors2.json");

        System.out.println("done");

        // Date db1 = new Date();
        // Doctor d1 = new Doctor("John", "Doe", "123456789", db1, "1234567890", "yo",
        // "yo");
        // System.out.println("Test by creating a first patient");
        // System.out.println("-------------------------------");
        // Patient p = new Patient("John", "Doe", "123456789", db1, "1234567890", "yo");
        // Treatment t1 = new Treatment("Fièvre", "yo", d1, p, db1);
        // System.out.println(p.toString());
        // System.out.println("-------------------------------");

        // System.out.println("Test by adding an appointment");
        // System.out.println("-------------------------------");
        // Appointment a = new Appointment(t1, db1, "12:00", "1234", "yo", d1, p);
        // p.addAppointment(a);
        // p.removeAppointment(a);
        // System.out.println(p.hasAppointmentWithDoctor(d1));
        // System.out.println("-------------------------------");

        // System.out.println("Test by adding a billing");
        // System.out.println("-------------------------------");
        // Billing b = new Billing(p, a, 10.0);
        // b.addService("Consultation médecin généraliste", 19.9);
        // p.addBilling(b);
        // System.out.println(p.listBillings());
        // System.out.println(b.getTotalCost());

    }

}
