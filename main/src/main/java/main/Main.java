/**
 * @author Bastien Dupont based on work of Jean-Aymeric Diet
 * @version 2.0
 */
package main;

import java.io.IOException;

import controller.Controller;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Bastien Dupont based on work of Jean-Aymeric Diet
 */
public abstract class Main {

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
        final Model model = new Model("road.txt");
        final View view = new View(model.getMap(), model.getPlayer());
        final Controller controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());
        controller.play();
    }
}
