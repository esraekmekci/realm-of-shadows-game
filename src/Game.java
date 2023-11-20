import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner sc = new Scanner(System.in);

    public void login() {
        System.out.println("welcome to the adventure game!");
        System.out.print("\nwarrior's name: ");
        String playerName = sc.nextLine();
        Player player = new Player(playerName);
        this.player = player;
        player.selectChr();
        System.out.println("\nlet the game begin...\n");
        start();
    }

    public void start() {
        while (true) {

            if (player.getInv().hasFirewood() && player.getInv().hasFood() && player.getInv().hasWater()) {
                System.out.println("\n******************** THERE'S NOTHING YOU CANNOT DO, SOLDIER! o7 ********************\n");
                break;
            }

            System.out.println("\n****************************************************************************************************\n");
            System.out.println("where will you go, " + player.getName() + "?\n");
            System.out.println("1- home ---> a safe place that is entirely yours, no obstacles! hip, hip, hurrah!");
            System.out.println("2- cave ---> caution! zombies ahead!");
            System.out.println("3- forest ---> oops... vampire zone!");
            System.out.println("4- river ---> did someone say werewolf? oh no...");
            System.out.println("5- toolstore ---> let's get a little stronger!");

			int selectLoc = 0;

			while (selectLoc < 1 || selectLoc > 5) {
				try {
					System.out.print("\nhey there! pick a number between 1 and 5, okay?: ");
					String input = sc.nextLine();
					selectLoc = Integer.parseInt(input);

					if (selectLoc < 1 || selectLoc > 5) {
						System.out.println("\noops, that's not right! i said between 1 and 5.");
					}
				} catch (NumberFormatException e) {
					System.out.println("\noopsie! seems like that's not a number. how about picking a valid number?");
				}
			}

            switch (selectLoc) {
                case 1 -> location = new Home(player);
                case 2 -> location = new Cave(player);
                case 3 -> location = new Forest(player);
                case 4 -> location = new River(player);
                case 5 -> location = new Toolstore(player);
                default -> location = new Home(player);
            }

            if (!location.getLocation()) {
                System.out.println("\n******************************GAME OVER*****************************************");
                break;
            }

        }
    }
}
