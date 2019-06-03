package contract.view;


/**
 * The Interface IView.
 *
 * @author Bastien Dupont based on work of Jean-Aymeric Diet
 */
public interface IView {

	/**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);

    /**
     * Follow player.
     */
    void followPlayer();
    
    /**
     * Print the game in the console (for dev).
     * @param yStart the yStart
     */
    void show(final int yStart);
        
    /**
     * Update the display.
     */
    void UpdateMap();
    
    
}
