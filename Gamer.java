
public class Gamer {
    private int money;
    private int type; //1 = impulsive, 2=demanding, 3=carefull, 4=random

    public Gamer(int money, int type) {

        this.money = money;
        this.type = type;
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

 }