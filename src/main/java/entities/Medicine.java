package entities;

public class Medicine {
    private int id;
    private String name;
    private int price;
    private String expiration_date;
    private String manufacturer;


    public Medicine(int id, String name, int price, String expiration_date, String manufacturer) {
        setId(id);
        setName(name);
        setPrice(price);
        setExpiration_date(expiration_date);
        setManufacturer(manufacturer);
    }

    public Medicine(String name, int price, String expiration_date, String manufacturer) {
        setName(name);
        setPrice(price);
        setExpiration_date(expiration_date);
        setManufacturer(manufacturer);
    }

    public static void add(Medicine med) {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        System.out.println("Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", expiration date=" + expiration_date + '\'' +
                ", manufacturer=" + manufacturer +
                '}');
        return null;
    }

}
