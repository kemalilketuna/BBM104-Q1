/**
 * Defines message templates for various game events, each associated with specific game situations.
 */
public enum Messages {
    GAIN_POINTS("%s threw %d-%d and %s’s score is %d."), // Message when a player gains points.
    LOSE_GAME("%s threw %d-%d. Game over %s!"), // Message when a player loses the game.
    GAME_WIN("%s is the winner of the game with the score of %d. Congratulations %s!"), // Message when a player wins the game.
    SKIP_TURN("%s skipped the turn and %s’s score is %d."); // Message when a player skips a turn.

    private String template; // The template for the message.

    /**
     * Constructs a Messages enum with the specified message template.
     *
     * @param template The string template for the message.
     */
    Messages(String template) {
        this.template = template;
    }

    /**
     * Retrieves the template associated with the message.
     *
     * @return The message template.
     */
    public String getTemplate() {
        return template;
    }
}
