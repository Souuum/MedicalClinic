package MedicalClinic.Classes;

/**
 * @author Souuum
 */

import java.util.Date;

public class Treatment {

    private String name;
    private String description;
    private Doctor doctor;
    private Patient patient;
    private Date date;

    public Treatment() {
    }

    public Treatment(String n, String d, Doctor doc, Patient pat, Date da) {
        setName(n);
        setDescription(d);
        setDoctor(doc);
        setPatient(pat);
        setDate(da);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        try {
            if (description == null || description.isEmpty()) {
                throw new IllegalArgumentException("Description cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.description = description;
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

    @Override
    public String toString() {
        return "Treatment{" + "name=" + name + ", description=" + description + ", doctor=" + doctor.nameToString()
                + ", patient="
                + patient.nameToString() + ", date=" + date + '}';
    }

}
