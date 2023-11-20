public class Toolstore extends NormalLoc {

    public Toolstore(Player player) {
        super(player, "toolstore");
    }

    public boolean getLocation() {
        System.out.println("\nwallet: " + player.getMoney());
        System.out.println("\n1- weapons");
        System.out.println("2- armors");
        System.out.println("3- exit\n");
        System.out.print("choice (1-3): ");
        int choice = getUserInput();

        while (choice < 1 || choice > 3) {
            System.out.print("\nplease make a valid choice: ");
            choice = getUserInput();
        }

        int itemID;

        switch (choice) {
            case 1 -> {
                itemID = weaponMenu();
                if (itemID > 0 && itemID < 4) {
                    buyWeapon(itemID);
                } else {
                    System.out.println("\ngoodbye!");
                }
            }
            case 2 -> {
                itemID = armorMenu();
                if (itemID > 0 && itemID < 4) {
                    buyArmor(itemID);
                } else {
                    System.out.println("\ngoodbye!");
                }
            }
            case 3 -> System.out.println("\ngoodbye!");
            default -> throw new IllegalArgumentException("\nunvalid value!");
        }
        return true;
    }

    private int armorMenu() {
        System.out.println("\n1- light armor\t (price: 15 \t damage: 1)");
        System.out.println("2- medium armor\t (price: 25 \t damage: 3)");
        System.out.println("3- heavy armor\t (price: 40 \t damage: 5)");
        System.out.println("4- exit\n");
        System.out.print("choice (1-4): ");
        int choice = getUserInput();

        while (choice < 1 || choice > 4) {
            System.out.print("\nplease make a valid choice: ");
            choice = getUserInput();
        }
        return choice;
    }

    private int weaponMenu() {
        System.out.println("\n1- pistol \t (price: 25 \t damage: 2)");
        System.out.println("2- sword \t (price: 35 \t damage: 3)");
        System.out.println("3- rifle \t (price: 45 \t damage: 7)");
        System.out.println("4- exit\n");
        System.out.print("choice (1-4): ");
        int choice = getUserInput();

        while (choice < 1 || choice > 4) {
            System.out.print("\nplease make a valid choice: ");
            choice = getUserInput();
        }
        return choice;
    }

    private void buyArmor(int selItemID) {
        int avoid, price;
        String armorName;
        switch (selItemID) {
            case 1 -> {
                price = 15;
                avoid = 1;
                armorName = "light armor";
            }
            case 2 -> {
                price = 25;
                avoid = 3;
                armorName = "medium armor";
            }
            case 3 -> {
                price = 50;
                avoid = 5;
                armorName = "heavy armor";
            }
            default -> throw new IllegalArgumentException("\nunvalid value!");
        }

        if (price <= player.getMoney()) {
            player.getInv().setArmor(avoid);
            player.getInv().setArmorName(armorName);
            player.setMoney(player.getMoney() - price);
            System.out.println("\nyou bought a " + armorName + "! kill enemies, die later!");
            System.out.println("blocked damage: " + player.getInv().getArmor());
            System.out.println("remaining money: " + player.getMoney());
        } else {
            System.out.println("\ninsufficient money :(\n");
        }
    }

    private void buyWeapon(int selItemID) {
        int damage, price;
        String weaponName;
        switch (selItemID) {
            case 1 -> {
                price = 25;
                damage = 2;
                weaponName = "pistol";
            }
            case 2 -> {
                price = 35;
                damage = 3;
                weaponName = "sword";
            }
            case 3 -> {
                price = 45;
                damage = 7;
                weaponName = "rifle";
            }
            default -> throw new IllegalArgumentException("\nunvalid value!");
        }

        if (price <= player.getMoney()) {
            player.getInv().setDamage(damage);
            player.getInv().setWeaponName(weaponName);
            player.setMoney(player.getMoney() - price);
            System.out.println("\nyou bought a " + weaponName + "! use for bloody days!");
            System.out.println("current damage: " + player.getTotalDamage());
            System.out.println("remaining money: " + player.getMoney());
        } else {
            System.out.println("\ninsufficient money :(\n");
        }
    }

    private int getUserInput() {
        while (true) {
            try {
                String input = sc.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("\nplease enter a valid number: ");
            }
        }
    }
}
