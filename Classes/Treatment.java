package Classes;


import java.util.Date;
import java.util.HashSet;
import java.text.SimpleDateFormat;

public class Treatment {

    private String name;
    private String description;
    private Doctor doctor;
    private Patient patient;
    private java.text.SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String date;
    private String dateEnd;
    private String duration = "";
    private HashSet<Drugs> drugs = new HashSet<Drugs>();

    public Treatment() {
    }

    public Treatment(String n, String d, Doctor doc, Patient pat, Date da, Date de) {
        setName(n);
        setDescription(d);
        setDoctor(doc);
        setPatient(pat);
        setDate(da);
        setDuration(da, de);
    }

    public String getName() {
        return this.name;
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

        return this.description;
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
        return this.doctor;
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
        return this.patient;
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

    public String getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        try {
            if (date == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Treatment constructor");
            return;
        }
        this.date = sdf.format(date);
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(Date date, Date dateEnd) {
        // set duration to the difference between date and dateEnd as a String with day
        // and weeks
        long diff = dateEnd.getTime() - date.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        long diffWeeks = diffDays / 7;
        diffDays = diffDays % 7;
        if (diffWeeks > 0) {
            duration = diffWeeks + " weeks and " + diffDays + " days";
        } else {
            duration = diffDays + " days";
        }
                throw new IllegalArgumentException("Date cannot be empty");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.date = date;
    }

    public HashSet<Drugs> getDrugsList() {
        return this.drugs;
    }

    public void addDrugs(Drugs d) {
        try {
            if (d == null) {
                throw new NullPointerException("Drugs can't be null");
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        try {
            if (this.drugs.add(d) != true) {
                throw new ArrayStoreException(" Drugs already in list");
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }

    @Override
    public String toString() {
        return "Treatment{" + "name=" + name + ", description=" + description + ", doctor=" + doctor.getName()
                + ", patient="
                + patient.getName() + ", date=" + date + ", duration=" + duration + ", drugs=" + drugs + '}';
    }

}
