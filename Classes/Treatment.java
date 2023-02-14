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
        this.name = n;
        this.description = d;
        this.doctor = doc;
        this.patient = pat;
        this.date = da;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Treatment{" + "name=" + name + ", description=" + description + ", doctor=" + doctor.nameToString()
                + ", patient="
                + patient.nameToString() + ", date=" + date + '}';
    }

}
