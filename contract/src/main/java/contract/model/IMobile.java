package contract.model;

import java.awt.Point;

import fr.exia.showboard.IPawn;
import contract.model.IElement;

public interface IMobile extends IPawn, IElement {

    /**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Do nothing.
     */
    void doNothing();

    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();

    /**
     * Checks if the car crashed.
     *
     * @return the boolean
     */
    Boolean isBlocked();
    
    Boolean isPushable();
    
    Boolean isDestructible();
    
    Boolean isRemoveable();
    
    Boolean isDead();
    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    @Override
    Point getPosition();
    
    public void blocked();
    void push(int x, int y);
    
    public void setHasMoved();

	void destruction();
	
	void Objective(int objectiveState);
	
	int getScore();
	
	boolean isFinish();

	

	



}
