public abstract class BattleLoc extends Location {
    protected Obstacle obstacle;
    protected String award;

    public BattleLoc(Player player, String name, Obstacle obstacle, String itemName) {
        super(player);
        this.obstacle = obstacle;
        this.name = name;
        this.award = itemName;
    }

    public boolean getLocation() {
        int obsCount = obstacle.count();
        System.out.println("\nyou're in the " + getName() + " now!");
        System.out.println("be careful, kiddo! " + obsCount + " " + obstacle.getName() + "(s) in the area!");
        System.out.print("\n<c>ombat or <f>lee: ");
        String selCase = sc.nextLine().toLowerCase();

        if (selCase.equals("c")) {
            if (combat(obsCount)) {
                System.out.println("\nand boom goes the dynamite! " + player.getName() + ", you beat 'em all!");

                if (this.award.equals("food") && !player.getInv().hasFood()) {
                    System.out.println("new item collected: " + this.award);
                    player.getInv().setFood(true);
                }
                if (this.award.equals("water") && !player.getInv().hasWater()) {
                    System.out.println("new item collected: " + this.award);
                    player.getInv().setWater(true);
                }
                if (this.award.equals("firewood") && !player.getInv().hasFirewood()) {
                    System.out.println("new item collected: " + this.award);
                    player.getInv().setFirewood(true);
                }
                return true;
            } else if (player.getHealth() <= 0) {
                System.out.println("\noh snap! your goose is cooked, " + player.getName() + ". see ya on the other side!");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obsCount) {
        int obsFullHealth = obstacle.getHealth();

        for (int i = 0; i < obsCount; i++) {
            playerStats();
            enemyStats();
            while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
                System.out.print("\n<h>it or <r>un: ");
                String warSel = sc.nextLine().toLowerCase();
                if (warSel.equals("h")) {
                    System.out.println("\nwow! good shot!");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();

                    if (obstacle.getHealth() > 0) {
                        System.out.println("\n'...how dare you? you asked for this, loser!' *punch*");
                        player.setHealth(player.getHealth() + player.getInv().getArmor() - obstacle.getDamage());
                        afterHit();
                    }
                } else {
                    break;
                }
            }

            if (player.getHealth() > 0 && obstacle.getHealth() <= 0) {
                System.out.println("\none is gone!");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("\nearned: " + obstacle.getAward());
                System.out.println("current money: " + player.getMoney());
                obstacle.setHealth(obsFullHealth);
            } else {
                return false;
            }
        }
        return true;
    }

    private void enemyStats() {
        System.out.println("\n" + obstacle.getName() + " stats\n-------------");
        System.out.println("health: " + obstacle.getHealth());
        System.out.println("damage: " + obstacle.getDamage());
        System.out.println("award: " + obstacle.getAward());
    }

    private void playerStats() {
        System.out.println("\nplayer stats\n------------");
        System.out.println("health: " + player.getHealth());
        System.out.println("damage: " + player.getTotalDamage());
        System.out.println("money: " + player.getMoney());

        if (player.getInv().getDamage() > 0) {
            System.out.println("weapon: " + player.getInv().getWeaponName());
        }

        if (player.getInv().getArmor() > 0) {
            System.out.println("armor: " + player.getInv().getArmorName());
        }
    }

    private void afterHit() {
        System.out.println("\nyour health: " + player.getHealth() + "\n" + obstacle.getName() + "'s health: " + obstacle.getHealth());
    }
}
