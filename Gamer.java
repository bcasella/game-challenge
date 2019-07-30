import java.util.*;

public class Gamer {

    private int money;
    private int type; //0 = impulsive, 1=demanding, 2=carefull, 3=random

    public Gamer(int type, int name) {
        this.type = type;
        this.money = 0;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMoney() {
        return this.money;
    }

    public int getType() {
        return this.type;
    }

    public void makePlay(Property property) {

        if (property.getOwner() >= 0) return;

        if ( this.type == 0) {
            this.makeImpulsePlay(property);
        }
        else if (this.type == 1) {
            this.makeDemandingPlay(property);
        }
        else if (this.type == 2) {
            this.makeCarefullPlay(property);
        }
        else if (this.type == 3) {
            this.makeRandomPlay(property);
        }
    }

    private void makeImpulsePlay(Property property) {
        if (this.money > property.getSellingValue()) {
            property.setOwner(this.type);
            this.money -= property.getSellingValue();
        }
    }

    private void makeDemandingPlay(Property property) {
        if ((this.money > property.getSellingValue()) && property.getRentValue()>50) {
            property.setOwner(this.type);
            this.money -= property.getSellingValue();
        }
    }

    private void makeCarefullPlay(Property property) {
        if ((this.money > property.getSellingValue()) && ((this.money - property.getSellingValue()) > 80)) {
            property.setOwner(this.type);
            this.money -= property.getSellingValue();
        }
    }

    private void makeRandomPlay(Property property) {
        Random random = new Random();
        boolean value = random.nextBoolean();
        if(value && (this.money > property.getSellingValue())) {
            property.setOwner(this.type);
            this.money -= property.getSellingValue();
        }
    }
 }