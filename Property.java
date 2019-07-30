
public class Property {
    private int sellingValue;
    private int rentValue;
    private int owner;

    public Property(int sellingValue, int rentValue) {

        this.sellingValue = sellingValue;
        this.rentValue = rentValue;
        this.owner = -1;
    }

    public Property(int sellingValue, int rentValue, int owner) {

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

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getSellingValue() {
        return this.sellingValue;
    }

    public int getRentValue() {
        return this.rentValue;
    }

    public int getOwner() {
        return this.owner;
    }
 }