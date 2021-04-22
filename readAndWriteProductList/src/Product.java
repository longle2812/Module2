import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String company;
    private double price;
    private String other;

    public Product(int id, String name, String company, double price, String other) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
        this.other = other;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", other='" + other + '\'' +
                '}';
    }
}
