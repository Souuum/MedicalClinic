package Classes;

import java.util.*;
import java.io.*;

public class DoctorManager {

    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    private PatientManager pm;
    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Appointment> appointments;
    private ArrayList<Billing> billings;

    public DoctorManager() {
    }

    public DoctorManager(PatientManager pm) {
        this.pm = pm;
    }

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
            String[] doctorsData = data.split("\\},\\{\"f");

            for (String doctorData : doctorsData) {
                System.out.println(doctorData);
                doctorData = doctorData.trim();
                if (doctorData.charAt(doctorData.length() - 1) != '}') {
                    doctorData += "}";
                }
                String firstName = doctorData.substring(doctorData.indexOf("firstName") + 14,
                        doctorData.indexOf("lastName") - 5);
                String lastName = doctorData.substring(doctorData.indexOf("lastName") + 13,
                        doctorData.indexOf("socialNumber") - 5);
                String socialNumber = doctorData.substring(doctorData.indexOf("socialNumber") + 17,
                        doctorData.indexOf("birthDate") - 5);
                String birthDate = doctorData.substring(doctorData.indexOf("birthDate") + 14,
                        doctorData.indexOf("phoneNumber") - 5);
                String phoneNumber = doctorData.substring(doctorData.indexOf("phoneNumber") + 16,
                        doctorData.indexOf("specialty") - 5);
                String specialty = doctorData.substring(doctorData.indexOf("specialty") + 14,
                        doctorData.indexOf("schedule") - 5);
                System.out.println("----------------------");
                System.out.println("Adding doctor " + firstName + " " + lastName);
                Doctor d = new Doctor(firstName, lastName, socialNumber, birthDate, phoneNumber, specialty);
                System.out.println("----------------------");

                // Schedule import

                String scheduleData = doctorData.substring(doctorData.indexOf("schedule") + 13,
                        doctorData.indexOf("]}"));
                if (scheduleData.length() > 3) {
                    String[] sd = scheduleData.split("},");
                    sd[sd.length - 1] = sd[sd.length - 1].substring(0, sd[sd.length - 1].length() - 1); // getting rid
                                                                                                        // of
                                                                                                        // the la
                                                                                                        // t }
                    for (String app : sd) {
                        String sn = app.substring(app.indexOf("patient socialnumber") + 25, app.indexOf("date") - 5);
                        Patient p = this.findPatient(sn);
                        System.out.println(p);
                        String date = app.substring(app.indexOf("date") + 9, app.indexOf("hour") - 5);
                        int year = Integer.parseInt(date.substring(6, 9));
                        int month = Integer.parseInt(date.substring(3, 5));
                        int day = Integer.parseInt(date.substring(0, 2));
                        String hour = app.substring(app.indexOf("hour") + 8, app.length());
                        int h = Integer.parseInt(hour);

                        d.getSchedule().addAppointment(new Appointment(d, p, new Date(year - 1900, month - 1, day), h));

                    }
                }

                doctors.add(d);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    public Patient findPatient(String sn) {
        return pm.findPatient(sn);
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

    public Doctor searchDoctor() {
        System.out.println("Enter the social number of the doctor you want to search for");
        String socialNumber = sc.nextLine();
        for (Doctor d : doctors) {
            if (d.getSocialNumber().equals(socialNumber)) {
                System.out.println(d);
                return d;
            }
        }
        System.out.println("no match");
        return null;
    }

    public Doctor findDoctor(String sn) {
        for (Doctor d : doctors) {
            if (d.getSocialNumber() == sn) {
                return d;
            }
        }
        return null;
    }

    public void createBillingForPatient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter patient's social number : ");
        String socialNumber = sc.nextLine();
        Patient patient = null;
        for (Patient p : patients) {
            if (p.getSocialNumber().equals(socialNumber)) {
                patient = p;
                break;
            }
        }
        if (patient == null) {
            System.out.println("Patient not found");
            return;
        }

        System.out.println("Enter appointment date (dd/mm/yyyy) : ");
        String date = sc.nextLine();
        Appointment appointment = null;
        for (Appointment a : appointments) {
            if (a.getPatient().equals(patient) && a.getDate().equals(date)) {
                appointment = a;
                break;
            }
        }

        if (appointment == null) {
            System.out.println("No appointment found for this patient on this date");
            return;
        }

        System.out.println("Enter amount : ");
        double amount = sc.nextDouble();
        Billing billing = new Billing(patient, appointment, amount);
        billings.add(billing);
        System.out.println("Billing created for " + patient.getFirstName() + " for an amount of " + amount + "€");
    }

    public void listAllBillings() {
        if (billings.isEmpty()) {
            System.out.println("There are no billings");
        } else {
            for (Billing b : billings) {
                System.out.println(b);
            }
        }
    }

    public void searchBillings() {
        System.out.println("Enter patient's social number : ");
        String socialNumber = sc.nextLine();
        Patient patient = null;
        for (Patient p : patients) {
            if (p.getSocialNumber().equals(socialNumber)) {
                patient = p;
                break;
            }
        }
        if (patient == null) {
            System.out.println("Patient not found");
            return;
        }

        for (Billing b : billings) {
            if (b.getPatient().equals(patient)) {
                System.out.println(b);
            }
        }
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

        while (option != 11) {
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
            System.out.println("11. Return to main menu");
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
                    searchBillings();
                    break;
                case 11:
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
