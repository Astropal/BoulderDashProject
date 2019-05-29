package contract.view;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
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
     * Follow myVehicle.
     */
    void followPlayer();

}
