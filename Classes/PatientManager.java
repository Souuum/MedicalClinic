package Classes;

import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class PatientManager {
    private static Scanner sc = new Scanner(System.in);

    private List<Patient> patients = new ArrayList<Patient>();

    public void addPatientByFile(String fileName) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File(fileName));
        while (inFile.hasNext()) {
            String firstName = inFile.next();
            String lastName = inFile.next();
            String socialNumber = inFile.next();
            String birthDate = inFile.next();
            int year = Integer.parseInt(birthDate.substring(0, 4));
            int month = Integer.parseInt(birthDate.substring(4, 6));
            int day = Integer.parseInt(birthDate.substring(6, 8));
            Date bd = new Date(year - 1900, month - 1, day);
            String phoneNumber = inFile.next();
            String insuranceCompany = inFile.next();
            Patient p = new Patient(firstName, lastName, socialNumber, bd, phoneNumber,
                    insuranceCompany);
            patients.add(p);
        }
        inFile.close();
    }

    public void addPatientByJSON(String fileName) {
        try {
            if (fileName == null) {
                System.out.println("Enter the file directory and don't forget the file extension .json");
                fileName = sc.nextLine();
            }

            Scanner inFile = new Scanner(new File(fileName));
            String data = "";
            while (inFile.hasNext()) {
                data += inFile.nextLine();
            }
            inFile.close();
            data = data.substring(1, data.length() - 1);
            String[] patientsData = data.split("},");
            patientsData[patientsData.length - 1] = patientsData[patientsData.length - 1].substring(0,
                    patientsData[patientsData.length - 1].indexOf("}") - 2) + "}";

            for (String patientData : patientsData) {
                patientData = patientData.trim();
                if (patientData.charAt(patientData.length() - 1) != '}') {
                    patientData += "}";
                }
                String firstName = patientData.substring(patientData.indexOf("firstName") + 13,
                        patientData.indexOf("lastName") - 7);
                String lastName = patientData.substring(patientData.indexOf("lastName") + 12,
                        patientData.indexOf("socialNumber") - 7);
                String socialNumber = patientData.substring(patientData.indexOf("socialNumber") + 16,
                        patientData.indexOf("birthDate") - 7);
                String birthDate = patientData.substring(patientData.indexOf("birthDate") + 13,
                        patientData.indexOf("phoneNumber") - 7);
                String phoneNumber = patientData.substring(patientData.indexOf("phoneNumber") + 15,
                        patientData.indexOf("insuranceCompany") - 7);
                String insuranceCompany = patientData.substring(patientData.indexOf("insuranceCompany") + 20,
                        patientData.indexOf("}") - 1);
                Patient p = new Patient(firstName, lastName, socialNumber, birthDate, phoneNumber,
                        insuranceCompany);

                System.out.println("----------------------");
                System.out.println("Adding patient " + firstName + " " + lastName);
                patients.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public Patient findPatient(String sn) {
        System.out.println("----------------------");
        System.out.println("looking for patient with socialnumber " + sn);
        System.out.println("----------------------");

        for (Patient p : patients) {
            if (p.getSocialNumber().equals(sn)) {
                System.out.println("Find a match");
                return p;
            }
        }
        System.out.println("No match found");
        return null;
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
                System.out.println(p);
            }
        }
    }

    public void searchPatient() {
        System.out.println("Enter social number: ");
        String socialNumber = sc.next();

        boolean patientFound = false;

        for (Patient p : patients) {
            if (p.getSocialNumber().equals(socialNumber)) {
                System.out.println(p.toString());
                patientFound = true;
            }
        }

        if (!patientFound) {
            System.out.println("Patient not found");

            return;
        }
    }

    public void addPatient() {
        System.out.println("Enter first name: ");
        String firstName = sc.next();
        System.out.println("Enter last name: ");
        String lastName = sc.next();
        System.out.println("Enter social number: ");
        String socialNumber = sc.next();
        System.out.println("Enter birth date: ");
        String birthDate = sc.next();

        System.out.println("Enter phone number: ");
        String phoneNumber = sc.next();
        System.out.println("Enter insurance company: ");
        String insuranceCompany = sc.next();
        Patient p = new Patient(firstName, lastName, socialNumber, birthDate, phoneNumber, insuranceCompany);
        patients.add(p);
    }

    public void deletePatient() {

        System.out.println("Enter social number: ");
        String socialNumber = sc.nextLine();
        System.out.println("Deleting patient with socialnumber " + socialNumber);
        Patient p = this.findPatient(socialNumber);

        patients.remove(p);
        System.out.println("Done ! ");

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

        while (option != 8) {
            System.out.println("1. List all patients");
            System.out.println("2. Search and display a patient");
            System.out.println("3. Add a patient");
            System.out.println("4. Add patient by file");
            System.out.println("5. Delete a patient");
            System.out.println("6. Export patients to JSON");
            System.out.println("7. Import patients from JSON");
            System.out.println("8. Return to main menu");
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
                    System.out.println("Delete a patient");
                    System.out.println("====================================");
                    this.deletePatient();
                    break;
                case 6:
                    System.out.println("Export Patients as JSON");
                    System.out.println("====================================");
                    try {
                        this.writeFile("Data/patientsExport.json");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("Import patients from JSON");
                    System.out.println("====================================");
                    this.addPatientByJSON(null);
                case 8:
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
