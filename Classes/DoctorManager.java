package Classes;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class DoctorManager {

    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    private static Scanner sc = new Scanner(System.in);

    public void addDoctorByFile(String fileName) throws FileNotFoundException {
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
            String phone = inFile.next();
            String specialty = inFile.next();
            Doctor d = new Doctor(firstName, lastName, socialNumber, bd, phone, specialty);
            doctors.add(d);
        }
        inFile.close();
    }

    public void addDoctorByJSON(String fileName) {
        try {
            Scanner inFile = new Scanner(new File(fileName));
            String data = "";
            while (inFile.hasNext()) {
                data += inFile.nextLine();
            }
            inFile.close();
            data = data.substring(1, data.length() - 1);
            String[] doctorsData = data.split("},");

            for (String doctorData : doctorsData) {
                doctorData = doctorData.trim();
                if (doctorData.charAt(doctorData.length() - 1) != '}') {
                    doctorData += "}";
                }
                String firstName = doctorData.substring(doctorData.indexOf("firstName") + 14,
                        doctorData.indexOf("lastName") - 5);
                String lastName = doctorData.substring(doctorData.indexOf("lastName") + 13,
                        doctorData.indexOf("socialNumber") - 5);
                String socialNumber = doctorData.substring(doctorData.indexOf("socialNumber") + 19,
                        doctorData.indexOf("birthDate") - 5);
                String birthDate = doctorData.substring(doctorData.indexOf("birthDate") + 14,
                        doctorData.indexOf("phone") - 5);
                String phoneNumber = doctorData.substring(doctorData.indexOf("phone") + 9,
                        doctorData.indexOf("id") - 5);
                String specialty = doctorData.substring(doctorData.indexOf("specialty") + 14,
                        doctorData.indexOf("patients") - 5);

                Doctor d = new Doctor(firstName, lastName, socialNumber, birthDate, phoneNumber, specialty);
                doctors.add(d);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void addDoctor(Doctor d) {
        try {
            if (d == null) {
                throw new IllegalArgumentException("Doctor cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        doctors.add(d);
    }

    public void writeFile(String fileName) throws IOException {
        File fout = new File(fileName); // create the file
        PrintWriter outFile = new PrintWriter(fout);
        outFile.println("[");
        String data = "";
        for (Doctor d : doctors) {
            data += d.toJSON() + ",";
        }
        data = data.substring(0, data.length() - 1); // delete the last comma
        outFile.println(data + "\n]");
        outFile.close();
    }

    public void listAllDoctors() {
        System.out.println("Loading patients...");
        if (doctors.isEmpty()) {
            System.out.println("There are no doctors");
        } else {
            for (Doctor d : doctors) {
                System.out.println(d);
            }
        }
    }

    public void sortDoctorsByFirstName() {
        doctors.sort((d1, d2) -> d1.getFirstName().compareTo(d2.getFirstName()));
    }

    public void searchDoctor() {
        System.out.println("Enter the social number of the doctor you want to search for");
        String socialNumber = sc.nextLine();
        for (Doctor d : doctors) {
            if (d.getSocialNumber().equals(socialNumber)) {
                System.out.println(d);
                return;
            }
        }
        System.out.println("Doctor not found");
    }

    

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void menuDoctor() {
        int option = 0;
        System.out.println("Choose an option :");

        while (option != 12) {
            System.out.println("1. List all doctors sort by first name");
            System.out.println("2. Search and display a doctor");
            System.out.println("3. Add a doctor");
            System.out.println("4. Add doctor by file");
            System.out.println("5. Download doctor file");
            System.out.println("6. Update a doctor");
            System.out.println("7. Delete a doctor");
            System.out.println("8. Create a billing for a patient");
            System.out.println("9. List all billings");
            System.out.println("10. Search and display all billing for a patient");
            System.out.println("11. Search and display all billing for a doctor");
            System.out.println("12. Return to main menu");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("List all doctors sort by first name");
                    System.out.println("====================================");
                    sortDoctorsByFirstName();
                    listAllDoctors();
                    break;
                case 2:
                    System.out.println("Search and display a doctor");
                    System.out.println("====================================");
                    searchDoctor();
                    break;
                case 3:
                    System.out.println("Add a doctor");
                    System.out.println("====================================");
                    addDoctor();
                    break;
                case 4:
                    System.out.println("Add doctor by file");
                    System.out.println("====================================");
                    addDoctorByFile();
                    break;
                case 5:
                    System.out.println("Download doctor file");
                    System.out.println("====================================");
                    downloadDoctorFile();
                    break;
                case 6:
                    System.out.println("Update a doctor");
                    System.out.println("====================================");
                    updateDoctor();
                    break;
                case 7:
                    System.out.println("Delete a doctor");
                    System.out.println("====================================");
                    deleteDoctor();
                    break;
                case 8:
                    System.out.println("Create a billing for a patient");
                    System.out.println("====================================");
                    createBillingForPatient();
                    break;
                case 9:
                    System.out.println("List all billings");
                    System.out.println("====================================");
                    listAllBillings();
                    break;
                case 10:
                    System.out.println("Search and display all billing for a patient");
                    System.out.println("====================================");
                    searchAllBillingsForPatient();
                    break;
                case 11:
                    System.out.println("Search and display all billing for a doctor");
                    System.out.println("====================================");
                    searchAllBillingsForDoctor();
                    break;
                case 12:
                    System.out.println("Return to main menu");
                    System.out.println("====================================");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

    }

}
