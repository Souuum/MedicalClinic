package MedicalClinic;

/**
 * @author Souuum
 */
public class Patient extends Person {

    private String insuranceCompany;

    public Patient() {
    }

    public Patient(String f, String l, String s, Date d, String p, String i) {
        super(f, l, s, d, p);
        this.insuranceCompany = i;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    @Override
    public String toString() {
        return "Patient{" + "firstName=" + firstName + ", lastName=" + lastName + ", socialNumber=" + socialNumber
                + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", insuranceCompany=" + insuranceCompany
                + '}';
    }

}
