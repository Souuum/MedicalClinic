package Classes;

public class Week {
    // This class implements week for the schedule class

    private Appointment[][] week = new Appointment[7][24];

    public Week() {
    }

    public Appointment[][] getWeek() {
        return this.week;
    }

    public void addAppointment(Appointment appointment, int indexD) {
        // Method which adds an appointment to the schedule
        // The method will check if the doctor is available at the time of the
        // appointment
        // If the doctor is available then the appointment will be added to the schedule
        // If the doctor is not available then the appointment will not be added to the
        // schedule
        int hour = appointment.getHour();
        int day = indexD % 7 == 0 ? 6 : indexD % 7 - 1;
        if (isAvailable(appointment, indexD)) {
            System.out.println("adding appointment for doctor " + appointment.getDoctor().getName() + " on the "
                    + appointment.getDay() + "/" + appointment.getMonth() + " at " + appointment.getHour() + "h");
            this.week[day][hour] = appointment;
        }
    }

    public boolean isAvailable(Appointment appointment, int indexD) {
        // Method which checks if the doctor is available at the time of the appointment
        int hour = appointment.getHour();
        int day = indexD % 7 == 0 ? 6 : indexD % 7 - 1;
        System.out.println("checking availability for doctor " + appointment.getDoctor().getName() + " on the "
                + appointment.getDay() + "/" + appointment.getMonth() + " at " + appointment.getHour() + "h");
        if (this.week[day][hour] == null) {
            return true;
        } else {

            System.out.println("Doctor " + appointment.getDoctor().getName() + " is not available on the "
                    + appointment.getDay() + "/" + appointment.getMonth() + " at " + appointment.getHour() + "h");
            return false;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                if (this.week[i][j] != null) {
                    s += this.week[i][j].toString() + "\n";
                }
            }
        }
        return s;
    }
}
