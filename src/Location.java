import java.util.Scanner;

public abstract class Location {
    protected Player player;
    protected String name;
    Scanner sc = new Scanner(System.in);

    public Location(Player player) {
        this.player = player;
    }

    public boolean getLocation() {
        return false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
