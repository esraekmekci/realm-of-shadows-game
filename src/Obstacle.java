import java.util.Random;

public class Obstacle {
    private final int damage;
    private final int award;
    private final int maxNumber;
    private final String name;
    private int health;

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAward() {
        return award;
    }

    public String getName() {
        return name;
    }


}
