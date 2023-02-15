
/**
 * @author Souuum
 */

import java.util.Date;
public class Bill extends Treatment {

    private Treatment treatment;
    private double amount;

    public Bill() {
    }

    public Bill(Treatment t, double a) {
        setTreatment(t);
        setAmount(a);
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount cannot be less than or equal to zero");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bill{" + "treatment=" + treatment + ", amount=" + amount + '}';
    }
}
