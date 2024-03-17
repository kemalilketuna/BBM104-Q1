import java.util.*;

/**
 * Manages the game flow, including player turns and score tracking in a dice game.
 * Utilizes RoundManager to handle the progression of rounds and player turns.
 */
public class GameManager {
    private RoundManager roundManager;
    private List<String> players;
    private int playerCount;
    private List<Integer> scores;

    /**
     * Constructs a GameManager with the specified list of players.
     * Initializes playerCount, roundManager, and scores based on the players.
     *
     * @param players A list of player names participating in the game.
     */
    public GameManager(List<String> players) {
        this.players = players;
        this.playerCount = players.size();
        this.roundManager = new RoundManager(playerCount);
        this.scores = new ArrayList<Integer>(Collections.nCopies(playerCount, 0));
    }

    /**
     * Processes a single turn of the game using the rolled dice values.
     * Updates the game state, including player scores and active status, based on the dice outcome.
     *
     * @param dice1 The value of the first dice rolled.
     * @param dice2 The value of the second dice rolled.
     */
    public void playTurn(int dice1, int dice2){
        String playerName = players.get(roundManager.currentIndex());
        int playerIndex = roundManager.currentIndex();
        int playerScore = scores.get(playerIndex);

        if (dice1 + dice2 == 2) {
            String message = String.format(Messages.LOSE_GAME.getTemplate(), playerName, dice1, dice2, playerName);
            System.out.println(message);
            roundManager.setInactiveCurrentIndex();
        } else if (dice1 + dice2 == 0) {
            String message = String.format(Messages.SKIP_TURN.getTemplate(), playerName, playerName, playerScore);
            System.out.println(message);
        } else {
            int increase = dice1 + dice2;
            if (dice1 == 1 || dice2 == 1) {
                increase = 0;
            }
            scores.set(roundManager.currentIndex(), playerScore + increase);
            String message = String.format(Messages.GAIN_POINTS.getTemplate(), playerName, dice1, dice2, playerName, playerScore + increase);
            System.out.println(message);
        }

        roundManager.nextPlayer();

        if (roundManager.isGameOver()) {
            int winnerIndex = roundManager.currentIndex();
            String winnerName = players.get(winnerIndex);
            int winnerScore = scores.get(winnerIndex);
            String message = String.format(Messages.GAME_WIN.getTemplate(), winnerName, winnerScore, winnerName);
            System.out.print(message);
        }
    }
}
