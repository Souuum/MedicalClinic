package Classes;

/**
 * @author Souuum
 */

import java.util.Date;

public class Drugs {

    private String name;
    private String description;
    double price;
    private int quantity;
    private Date expirationDate;

    public Drugs() {
    }

    public Drugs(String n, String d, double p, int q, Date e) {
        setName(n);
        setDescription(d);
        setPrice(p);
        setQuantity(q);
        setExpirationDate(e);
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
            System.out.println("Error: Null value in Drugs constructor");
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
            System.out.println("Error: Null value in Drugs constructor");
            return;
        }
        this.description = description;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        try {
            if (price < 0) {
                throw new ArithmeticException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Price can't be null in constructor");
            return;
        }
        this.price = price;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        try {
            if (quantity < 1) {
                throw new ArithmeticException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Quantity can't be null or negative in constructor");
            return;
        }
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        try {
            if (expirationDate == null) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Null value in Drugs constructor");
            return;
        }
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Drugs{" + "name=" + name + ", description=" + description + ", price=" + price + ", quantity="
                + quantity
                + ", expirationDate=" + expirationDate + '}';
    }

}
