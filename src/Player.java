import java.util.Scanner;

public class Player {
    private final String name;
    private final Inventory inv;
    Scanner sc = new Scanner(System.in);
    private int damage, health, money, maxHealth;
    private String chrName;


    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectChr() {
        switch (chrMenu()) {
            case 1 -> initPlayer("the samurai", 5, 21, 15, 21);
            case 2 -> initPlayer("the archer", 7, 18, 20, 18);
            case 3 -> initPlayer("the paladin", 8, 24, 5, 24);
            default -> //default character is samurai to avoid bugs
                    initPlayer("the samurai", 5, 21, 15, 21);
        }
        System.out.println("\ncreated character: " + getChrName());
    }

    public int chrMenu() {
        int chrID = 0;
        boolean validChoice = false;

        while (!validChoice) {
            try {
                System.out.println("\nchoose your character, " + name + "!\n");
                System.out.println("1- the samurai \t (damage: 5 \t health: 21 \t money: 15)");
                System.out.println("2- the archer \t (damage: 7 \t health: 18 \t money: 20)");
                System.out.println("3- the paladin \t (damage: 8 \t health: 24 \t money: 5)");
                System.out.print("\nchoice (1-3): ");
                String input = sc.nextLine();
                chrID = Integer.parseInt(input);

                if (chrID >= 1 && chrID <= 3) {
                    validChoice = true;
                } else {
                    System.out.println("\noops, that's not right! i said between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\noopsie, that's not right! i said between 1 and 5.");
            }
        }

        return chrID;
    }

    private void initPlayer(String name, int damage, int health, int money, int maxHealth) {
        setChrName(name);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setMaxHealth(maxHealth);
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getChrName() {
        return chrName;
    }

    public void setChrName(String chrName) {
        this.chrName = chrName;
    }

    public Inventory getInv() {
        return inv;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInv().getDamage();
    }
}
