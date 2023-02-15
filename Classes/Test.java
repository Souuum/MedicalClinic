package Classes;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Patient p = new Patient("John", "Doe", "123456789", new Date(), "123456789", "Aetna");
        Doctor d = new Doctor("Jane", "Doe", "987654321", new Date(), "987654321", "Aetna", "Cardiology");
        Drugs dr = new Drugs("Aspirin", "Pain", 3, 1, new Date());
        Drugs dr2 = new Drugs("Ibuprofen", "Pain", 3, 1, new Date());
        Treatment t = new Treatment("Treatment", "Description", d, p, new Date(), new Date());

        t.addDrugs(dr);
        t.addDrugs(dr2);

        System.out.println(t.toString());
    }
}
