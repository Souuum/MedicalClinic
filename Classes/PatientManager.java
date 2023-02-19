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
        System.out.println("====================================");
        System.out.println("Loading file...");
        System.out.println("====================================");
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
        System.out.println("====================================");
        System.out.println("File loaded");
        System.out.println("====================================");
        inFile.close();
    }

    public void downloadPatientFile(String fileName) throws IOException {
        PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
        System.out.println("====================================");
        System.out.println("Saving file...");
        System.out.println("====================================");
        for (Patient p : patients) {
            outFile.println(p.toString());
        }
        System.out.println("====================================");

        System.out.println("====================================");
        outFile.close();
    }

    public void listAllPatients() {
        System.out.println("====================================");
        System.out.println("Loading patients...");
        System.out.println("====================================");
        if (patients.isEmpty()) {
            System.out.println("====================================");
            System.out.println("No patients found");
            System.out.println("====================================");
        } else {
            for (Patient p : patients) {
                int index = patients.indexOf(p) + 1;
                System.out.println("====================================");
                System.out.println("Patient " + index);
                System.out.println(p.toString());
                System.out.println("====================================");
            }
        }
    }

    public void searchPatient() {
        Scanner input = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("Enter social number: ");
        System.out.println("====================================");
        String socialNumber = input.next();

        boolean patientFound = false;

        for (Patient p : patients) {
            if (p.getSocialNumber().equals(socialNumber)) {
                System.out.println("====================================");
                System.out.println("Patient found");
                System.out.println("====================================");
                System.out.println(p.toString());
                patientFound = true;
                System.out.println("====================================");
            }
        }

        if (!patientFound) {
            System.out.println("====================================");
            System.out.println("Patient not found");
            System.out.println("====================================");
        }
    }

    public void addPatient() {
        Scanner input = new Scanner(System.in);
        System.out.println("====================================");
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
        System.out.println("Enter the social number of the patient you want to delete : ");
        String socialNumber = input.next();
        Iterator<Patient> iterator = patients.iterator();
        boolean patientFound = false;
        while (iterator.hasNext()) {
            Patient p = iterator.next();
            if (p.getSocialNumber().equals(socialNumber)) {
                iterator.remove();
                System.out.println("Patient deleted");
                patientFound = true;
            }
        }
        if (!patientFound) {
            System.out.println("Patient not found");
        }
        input.close();
    }

    public void updatePatient() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter social number: ");
        String socialNumber = input.next();

        boolean patientFound = false;
        for (Patient p : patients) {
            if (p.getSocialNumber().equals(socialNumber)) {
                patientFound = true;
                System.out.println("Would you like to update first name? (y/n)");
                String answer = input.next();
                if (answer.equals("y") || answer.equals("Y")) {
                    System.out.println("Enter first name: ");
                    firstName = input.next();
                } else {
                    firstName = p.getFirstName();
                }
                System.out.println("Would you like to update last name? (y/n)");
                answer = input.next();
                if (answer.equals("y") || answer.equals("Y")) {
                    System.out.println("Enter last name: ");
                    lastName = input.next();
                } else {
                    lastName = p.getLastName();
                }
                System.out.println("Would you like to update social number? (y/n)");
                answer = input.next();
                if (answer.equals("y") || answer.equals("Y")) {
                    System.out.println("Enter social number: ");
                    socialNumber = input.next();
                } else {
                    socialNumber = p.getSocialNumber();
                }
                System.out.println("Would you like to update birth date? (y/n)");
                answer = input.next();
                if (answer.equals("y") || answer.equals("Y")) {
                    System.out.println("Enter birth date: ");
                    birthDate = input.next();
                } else {
                    birthDate = p.getBirthDate();
                }
                System.out.println("Would you like to update phone number? (y/n)");
                answer = input.next();
                if (answer.equals("y") || answer.equals("Y")) {
                    System.out.println("Enter phone number: ");
                    phoneNumber = input.next();
                } else {
                    phoneNumber = p.getPhoneNumber();
                }
                System.out.println("Would you like to update insurance company? (y/n)");
                answer = input.next();
                if (answer.equals("y") || answer.equals("Y")) {
                    System.out.println("Enter insurance company: ");
                    insuranceCompany = input.next();
                } else {
                    insuranceCompany = p.getInsuranceCompany();
                }
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setSocialNumber(socialNumber);
                p.setBirthDate(birthDate);
                p.setPhoneNumber(phoneNumber);
                p.setInsuranceCompany(insuranceCompany);
                System.out.println("Patient updated");
            }
        }
        if (!patientFound) {
            System.out.println("No patients found");
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
