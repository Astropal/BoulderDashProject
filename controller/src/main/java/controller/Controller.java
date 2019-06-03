package controller;

import contract.controller.IController;
import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.model.IModel;
import contract.view.IView;

import java.io.IOException;


/**
 * The Class Controller.
 */
public class Controller implements IController, IOrderPerformer {

	/** The Constant speed. */
    private static final int     speed = 100;
	
	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;
	
	/** The stack order. */
    private UserOrder            stackOrder;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}
	
	/**
     * Order perform.
     * @throws InterruptedException the InterruptedException
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public final void play() throws InterruptedException {
		while (this.getModel().getPlayer().isAlive() && this.getModel().getPlayer().isInGame()) {
			//this.getView().show(0); (print the game in the console).
			Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getPlayer().moveRight();
                    getView().UpdateMap();
                    break;
                case LEFT:
                    this.getModel().getPlayer().moveLeft();
                    getView().UpdateMap();
                    break;
                case DOWN:
                	this.getModel().getPlayer().moveDown();
                	getView().UpdateMap();
                    break;    
                case UP:
                	this.getModel().getPlayer().moveUp();
                	getView().UpdateMap();
                    break;
                case NOP:
                default:
                    this.getModel().getPlayer().doNothing();
                    getView().UpdateMap();
                    break;
            }
         
            if (this.getModel().getPlayer().isBlocked()) {
            	this.getModel().getPlayer().blocked();
            }
        
            if (this.getModel().getPlayer().isPushable()) {
            	this.getModel().getPlayer().push(this.getModel().getPlayer().getX(), this.getModel().getPlayer().getY());
            }
        
            if (this.getModel().getPlayer().isFallInjure()) {
            	this.getModel().getPlayer().fallInjure();
            }
        
            if (this.getModel().getPlayer().isRemoveable()) {
            	this.getModel().getPlayer().Objective(this.getModel().getPlayer().getScore() + 1);
            	
        	if(this.getModel().getPlayer().isFinish()) {
        		this.getView().displayMessage("A DOOR HAS OPENED !");
        	}
        	//System.out.println(this.getModel().getPlayer().getScore()); (Print the score in the console).
        }
        
        this.getModel().getMap().gravity();
        this.getModel().getMap().moveEnemy();
		this.clearStackOrder();
		this.getView().followPlayer();
		}
		getView().UpdateMap();
		if(this.getModel().getPlayer().isInGame()) {this.getView().displayMessage("GAME OVER !");}
		if(this.getModel().getPlayer().isAlive()) {this.getView().displayMessage("WIN !");}
	}
	
	
	
	/**
     * Order perform.
     *
     * @param userOrder
     *            the user order
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
	@Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }
	
	
	/**
	 * Get the view.
	 * @return the view
	 */
	private IView getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final IView view) {
        this.view = view;
    }

    
    /**
     * Gets the model.
     *
     * @return the model
     */
    private IModel getModel() {
        return this.model;
    }
    
    
	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}
	
	/**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }
    
    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }
    
    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }


	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}
