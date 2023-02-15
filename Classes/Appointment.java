public class Appointment {
    private Treatment treatment;
    private Date date;
    private String time;
    private String location;
    private String notes;

    public Appointment() {
    }

    public Appointment(Treatment t, Date d, String time, String location, String notes) {
        setTreatment(t);
        setDate(d);
        setTime(time);
        setLocation(location);
        setNotes(notes);
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

    @Override
    public String toString() {
        return "Appointment{" + "treatment=" + treatment + ", date=" + date + ", time=" + time + ", location="
                + location + ", notes=" + notes + '}';
    }

}
