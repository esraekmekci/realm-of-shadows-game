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

    public String getName() {
        return name;
    }


}
