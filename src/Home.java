public class Home extends NormalLoc {

    public Home(Player player) {
        super(player, "home");
    }

    public boolean getLocation() {
        player.setHealth(player.getMaxHealth());
        System.out.println("\nwell, well, well... you're home now.");
        System.out.println("fully healed! current health: " + player.getHealth());
        return true;
    }

}
