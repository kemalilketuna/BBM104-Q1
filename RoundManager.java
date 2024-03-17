import java.util.*;

/**
 * Manages the rounds and player status in a game, tracking active and inactive players.
 */
public class RoundManager {
    private int activePlayerNumber; // The number of active players in the game.
    private int playerCount; // The total number of players in the game.
    private int currentIndex; // The index of the current player.
    private List<Boolean> playersStatus; // The status (active/inactive) of each player.

    /**
     * Initializes the RoundManager with the specified number of active players.
     * All players are initially set to active.
     *
     * @param activePlayerNumber The number of active players at the start of the game.
     */
    public RoundManager(int activePlayerNumber) {
        this.activePlayerNumber = activePlayerNumber;
        this.playerCount = activePlayerNumber;
        this.currentIndex = 0;
        this.playersStatus = new ArrayList<Boolean>(Collections.nCopies(activePlayerNumber, true));
    }

    /**
     * Sets the current player's status to inactive and decreases the count of active players.
     */
    public void setInactiveCurrentIndex() {
        playersStatus.set(currentIndex, false);
        activePlayerNumber--;
    }

    /**
     * Advances to the next player. Skips over any players that are inactive.
     */
    public void nextPlayer() {
        if (activePlayerNumber == 0) {
            return;
        }

        currentIndex++;
        currentIndex %= playerCount; // Ensure the index wraps around.

        // Recursively skip inactive players.
        if (!playersStatus.get(currentIndex)) {
            nextPlayer();
        }
    }

    /**
     * Checks if the game is over, which occurs when only one player remains active.
     *
     * @return True if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return activePlayerNumber <= 1;
    }

    /**
     * Retrieves the index of the current player.
     *
     * @return The current player's index.
     */
    public int currentIndex() {
        return currentIndex;
    }
}
