/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;

import controller.Controller;
import model.Model;
import view.View;
import contract.controller.IController;
import contract.model.IModel;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {
	
	/** The Constant startX. */
    private static final int startX = 5;

    /** The Constant startY. */
    private static final int startY = 1;

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) throws IOException, InterruptedException{
        /*final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);
        */
        final IModel model = new Model("road.txt", startX, startY);
        final View view = new View(model.getWalkable(), model.getPlayer());
        final IController controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    }
}
