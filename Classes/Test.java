package Classes;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        // Patient p = new Patient("John", "Doe", "123456789", new Date(), "123456789",
        // "Aetna");
        // Doctor d = new Doctor("Jane", "Doe", "987654321", new Date(), "987654321",
        // "Aetna", "Cardiology");
        // Drugs dr = new Drugs("Aspirin", "Pain", 3, 1, 3, new Date());
        // Drugs dr2 = new Drugs("Ibuprofen", "Pain", 3, 1, 2, new Date());
        // Treatment t = new Treatment("Treatment", "Description", d, p, new
        // Date(2022,), new Date());

        // t.addDrugs(dr);
        // t.addDrugs(dr2);

        // System.out.println(t.toString());

        // int day = 31 + 14;
        // day = day % 7 == 0 ? 6 : day % 7 - 1;

        // System.out.println(day);

        Schedule schedule = new Schedule();

        Patient p = new Patient("John", "Doe", "123456789", new Date(), "123456789",
                "Aetna");

        Doctor d = new Doctor("Jane", "Doe", "987654321", new Date(), "987654321",
                "Aetna", "Cardiology", schedule);

        System.out.println(schedule);

        Date d1 = new Date();
        Date d2 = new Date(2021, 3, 1, 12, 0);

        Appointment a = new Appointment(d, p, d1, 15);

        schedule.addAppointment(a);
        System.out.println(schedule);
        schedule.addAppointment(a);
        System.out.println(schedule);
    }
}
