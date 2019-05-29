package contract.model;

import java.util.Observable;

import entity.HelloWorld;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */
	HelloWorld getHelloWorld();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
	void loadHelloWorld(String code);

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	
	/**
     * Gets the ground.
     *
     * @return the ground
     */
	IWalkable getWalkable();
	
	/**
     * Gets the my vehicle.
     *
     * @return the myVehicle
     */
    IMobile getPlayer();
}
