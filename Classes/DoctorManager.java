package Classes;

import java.util.*;
import java.io.*;

public class DoctorManager {

    private Scanner sc = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String socialNumber;
    private String birthDate;
    private String phoneNumber;
    private String specialty;

    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    private ArrayList<Patient> patients = new ArrayList<Patient>();
    private ArrayList<Billing> billings = new ArrayList<Billing>();

    public void addDoctorByFile(String fileName) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(fileName));
        System.out.println("Loading file...");
        while (inFile.hasNext()) {
            firstName = inFile.next();
            lastName = inFile.next();
            socialNumber = inFile.next();
            birthDate = inFile.next();
            phoneNumber = inFile.next();
            specialty = inFile.next();
            Doctor doctor = new Doctor(firstName, lastName, socialNumber, birthDate, phoneNumber, specialty);
            doctors.add(doctor);
        }
        inFile.close();
        System.out.println("File loaded successfully");
    }

    public void downloadDoctorFile(String fileName) throws IOException {
        PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
        System.out.println("Saving file...");
        for (Doctor doctor : doctors) {
            outFile.println(doctor.toString());
        }
        outFile.close();
    }

    public void listAllDoctors() {
        System.out.println("Loading doctors...");
        if (doctors.isEmpty()) {
            System.out.println("No doctors found");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor.toString());
            }
        }
    }

    public void searchDoctor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the social number :");
        String socialNumber = input.nextLine();

        boolean doctorFound = false;

        for (Doctor doctor : doctors) {
            if (doctor.getSocialNumber().equals(socialNumber)) {
                System.out.println(doctor.toString());
                doctorFound = true;
            }
        }

        if (!doctorFound) {
            System.out.println("No doctor found");
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

    public void addDoctor() {
        Doctor doctor = new Doctor();
        System.out.println("Enter the doctor's first name :");
        firstName = sc.nextLine();
        System.out.println("Enter the doctor's last name :");
        lastName = sc.nextLine();
        System.out.println("Enter the doctor's social number :");
        socialNumber = sc.nextLine();
        System.out.println("Enter the doctor's birth date :");
        birthDate = sc.nextLine();
        System.out.println("Enter the doctor's phone number :");
        phoneNumber = sc.nextLine();
        System.out.println("Enter the doctor's specialty :");
        specialty = sc.nextLine();
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setSocialNumber(socialNumber);
        doctor.setBirthDate(birthDate);
        doctor.setPhoneNumber(phoneNumber);
        doctor.setSpecialty(specialty);
        doctors.add(doctor);
    }

    public void deleteDoctor() {
        System.out.println("Enter the social number of the doctor you want to delete :");
        String socialNumber = sc.nextLine();
        boolean doctorFound = false;
        for (Doctor doctor : doctors) {
            if (doctor.getSocialNumber().equals(socialNumber)) {
                doctors.remove(doctor);
                doctorFound = true;
                System.out.println("Doctor deleted");
            }
        }
        if (!doctorFound) {
            System.out.println("No doctor found");
        }
    }

    public void updateDoctor() {
        System.out.println("Enter the social number of the doctor you want to update :");
        String socialNumber = sc.nextLine();

        boolean doctorFound = false;
        for (Doctor doctor : doctors) {
            if (doctor.getSocialNumber().equals(socialNumber)) {
                System.out.println("Would you like to update the doctor's first name ? (Y/N)");
                String answer = sc.nextLine();
                if (answer.equals("Y") || answer.equals("y")) {
                    System.out.println("Enter the doctor's first name :");
                    firstName = sc.nextLine();
                    doctor.setFirstName(firstName);
                } else {
                    firstName = doctor.getFirstName();
                }
                System.out.println("Would you like to update the doctor's last name ? (Y/N)");
                answer = sc.nextLine();
                if (answer.equals("Y") || answer.equals("y")) {
                    System.out.println("Enter the doctor's last name :");
                    lastName = sc.nextLine();
                    doctor.setLastName(lastName);
                } else {
                    lastName = doctor.getLastName();
                }
                System.out.println("Would you like to update the doctor's social number ? (Y/N)");
                answer = sc.nextLine();
                if (answer.equals("Y") || answer.equals("y")) {
                    System.out.println("Enter the doctor's social number :");
                    socialNumber = sc.nextLine();
                    doctor.setSocialNumber(socialNumber);
                } else {
                    socialNumber = doctor.getSocialNumber();
                }
                System.out.println("Would you like to update the doctor's birth date ? (Y/N)");
                answer = sc.nextLine();
                if (answer.equals("Y") || answer.equals("y")) {
                    System.out.println("Enter the doctor's birth date :");
                    birthDate = sc.nextLine();
                    doctor.setBirthDate(birthDate);
                } else {
                    birthDate = doctor.getBirthDate();
                }
                System.out.println("Would you like to update the doctor's phone number ? (Y/N)");
                answer = sc.nextLine();
                if (answer.equals("Y") || answer.equals("y")) {
                    System.out.println("Enter the doctor's phone number :");
                    phoneNumber = sc.nextLine();
                    doctor.setPhoneNumber(phoneNumber);
                } else {
                    phoneNumber = doctor.getPhoneNumber();
                }
                System.out.println("Would you like to update the doctor's specialty ? (Y/N)");
                answer = sc.nextLine();
                if (answer.equals("Y") || answer.equals("y")) {
                    System.out.println("Enter the doctor's specialty :");
                    specialty = sc.nextLine();
                    doctor.setSpecialty(specialty);
                } else {
                    specialty = doctor.getSpecialty();
                }
                doctor.setFirstName(firstName);
                doctor.setLastName(lastName);
                doctor.setSocialNumber(socialNumber);
                doctor.setBirthDate(birthDate);
                doctor.setPhoneNumber(phoneNumber);
                doctor.setSpecialty(specialty);
                doctorFound = true;
                System.out.println("Doctor updated");
            }
        }
        if (!doctorFound) {
            System.out.println("No doctor found");
        }
    }

    public void createBillingForPatient() {

    }

    public void displayBillingsForPatient() {
        System.out.println("Enter the social number of the patient you want to display the billings for :");
        String socialNumber = sc.nextLine();
        boolean patientFound = false;
        for (Patient patient : patients) {
            if (patient.getSocialNumber().equals(socialNumber)) {
                System.out.println(patient.getBillings().toString());
                patientFound = true;
            }
        }
        if (!patientFound) {
            System.out.println("No patient found");
        }
    }

    public void listAllBillings() {
        for (Patient patient : patients) {
            System.out.println(patient.getBillings().toString());
        }
    }

    public void searchAllBillingsForPatient(){
        System.out.println("Enter the social number of the patient you want to search the billings for :");
        String socialNumber = sc.nextLine();
        boolean patientFound = false;
        for (Patient patient : patients) {
            if (patient.getSocialNumber().equals(socialNumber)) {
                System.out.println("Enter the billing's date :");
                String date = sc.nextLine();
                System.out.println("Enter the billing's amount :");
                String amount = sc.nextLine();
                System.out.println("Enter the billing's description :");
                String description = sc.nextLine();
                Billing billing = new Billing(date, amount, description);
                if (patient.getBillings().contains(billing)) {
                    System.out.println("Billing found");
                } else {
                    System.out.println("Billing not found");
                }
                patientFound = true;
            }
        }
        if (!patientFound) {
            System.out.println("No patient found");
        }
    }