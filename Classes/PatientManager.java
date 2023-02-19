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
            outFile.println(p.toString());
        }
        outFile.close();
    }

    public void listAllPatients() {
        System.out.println("Loading patients...");
        if (patients.isEmpty()) {
            System.out.println("No patients found");
        } else {
            for (Patient p : patients) {
                System.out.println(p.toString());
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
                System.out.println(p.toString());
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
        input.close();
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
        input.close();
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

    // sort patients by first name

    public void sortPatientsByFirstName() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return p1.getFirstName().compareTo(p2.getFirstName());
            }
        });
    }

    // sort patients by last name

    public void sortPatientsByLastName() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return p1.getLastName().compareTo(p2.getLastName());
            }
        });
    }

    // sort patients by social number

    public void sortPatientsBySocialNumber() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return p1.getSocialNumber().compareTo(p2.getSocialNumber());
            }
        });
    }

    // sort patients by birth date

    public void sortPatientsByBirthDate() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return p1.getBirthDate().compareTo(p2.getBirthDate());
            }
        });
    }

    // sort patients by phone number

    public void sortPatientsByPhoneNumber() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return p1.getPhoneNumber().compareTo(p2.getPhoneNumber());
            }
        });
    }

    // sort patients by insurance company

    public void sortPatientsByInsuranceCompany() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return p1.getInsuranceCompany().compareTo(p2.getInsuranceCompany());
            }
        });
    }

}
