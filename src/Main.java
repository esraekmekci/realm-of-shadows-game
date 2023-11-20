public class Main {

    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.login();
        } catch (Exception e) {
            System.out.println("\nan error occurred. i didn't see that coming. let's try again.\n");
            Game game = new Game();
            game.login();
        } finally {
            System.out.println("\nthanks for playing! see you next time!\n");
            System.exit(0);
        }

    }

}
