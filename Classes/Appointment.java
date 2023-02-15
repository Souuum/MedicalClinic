package Classes;

import java.util.Date;

public class Appointment {
    private Treatment treatment;
    private Date date;
    private String time;
    private String location;
    private String notes;
    private Doctor doctor;
    private Patient patient;

    public Appointment() {
    }

    public Appointment(Treatment t, Date d, String ti, String l, String n, Doctor doc, Patient pat) {
        setTreatment(t);
        setDate(d);
        setTime(ti);
        setLocation(l);
        setNotes(n);
        setDoctor(doc);
        setPatient(pat);
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        try {
            if (treatment == null) {
                throw new IllegalArgumentException("Treatment cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.treatment = treatment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        try {
            if (date == null) {
                throw new IllegalArgumentException("Date cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        try {
            if (time == null || time.isEmpty()) {
                throw new IllegalArgumentException("Time cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        try {
            if (location == null || location.isEmpty()) {
                throw new IllegalArgumentException("Location cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        try {
            if (notes == null || notes.isEmpty()) {
                throw new IllegalArgumentException("Notes cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.notes = notes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        try {
            if (doctor == null) {
                throw new IllegalArgumentException("Doctor cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        try {
            if (patient == null) {
                throw new IllegalArgumentException("Patient cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.patient = patient;
    }

    @Override

    public String toString() {
        return "Appointment{" + "treatment=" + treatment + ", date=" + date + ", time=" + time + ", location="
                + location + ", notes=" + notes + ", doctor=" + doctor + '}';
    }

}