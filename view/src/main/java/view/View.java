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
import contract.model.IMap;
import contract.view.IView;
import fr.exia.showboard.BoardFrame;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public final class View implements Runnable, KeyListener, IView {
	/** The Constant mapView. */
    private static final int walkView   = 20;

    /** The Constant squareSize. */
    private static final int squareSize = 50;

    /** The Constant closeView. */
    private Rectangle        closeView;

    /** The road. */
    private IMap            map;

    /** Player. */
    private IMobile          player;

    /** The view. */
    private int              view;

    /** The order performer. */
    private IOrderPerformer  orderPerformer;
    
    
    
    //final BoardFrame boardFrame = new BoardFrame("Close view");
    /**
     * Instantiates a new insane vehicles View.
     *
     * @param map
     *            the map
     * @param player
     *            the player
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public View(final IMap map, final IMobile player) throws IOException {
        this.setView(walkView);
        this.setMap(map);
        this.setPlayer(player);
        this.getPlayer().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, 0, 30, walkView));
        SwingUtilities.invokeLater(this);
    }

    /*
     * (non-Javadoc)
     * @see view.View#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    final BoardFrame boardFrame = new BoardFrame("BoulderDash");
    @Override
    public final void run() {
    	boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(false);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);
        

        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getPlayer());

        this.getMap().getObservable().addObserver(boardFrame.getObserver());
        this.followPlayer();
        boardFrame.setVisible(true);
    }

    /**
     * Prints the map and the player's in the console.
     *
     * @param yStart
     *            the y start
     */
    public final void show(final int yStart) {
        int y = yStart % this.getMap().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getMap().getWidth(); x++) {
                if ((x == this.getPlayer().getX()) && (y == yStart)) {
                    System.out.print(this.getPlayer().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % this.getMap().getHeight();
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
     * @see view.View#followMyvehicle()
     */
    @Override
    public final void followPlayer() {
    	int x;
		int y;
		x = (int) this.getPlayer().getX();
		y = (int) this.getPlayer().getY();
		if (x > 8 && x < this.getCloseView().x + 9) {
			this.getCloseView().x--;
		} else if (x > this.getCloseView().x + 14 && x < 32) {
			this.getCloseView().x++;
		}
		//if(x < this.getCloseView().x + 4) {this.getCloseView().x = 4;}
		if (y < this.getCloseView().y + 4) {
			this.getCloseView().y--;
		} else if (y > this.getCloseView().y + 10 && y < 17) {
			this.getCloseView().y++;
		}
        
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    private IMap getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the new map
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void setMap(final IMap map) throws IOException {
        this.map = map;
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
            }
        }
    }

    /**
     * Gets Player.
     *
     * @return Player
     */
    private IMobile getPlayer() {
        return this.player;
    }

    /**
     * Sets Player.
     *
     * @param Player
     *            new Player
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
    
    /**
     * Update the display.
     */
    public void UpdateMap() {
    	for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getPlayer());

        this.getMap().getObservable().addObserver(boardFrame.getObserver());
    }
    
}
