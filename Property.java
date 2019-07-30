
public class Property {
    private int sellingValue;
    private int rentValue;
    private String owner;

    public Property(int sellingValue, int rentValue) {

        this.sellingValue = sellingValue;
        this.rentValue = rentValue;
    }

    public Property(int sellingValue, int rentValue, String owner) {

        this.sellingValue = sellingValue;
        this.rentValue = rentValue;
        this.owner = owner;
    }
 
    public void setSellingValue(int sellingValue) {
        this.sellingValue = sellingValue;
    }

    public void setRentValue(int rentValue) {
        this.rentValue = rentValue;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getSellingValue() {
        return this.sellingValue;
    }

    public int getRentValue() {
        return this.rentValue;
    }

    public String setOwner() {
        return this.owner;
    }
 }