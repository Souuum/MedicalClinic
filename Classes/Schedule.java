package Classes;

public class Schedule {
    // Class which implements the schedule of the doctor
    // It will be used to check if the doctor is available at a certain time
    // The schedule will be implemented as a matrix of 7x24 which will represent the
    // days of the week and the hours of the day
    // The matrix will be filled with Appointment objects which will be used to
    // check if the doctor is available at a certain time
    // The matrix will be initialized with null values

    private Appointment[][] schedule = new Appointment[7][24];

}
