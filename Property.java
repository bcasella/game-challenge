
public class Property {
    private int sellingValue;
    private int rentValue;
    private int place;
    private Gamer owner;

    public Property(int sellingValue, int rentValue, int place) {

        this.sellingValue = sellingValue;
        this.rentValue = rentValue;
        this.owner = null;
        this.place = place;
    }

    public Property(int sellingValue, int rentValue, Gamer owner) {

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

    public void setOwner(Gamer owner) {
        this.owner = owner;
    }

    public int getSellingValue() {
        return this.sellingValue;
    }

    public int getRentValue() {
        return this.rentValue;
    }

    public Gamer getOwner() {
        return this.owner;
    }

    public int getPlace() {
        return place;
    }
 }