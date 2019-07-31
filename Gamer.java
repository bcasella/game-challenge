import java.util.*;

public class Gamer {

    private int money;
    private int type; //0 = impulsive, 1=demanding, 2=carefull, 3=random
    private boolean isInGame;
    private int positionInBoard;

    public Gamer(int type) {
        this.type = type;
        this.money = 300;
        this.isInGame = true;
        this.positionInBoard = 0;
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

    public int getPosition() {
        return this.positionInBoard;
    }

    public void walk(int walk) {
        if (this.positionInBoard+walk > 19) {
            this.money+=100;
            this.positionInBoard = this.positionInBoard + walk - 19;
        }
    }
    
    public void addMoney(int money) {
        this.money += money;
    }

    public boolean isInGame() {
        return this.isInGame;
    }

    public void makePlay(Property property) {

        if (property.getOwner() == null) {

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
        else {
            //pague o aluguel!
            this.payTheRent(property);
        }
    }

    private void payTheRent(Property property) {
        this.money -= property.getRentValue();
        property.getOwner().addMoney(property.getRentValue());
        if (this.money < 0) {
            this.isInGame = false;
        }
    }

    private void makeImpulsePlay(Property property) {
        if (this.money > property.getSellingValue()) {
            property.setOwner(this);
            this.money -= property.getSellingValue();
        }
    }

    private void makeDemandingPlay(Property property) {
        if ((this.money > property.getSellingValue()) && property.getRentValue()>50) {
            property.setOwner(this);
            this.money -= property.getSellingValue();
        }
    }

    private void makeCarefullPlay(Property property) {
        if ((this.money > property.getSellingValue()) && ((this.money - property.getSellingValue()) > 80)) {
            property.setOwner(this);
            this.money -= property.getSellingValue();
        }
    }

    private void makeRandomPlay(Property property) {
        Random random = new Random();
        boolean value = random.nextBoolean();
        if(value && (this.money > property.getSellingValue())) {
            property.setOwner(this);
            this.money -= property.getSellingValue();
        }
    }
 }