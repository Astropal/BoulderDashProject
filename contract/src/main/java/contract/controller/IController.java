package contract.controller;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {
	
	/**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
    void play() throws InterruptedException;
	
	IOrderPerformer getOrderPeformer();
	

}
