package Classes;

import java.util.*;
import java.io.*;
import java.util.Date;

public class DoctorManager {

    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    private PatientManager pm;
    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Treatment> treatments = new ArrayList<Treatment>();
    private ArrayList<Billing> billings = new ArrayList<Billing>();

    public DoctorManager() {
    }

    public DoctorManager(PatientManager pm) {
        this.pm = pm;
    }

    public void addDoctorByFile() throws FileNotFoundException {
        System.out.println("Enter the file directory and don't forget the file extension .txt");
        String fileName = sc.nextLine();
        Scanner inFile = new Scanner(new File(fileName));
        while (inFile.hasNext()) {
            String firstName = inFile.next();
            String lastName = inFile.next();
            String socialNumber = inFile.next();
            String birthDate = inFile.next();
            String phone = inFile.next();
            String specialty = inFile.next();
            Doctor d = new Doctor(firstName, lastName, socialNumber, birthDate, phone, specialty);
            doctors.add(d);
        }
        inFile.close();
    }

    public void addDoctorByJSON(String fileName) {
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
            String[] doctorsData = data.split("\\},  \\{    \"f");
            doctorsData[doctorsData.length - 1] = doctorsData[doctorsData.length - 1].substring(0,
                    doctorsData[doctorsData.length - 1].length() - 3);

            for (String doctorData : doctorsData) {
                doctorData = doctorData.trim();
                if (doctorData.charAt(doctorData.length() - 1) != '}') {
                    doctorData += "}";
                }

                String firstName = doctorData.substring(doctorData.indexOf("firstName") + 13,
                        doctorData.indexOf("lastName") - 7);
                String lastName = doctorData.substring(doctorData.indexOf("lastName") + 12,
                        doctorData.indexOf("socialNumber") - 7);
                String socialNumber = doctorData.substring(doctorData.indexOf("socialNumber") + 16,
                        doctorData.indexOf("birthDate") - 7);
                String birthDate = doctorData.substring(doctorData.indexOf("birthDate") + 13,
                        doctorData.indexOf("phoneNumber") - 7);
                String phoneNumber = doctorData.substring(doctorData.indexOf("phoneNumber") + 15,
                        doctorData.indexOf("specialty") - 7);
                String specialty = doctorData.substring(doctorData.indexOf("specialty") + 13,
                        doctorData.indexOf("schedule") - 7);
                System.out.println("----------------------");
                System.out.println("Adding doctor " + firstName + " " + lastName);
                Doctor d = new Doctor(firstName, lastName, socialNumber, birthDate, phoneNumber, specialty);
                System.out.println("----------------------");

                // Schedule import

                String scheduleData = doctorData.substring(doctorData.indexOf("schedule") + 12,
                        doctorData.indexOf("]}"));
                if (scheduleData.length() > 3) {
                    String[] sd = scheduleData.split("},");
                    sd[sd.length - 1] = sd[sd.length - 1].substring(0, sd[sd.length - 1].length() - 1); // getting rid
                                                                                                        // of
                                                                                                        // the la
                                                                                                        // t }
                    for (String app : sd) {
                        String sn = app.substring(app.indexOf("patient socialnumber") + 24, app.indexOf("date") - 11);
                        Patient p = this.findPatient(sn);
                        System.out.println(p);
                        String date = app.substring(app.indexOf("date") + 8, app.indexOf("hour") - 11);
                        String hour = app.substring(app.indexOf("hour") + 7, app.length() - 4).trim();
                        int h = Integer.parseInt(hour);

                        d.getSchedule().addAppointment(new Appointment(d, p, date, h));

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

    public void addDoctor() {
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
        System.out.println("Enter the specialty: ");
        String specialty = sc.next();
        Doctor d = new Doctor(firstName, lastName, socialNumber, birthDate, phoneNumber, specialty);
        doctors.add(d);
    }

    public void writeFile(String fileName) throws IOException {
        File fout = new File(fileName); // create the file
        PrintWriter outFile = new PrintWriter(fout);
        outFile.println("[");
        String data = "";
        for (Doctor d : doctors) {
            data += d.toJSON() + ",";
            System.out.println(data);

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

    public void deleteDoctor() {

        System.out.println("Enter social number: ");
        String socialNumber = sc.nextLine();
        System.out.println("Deleting Doctor with socialnumber " + socialNumber);
        Doctor d = this.findDoctor(socialNumber);

        doctors.remove(d);
        System.out.println("Done ! ");

    }

    public Doctor findDoctor(String sn) {
        System.out.println("----------------------");
        System.out.println("looking for Doctor with socialnumber " + sn);
        System.out.println("----------------------");

        for (Doctor d : doctors) {
            if (d.getSocialNumber().equals(sn)) {
                System.out.println("Find a match");
                return d;
            }
        }
        System.out.println("No match found");
        return null;
    }

    public void createAppointmentForPatient() {
        System.out.println("Enter patient's social number : ");
        String socialNumber = sc.nextLine();
        Patient patient = this.findPatient(socialNumber);
        if (patient == null) {
            System.out.println("Patient not found");
            return;
        }

        System.out.println("Enter doctor's social number : ");
        String doctorSocialNumber = sc.nextLine();
        Doctor doctor = this.findDoctor(doctorSocialNumber);
        if (doctor == null) {
            System.out.println("Doctor not found");
            return;
        }
        System.out.println("Enter appointment date (dd/mm/yyyy) : ");
        String date = sc.nextLine();
        System.out.println("Enter appointment hour : ");
        int hour = Integer.parseInt(sc.nextLine());

        Appointment appointment = new Appointment(doctor, patient, date, hour);
        doctor.getSchedule().addAppointment(appointment);
        System.out.println("Done !");
    }

    public void listAllAppointmentForPatient() {
        System.out.println("Enter patient's social number : ");
        String socialNumber = sc.nextLine();
        Patient patient = this.findPatient(socialNumber);
        if (patient == null) {
            System.out.println("Patient not found");
            return;
        }
        System.out.println("Looking into Doctor's schedules...");

        for (Doctor d : doctors) {
            for (Appointment a : d.getSchedule().getAllAppointments()) {
                if (a != null) {
                    if (a.getPatient().getSocialNumber().equals(socialNumber)) {
                        System.out.println(a);
                    }
                }

            }
        }
    }

    public void createBillingForPatient() {
        System.out.println("Enter patient's social number : ");
        String socialNumber = sc.nextLine();
        Patient patient = this.findPatient(socialNumber);
        if (patient == null) {
            System.out.println("Patient not found");
            return;
        }
        System.out.println("Enter doctor's social number : ");
        String doctorSocialNumber = sc.nextLine();
        Doctor doctor = this.findDoctor(doctorSocialNumber);
        if (doctor == null) {
            System.out.println("Doctor not found");
            return;
        }
        System.out.println("Enter appointment date (dd/mm/yyyy) : ");
        String date = sc.nextLine();
        System.out.println("Enter appointment hour : ");
        int hour = Integer.parseInt(sc.nextLine());
        for (Appointment a : doctor.getSchedule().getAllAppointments()) {
            if (a != null) {
                System.out.println(a);
                if (a.getPatient().getSocialNumber().equals(socialNumber)
                        && a.getDate().equals(date)
                        && a.getHour() == hour) {
                    System.out.println("Enter the amount of the bill : ");
                    double amount = Double.parseDouble(sc.nextLine());
                    Billing billing = new Billing(a, amount);
                    billings.add(billing);
                    System.out.println("Done !");
                    return;
                }
            }

        }
        System.out.println("No match found !");

    }

    public void listAllBillings() {
        System.out.println("Loading billings...");
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
        Patient patient = this.findPatient(socialNumber);
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

    public void createTreatmentForPatient() {
        System.out.println("Enter patient's social number : ");
        String socialNumber = sc.nextLine();
        Patient patient = this.findPatient(socialNumber);
        if (patient == null) {
            System.out.println("Patient not found");
            return;
        }
        System.out.println("Enter doctor's social number : ");
        String doctorSocialNumber = sc.nextLine();
        Doctor doctor = this.findDoctor(doctorSocialNumber);
        if (doctor == null) {
            System.out.println("Doctor not found");
            return;
        }
        System.out.println("Enter appointment date (dd/mm/yyyy) : ");
        String date = sc.nextLine();
        System.out.println("Enter appointment hour : ");
        int hour = Integer.parseInt(sc.nextLine());
        for (Appointment a : doctor.getSchedule().getAllAppointments()) {
            if (a != null) {
                System.out.println(a);
                if (a.getPatient().getSocialNumber().equals(socialNumber)
                        && a.getDate().equals(date)
                        && a.getHour() == hour) {
                    System.out.println("Enter the Description : ");
                    String desc = sc.nextLine();
                    System.out.println("Enter the starting date");
                    String startDate = sc.nextLine();
                    System.out.println("Enter the ending date");
                    String endDate = sc.nextLine();
                    Treatment t = new Treatment(a, desc, startDate, endDate);
                    treatments.add(t);
                    System.out.println("Done !");
                    return;
                }
            }

        }
        System.out.println("No match found !");

    }

    public void listAllTreatments() {
        System.out.println("Loading treatments...");
        if (treatments.isEmpty()) {
            System.out.println("There are no treatments");
        } else {
            for (Treatment t : treatments) {
                System.out.println(t);
            }
        }
    }

    public void listAllTreatmentForPatient() {
        System.out.println("Enter patient's social number : ");
        String socialNumber = sc.nextLine();
        Patient patient = this.findPatient(socialNumber);
        if (patient == null) {
            System.out.println("Patient not found");
            return;
        }
        System.out.println("Looking into Doctor's schedules...");

        for (Treatment t : treatments) {
            if (t.getPatient().getSocialNumber().equals(socialNumber)) {
                System.out.println(t);
            }
        }
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public PatientManager getPatientManager() {
        return pm;
    }

    public void menuDoctor() throws IOException {
        int option = 0;
        System.out.println("Choose an option :");

        while (option != 15) {
            System.out.println("1. List all doctors sort by first name");
            System.out.println("2. Search and display a doctor");
            System.out.println("3. Add a doctor");
            System.out.println("4. Add doctor by file");
            System.out.println("5. Delete a doctor");
            System.out.println("6. Export doctors to JSON");
            System.out.println("7. Import doctors from JSON file");
            System.out.println("8. Create an appointment for a patient");
            System.out.println("9. List all appointments for a patient");
            System.out.println("10. List all billings");
            System.out.println("11. Create a billing for a patient");
            System.out.println("12. Search and display all billing for a patient");
            System.out.println("13. Create a treatment for a patient");
            System.out.println("14. List all treatments for a patient");
            System.out.println("15. Return to main menu");
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
                    System.out.println("Delete a doctor");
                    System.out.println("====================================");
                    deleteDoctor();
                    break;
                case 6:
                    System.out.println("Export doctors to JSON");
                    System.out.println("====================================");
                    this.writeFile("Data/doctorsExport.json");
                    break;
                case 7:
                    System.out.println("Import doctors from JSON");
                    System.out.println("====================================");
                    this.addDoctorByJSON(null);
                    break;
                case 8:
                    System.out.println("Create an appointment for a patient");
                    System.out.println("====================================");
                    createAppointmentForPatient();
                    break;
                case 9:
                    System.out.println("List all appointments for a patient");
                    System.out.println("====================================");
                    listAllAppointmentForPatient();
                    break;
                case 10:
                    System.out.println("List all billings");
                    System.out.println("====================================");
                    listAllBillings();
                    break;
                case 11:
                    System.out.println("Create a billing for a patient");
                    System.out.println("====================================");
                    createBillingForPatient();
                    break;
                case 12:
                    System.out.println("Search and display all billing for a patient");
                    System.out.println("====================================");
                    searchBillings();
                    break;
                case 13:
                    System.out.println("Create a treatment for a patient");
                    System.out.println("====================================");
                    createTreatmentForPatient();
                    break;
                case 14:
                    System.out.println("List all treatments for a patient");
                    System.out.println("====================================");
                    listAllTreatmentForPatient();
                    break;

                case 15:
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
