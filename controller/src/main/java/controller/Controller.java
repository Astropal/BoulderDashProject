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
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public final void play() throws InterruptedException {
		while (this.getModel().getPlayer().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getPlayer().moveRight();
                    break;
                case LEFT:
                    this.getModel().getPlayer().moveLeft();
                    break;
                case DOWN:
                	this.getModel().getPlayer().moveDown();
                    break;    
                case UP:
                	this.getModel().getPlayer().moveUp();
                    break;
                case NOP:
                default:
                    this.getModel().getPlayer().doNothing();
                    break;
            }
            
        if (this.getModel().getPlayer().isBlocked()) {
            this.getModel().getPlayer().blocked();
        }
		this.clearStackOrder();
		this.getView().followPlayer();
		}
		this.getView().displayMessage("GAME OVER !");
	}
	
	@Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }
	
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

    /**
     * Control.
     */
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
