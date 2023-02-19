package Classes;

public class Schedule {
    // Class which implements the schedule of the doctor
    // It will be used to check if the doctor is available at a certain time
    // The schedule will be implemented as a matrix of weeks which will represent
    // the
    // The matrix will be filled with Appointment objects which will be used to
    // check if the doctor is available at a certain time
    // The matrix will be initialized with null values
    private final int[] dayInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // day in each month
    private Week[] schedule = new Week[52];
    // we assume that the date 23/02/2023 at 1 pm is the 23+31=54 day of the year
    // which should be

    public Schedule() {
        for (int i = 0; i < 52; i++) {
            this.schedule[i] = new Week();
        }
    }

    public void addAppointment(Appointment appointment) {
        // Method which adds an appointment to the schedule
        // The method will check if the doctor is available at the time of the
        // appointment
        // If the doctor is available then the appointment will be added to the schedule
        // If the doctor is not available then the appointment will not be added to the
        // schedule
        int day = appointment.getDay();
        int month = appointment.getMonth();
        int nday = 0;
        for (int i = 0; i < month - 1; i++) {
            nday += this.dayInMonth[i];
        }
        day += nday;
        int indexW = day / 7; // index of week
        System.out.println(day);
        System.out.println(indexW);
        this.schedule[indexW].addAppointment(appointment, nday);
    }

    public Appointment[] getAllAppointments() {
        Appointment[] appointments = new Appointment[8736]; // 7*24*52
        int index = 0;
        for (Week week : this.schedule) {
            for (Appointment appointment : week.getAllAppointments()) {
                if (appointment != null) {
                    appointments[index] = appointment;
                    index++;
                }
            }
        }
        return appointments;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 52; i++) {
            if (this.schedule[i].toString() != "") {
                s += this.schedule[i].toString();
            }
        }
        return s == "" ? "No appointments" : s;
    }

}
