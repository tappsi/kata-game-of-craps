package gameofcraps;

public class PlayCraps {

    private static CrapsGame game;

    public static void main(String[] args) {

        int numberOfGames;
        printGreeting();

        if(PlayCraps.game == null) {
            PlayCraps.game = new CrapsGame();
        }

        numberOfGames = tryParseStringToInteger(args[0]);

        GameStatistics gameStatistics = play(numberOfGames);

        printGameStatistics(gameStatistics);

        resetGame();
    }

    public static void configureCrapsGame(CrapsGame game) {
        PlayCraps.game = game;
    }

    public static void resetGame() {
        PlayCraps.game = null;
    }

    public static GameStatistics play(int numberOfGames) {

        if (numberOfGames < 1) {
            throw new IllegalArgumentException("numberOfGames must be at least one");
        }

        CrapsGame game = PlayCraps.game;

        int wins = 0;
        int losses = 0;
        int longestPlayedGame = 0;
        int rollsMade = 0;
        int winsComingOutRoll = 0;
        int lossesInComingOutRoll = 0;

        for (int i = 1; i <= numberOfGames; i++) {
            game.play();
            if (game.win()) {
                wins++;
            } else {
                losses++;
            }
            if (game.numberOfRolls() > longestPlayedGame) {
                longestPlayedGame = game.numberOfRolls();
            }
            rollsMade += game.numberOfRolls();


            if (game.numberOfRolls() == 1 && game.win()) {
                winsComingOutRoll++;
            }
            if (game.numberOfRolls() == 1 && !game.win()) {
                lossesInComingOutRoll++;
            }
        }

        return new GameStatistics(wins, losses, longestPlayedGame, rollsMade, winsComingOutRoll, lossesInComingOutRoll);
    }

    public static Integer tryParseStringToInteger (String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            throw new IllegalArgumentException("Argument is not an integer");
        }
    }

    public static void printGreeting() {
        System.out.println("Welcome to Craps!");
        System.out.println("Enter number of games: ");
    }

    public static void printGameStatistics(GameStatistics gameStatistics){
        System.out.println("Played games: " + gameStatistics.playedGames());
        System.out.println("Winning probability games: " + gameStatistics.winningProbability());
        System.out.println("Rolls per game: " + gameStatistics.rollsPerGame());
        System.out.println("Longest played game: " + gameStatistics.longestPlayedGame());
        System.out.println("Winning probability in coming roll out: " +
                gameStatistics.winningProbabilityInComingOutRoll());

        System.out.println("Lose probability in coming roll out: " + gameStatistics.lossesProbabilityInComingOutRoll());
    }

}