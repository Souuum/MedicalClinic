package Classes;

import java.util.Date;
import java.util.HashSet;

public class Treatment {

    private String name;
    private String description;
    private Doctor doctor;
    private Patient patient;
    private Date date;
    private Date dateEnd;
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
        setDuration(de);
        setDuration();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        try {
            if (name == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Treatment constructor");
            return;
        }
        this.name = name;
    }

    public String getDescription() {

        return this.description;
    }

    public void setDescription(String description) {
        try {
            if (description == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Treatment constructor");
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
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Treatment constructor");
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
            System.out.println("Error: Null value in Treatment constructor");
            return;
        }
        this.patient = patient;
    }

    public Date getDate() {
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
        this.date = date;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(Date dateEnd) {
        // if duration is null or if duration is before date then throw exception
        try {
            if (duration == null) {
                throw new NullPointerException();
            }
            if (dateEnd.before(date)) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Treatment constructor");
            return;
        }
        this.dateEnd = dateEnd;
    }

    public void setDuration() {
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
        return "Treatment{" + "name=" + name + ", description=" + description + ", doctor=" + doctor.nameToString()
                + ", patient="
                + patient.nameToString() + ", date=" + date + ", duration=" + duration + ", drugs=" + drugs + '}';
    }

}
