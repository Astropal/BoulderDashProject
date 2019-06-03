package contract.controller;

/**
 * The Interface IController.
 *
 * @author Bastien Dupont based on work of Jean-Aymeric Diet
 */
public interface IController {
	
	/**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
    void play() throws InterruptedException;
	
	/**
	 * Get Order Peformer.
	 * @return OrderPeformer
	 */
	IOrderPerformer getOrderPeformer();
	

}
