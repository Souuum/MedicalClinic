package Classes;

import java.util.*;
import java.io.*;

public class PatientManager {
    private String firstName;
    private String lastName;
    private String socialNumber;
    private String birthDate;
    private String phoneNumber;
    private String insuranceCompany;

    List<Patient> patients = new ArrayList<>();

    public void addPatientByFile(String fileName) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(fileName));
        while (inFile.hasNext()) {
            firstName = inFile.next();
            lastName = inFile.next();
            socialNumber = inFile.next();
            birthDate = inFile.next();
            phoneNumber = inFile.next();
            insuranceCompany = inFile.next();
            Patient p = new Patient(firstName, lastName, socialNumber, birthDate, phoneNumber, insuranceCompany);
            patients.add(p);
        }
        inFile.close();
    }

    public void writeFile(String fileName) throws IOException {
        PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
        for (Patient p : patients) {
            outFile.println(p.getFirstName() + " " + p.getLastName() + " " + p.getSocialNumber() + " "
                    + p.getBirthDate() + " " + p.getPhoneNumber() + " " + p.getInsuranceCompany());
        }
        outFile.close();
    }

    public void listAllPatients() {
        System.out.println("Loading patients...");
        if (patients.isEmpty()) {
            System.out.println("No patients found");
        } else {
            for (Patient p : patients) {
                System.out.println(p.getFirstName() + " " + p.getLastName() + " " + p.getSocialNumber() + " "
                        + p.getBirthDate() + " " + p.getPhoneNumber() + " " + p.getInsuranceCompany());
            }
        }
    }

    public void searchPatient() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter social number: ");
        String socialNumber = input.next();

        boolean patientFound = false;

        for (Patient p : patients) {
            if (p.getSocialNumber().equals(socialNumber)) {
                System.out.println(p.getFirstName() + " " + p.getLastName() + " " + p.getSocialNumber() + " "
                        + p.getBirthDate() + " " + p.getPhoneNumber() + " " + p.getInsuranceCompany());
                patientFound = true;
            }
        }

        if (!patientFound) {
            System.out.println("Patient not found");
        }
    }

    public void addPatient() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first name: ");
        firstName = input.next();
        System.out.println("Enter last name: ");
        lastName = input.next();
        System.out.println("Enter social number: ");
        socialNumber = input.next();
        System.out.println("Enter birth date: ");
        birthDate = input.next();
        System.out.println("Enter phone number: ");
        phoneNumber = input.next();
        System.out.println("Enter insurance company: ");
        insuranceCompany = input.next();
        Patient p = new Patient(firstName, lastName, socialNumber, birthDate, phoneNumber, insuranceCompany);
        patients.add(p);
    }

    public void deletePatient() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter social number: ");
        String socialNumber = input.next();
        for (Patient p : patients) {
            if (p.getSocialNumber().equals(socialNumber)) {
                patients.remove(p);
            }
        }
    }

    public void updatePatient() {
        for (Patient p : patients) {
            if (p.getSocialNumber().equals(socialNumber)) {
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setBirthDate(birthDate);
                p.setPhoneNumber(phoneNumber);
                p.setInsuranceCompany(insuranceCompany);
            }
        }
    }

}
