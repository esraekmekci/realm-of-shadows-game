import java.util.Random;

public class Obstacle {
    private int damage, health, award, maxNumber;
    private String name;

    public Obstacle(int damage, int health, int award, int maxNumber, String name) {
        this.damage = damage;
        this.health = health;
        this.award = award;
        this.maxNumber = maxNumber;
        this.name = name;
    }

    public int count() {
        Random r = new Random();
        return r.nextInt(this.maxNumber) + 1;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
