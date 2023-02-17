package Classes;

/**
 * @author Souuum
 */

import java.util.Date;

public class Doctor extends Person {

    private String specialty;
    private Schedule schedule;

    public Doctor() {
    }

    public Doctor(String f, String l, String s, Date d, String p, String i, String sp, Schedule sc) {
        super(f, l, s, d, p);
        this.specialty = sp;
        this.schedule = sc;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getScheduleString() {
        return this.getName() + "'s schedule\n" + this.schedule.toString();
    }

    @Override
    public String toString() {
        return "Doctor{" + "firstName=" + firstName + ", lastName=" + lastName + ", socialNumber=" + socialNumber
                + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", specialty=" + specialty + '}';
    }

}
