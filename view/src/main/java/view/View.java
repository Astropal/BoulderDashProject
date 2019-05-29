package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.model.IMobile;
import contract.model.IWalkable;
import contract.view.IView;
import fr.exia.showboard.BoardFrame;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements Runnable, KeyListener, IView {
	/** The Constant roadView. */
    private static final int walkView   = 14;

    /** The Constant squareSize. */
    private static final int squareSize = 50;

    /** The Constant closeView. */
    private Rectangle        closeView;

    /** The road. */
    private IWalkable            walkable;

    /** My vehicle. */
    private IMobile          player;

    /** The view. */
    private int              view;

    /** The order performer. */
    private IOrderPerformer  orderPerformer;

    /**
     * Instantiates a new insane vehicles View.
     *
     * @param road
     *            the road
     * @param myVehicle
     *            the my vehicle
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public View(final IWalkable walkable, final IMobile player) throws IOException {
        this.setView(walkView);
        this.setWalkable(walkable);
        this.setPlayer(player);
        this.getPlayer().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, this.getPlayer().getY(), this.getWalkable().getWidth(), walkView));
        SwingUtilities.invokeLater(this);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public final void run() {
        final BoardFrame boardFrame = new BoardFrame("Close view");
        boardFrame.setDimension(new Dimension(this.getWalkable().getWidth(), this.getWalkable().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(false);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getWalkable().getWidth(); x++) {
            for (int y = 0; y < this.getWalkable().getHeight(); y++) {
                boardFrame.addSquare(this.walkable.getOnTheWalkXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getPlayer());

        this.getWalkable().getObservable().addObserver(boardFrame.getObserver());
        this.followPlayer();

        boardFrame.setVisible(true);
    }

    /**
     * Prints the road and the player's vehicle in the console.
     *
     * @param yStart
     *            the y start
     */
    public final void show(final int yStart) {
        int y = yStart % this.getWalkable().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getWalkable().getWidth(); x++) {
                if ((x == this.getPlayer().getX()) && (y == yStart)) {
                    System.out.print(this.getPlayer().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getWalkable().getOnTheWalkXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % this.getWalkable().getHeight();
            System.out.print("\n");
        }
    }

    /**
     * Key code to user order.
     *
     * @param keyCode
     *            the key code
     * @return the user order
     */
    private static UserOrder keyCodeToUserOrder(final int keyCode) {
    	UserOrder userOrder;
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
                userOrder = UserOrder.LEFT;
                break;
            case KeyEvent.VK_DOWN:
                userOrder = UserOrder.DOWN;
                break;
            case KeyEvent.VK_UP:
                userOrder = UserOrder.UP;
                break;
            default:
                userOrder = UserOrder.NOP;
                break;
        }
        return userOrder;
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
        	this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#followMyvehicle()
     */
    @Override
    public final void followPlayer() {
        this.getCloseView().y = this.getPlayer().getY() - 7;
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    private IWalkable getWalkable() {
        return this.walkable;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void setWalkable(final IWalkable walkable) throws IOException {
        this.walkable = walkable;
        for (int x = 0; x < this.getWalkable().getWidth(); x++) {
            for (int y = 0; y < this.getWalkable().getHeight(); y++) {
                this.getWalkable().getOnTheWalkXY(x, y).getSprite().loadImage();
            }
        }
    }

    /**
     * Gets my vehicle.
     *
     * @return my vehicle
     */
    private IMobile getPlayer() {
        return this.player;
    }

    /**
     * Sets my vehicle.
     *
     * @param myVehicle
     *            my new vehicle
     */
    private void setPlayer(final IMobile player) {
        this.player = player;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private int getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
    private void setView(final int view) {
        this.view = view;
    }

    /**
     * Gets the close view.
     *
     * @return the close view
     */
    private Rectangle getCloseView() {
        return this.closeView;
    }

    /**
     * Sets the close view.
     *
     * @param closeView
     *            the new close view
     */
    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
    }

    /**
     * Gets the order performer.
     *
     * @return the order performer
     */
    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }

    /**
     * Sets the order performer.
     *
     * @param orderPerformer
     *            the new order performer
     */
    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
}
