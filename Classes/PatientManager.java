package Classes;

import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;

public class PatientManager {
    private String firstName;
    private String lastName;
    private String socialNumber;
    private String birthDate;
    private String phoneNumber;
    private String insuranceCompany;
    private static Scanner sc = new Scanner(System.in);

    private List<Patient> patients = new ArrayList<>();

    public void addPatientByFile(String fileName) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(fileName));
        while (inFile.hasNext()) {
            firstName = inFile.next();
            lastName = inFile.next();
            socialNumber = inFile.next();
            birthDate = inFile.next();
            int year = Integer.parseInt(birthDate.substring(0, 4));
            int month = Integer.parseInt(birthDate.substring(4, 6));
            int day = Integer.parseInt(birthDate.substring(6, 8));
            Date bd = new Date(year - 1900, month - 1, day);
            phoneNumber = inFile.next();
            insuranceCompany = inFile.next();
            Patient p = new Patient(firstName, lastName, socialNumber, bd, phoneNumber, insuranceCompany);
            patients.add(p);
        }
        inFile.close();
    }

    public void addPatient(Patient p) {
        this.patients.add(p);
    }

    public void writeFile(String fileName) throws IOException {
        File fout = new File(fileName); // create the file
        PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
        outFile.println("[");
        String data = "";
        for (Patient p : patients) {
            data += p.toJSON() + ",";
        }
        data = data.substring(0, data.length() - 1); // delete the last comma
        outFile.println(data + "\n]");
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
            input.close();

            return;
        }
        input.close();
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
        int year = Integer.parseInt(birthDate.substring(0, 4));
        int month = Integer.parseInt(birthDate.substring(4, 6));
        int day = Integer.parseInt(birthDate.substring(6, 8));
        Date bd = new Date(year - 1900, month - 1, day);
        System.out.println("Enter phone number: ");
        phoneNumber = input.next();
        System.out.println("Enter insurance company: ");
        insuranceCompany = input.next();
        Patient p = new Patient(firstName, lastName, socialNumber, bd, phoneNumber, insuranceCompany);
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

    public void menuPatient() {
        int option = 0;
        System.out.println("Choose an option :");

        while (option != 13) {
            System.out.println("1. List all patients");
            System.out.println("2. Search and display a patient");
            System.out.println("3. Add a patient");
            System.out.println("4. Add patient by file");
            System.out.println("5. Download patient file");
            System.out.println("6. Update a patient");
            System.out.println("7. Delete a patient");
            System.out.println("8. List all appointments");
            System.out.println("9. Search and display an appointment");
            System.out.println("10. Add an appointment");
            System.out.println("11. Update an appointment");
            System.out.println("12. Delete an appointment");
            System.out.println("13. Return to main menu");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("List all patients");
                    System.out.println("====================================");
                    this.listAllPatients();
                    break;
                case 2:
                    System.out.println("Search and display a patient");
                    System.out.println("====================================");
                    this.searchPatient();
                    break;
                case 3:
                    System.out.println("Add a patient");
                    System.out.println("====================================");
                    this.addPatient();
                    break;
                case 4:
                    System.out.println("Add patient by file");
                    System.out.println("====================================");
                    try {
                        this.addPatientByFile("Classes/InfoPatient.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Download patient file");
                    System.out.println("====================================");
                    try {
                        this.writeFile("DownloadPatient.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Update a patient");
                    System.out.println("====================================");
                    break;
                case 7:
                    System.out.println("Delete a patient");
                    System.out.println("====================================");
                    this.deletePatient();
                    break;
                case 8:
                    System.out.println("List all appointments");
                    System.out.println("====================================");
                    break;
                case 9:
                    System.out.println("Search and display an appointment");
                    System.out.println("====================================");
                    break;
                case 10:
                    System.out.println("Add an appointment");
                    System.out.println("====================================");
                    break;
                case 11:
                    System.out.println("Update an appointment");
                    System.out.println("====================================");
                    break;
                case 12:
                    System.out.println("Delete an appointment");
                    System.out.println("====================================");
                    break;
                case 13:
                    System.out.println("Return to main menu");
                    System.out.println("====================================");
                    break;
                default:
                    System.out.println("Invalid option");
                    System.out.println("====================================");
            }

        }

    }

}
