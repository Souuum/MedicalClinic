package Classes;

import java.util.*;
import java.io.*;

public class DoctorManager {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private ArrayList<Billing> billings = new ArrayList<Billing>();

    public void listAllDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public void sortDoctorsByFirstName() {
        Collections.sort(doctors, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor d1, Doctor d2) {
                return d1.getFirstName().compareTo(d2.getFirstName());
            }
        });
    }

    public void searchDoctor() {
        System.out.println("Enter the doctor's first name :");
        String firstName = sc.nextLine();
        System.out.println("Enter the doctor's last name :");
        String lastName = sc.nextLine();
        for (Doctor doctor : doctors) {
            if (doctor.getFirstName().equals(firstName) && doctor.getLastName().equals(lastName)) {
                System.out.println(doctor);
            }
        }
    }

    public void addDoctor() {
            Doctor doctor = new Doctor();
            System.out.println("Enter the doctor's first name :");
            doctor.setFirstName(sc.nextLine());
            System.out.println("Enter the doctor's last name :");
            doctor.setLastName(sc.nextLine());
            System.out.println("Enter the doctor's phone number :");
            doctor.setPhoneNumber(sc.nextLine());
            System.out.println("Enter the doctor's email :");
            doctor.setEmail(sc.nextLine());
            System.out.println("Enter the doctor's address :");
            doctor.setAddress(sc.nextLine());
            System.out.println("Enter the doctor's specialty :");
            doctor.setSpecialty(sc.nextLine());
            doctors.add(doctor);
        }

    public void addDoctorByFile() {
            try {
                File file = new File("doctors.txt");
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] data = line.split(";");
                    Doctor doctor = new Doctor();
                    doctor.setFirstName(data[0]);
                    doctor.setLastName(data[1]);
                    doctor.setPhoneNumber(data[2]);
                    doctor.setEmail(data[3]);
                    doctor.setAddress(data[4]);
                    doctor.setSpecialty(data[5]);
                    doctors.add(doctor);
                }
                sc.close();

}
