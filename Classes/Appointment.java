package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
    // Class which represents an appointment between a doctor and a patient

    private Doctor doctor;
    private Patient patient;
    private String date;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private int month;
    private int day;
    private int hour;

    public Appointment() {
    }

    public Appointment(Doctor doctor, Patient patient, Date date, int hour) {
        setDoctor(doctor);
        setPatient(patient);
        setDate(date);
        setHour(hour);
    }

    public Appointment(Doctor doctor, Patient patient, String date, int hour) {
        setDoctor(doctor);
        setPatient(patient);
        setDate(date);
        setHour(hour);
    }

    public Doctor getDoctor() {
        return this.doctor;
    }

    public void setDoctor(Doctor doctor) {
        try {
            if (doctor == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Appointment constructor");
            return;
        }
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        try {
            if (patient == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Appointment constructor");
            return;
        }
        this.patient = patient;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        try {
            if (date == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Appointment constructor");
            return;
        }
        this.date = date;
        setMonth(this.date);
        setDay(this.date);
    }

    public void setDate(Date date) {
        try {
            if (date == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Appointment constructor");
            return;
        }
        this.date = sdf.format(date);
        setMonth(this.date);
        setDay(this.date);
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(String date) {
        this.month = Integer.parseInt(date.substring(3, 5));
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(String date) {
        this.day = Integer.parseInt(date.substring(0, 2));
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        try {
            if (hour < 0 || hour > 23) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid hour in Appointment constructor");
            return;
        }
        this.hour = hour;
    }

    public String toJSON() {
        return "{\n" +
                "  \"doctor\": \"" + doctor.getName() + "\",\n" +
                "  \"doctor socialnumber\": \"" + doctor.getSocialNumber() + "\",\n" +
                "  \"patient\": \"" + patient.getName() + "\",\n" +
                "  \"patient socialnumber\" : \"" + patient.getSocialNumber() + "\",\n" +
                "  \"date\": \"" + date + "\",\n" +
                "  \"hour\": " + hour + "\n" +
                "}";
    }

    @Override
    public String toString() {
        return "[" + this.date + ", at " + +this.hour + "h, doctor=" + doctor.getName() + ", patient="
                + patient.getName() + "]";
    }

}
