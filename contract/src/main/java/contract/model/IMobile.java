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
     * Checks if the player is blocked.
     *
     * @return the boolean
     */
    Boolean isBlocked();
    
    /**
     * Checks if rocks is pushable.
     *
     * @return the boolean
     */
    Boolean isPushable();
    
    /**
     * Checks if DustWalls is destructible.
     *
     * @return the boolean
     */
    Boolean isDestructible();
    
    /**
     * Checks if Diamonds is removable.
     *
     * @return the boolean
     */
    Boolean isRemoveable();
    
    /**
     * Checks if the Player is dead.
     *
     * @return the boolean
     */
    Boolean isDead();
    
    /**
     * Checks if the player has left through the door.
     *
     * @return the boolean
     */
    Boolean isOut();
    
    /**
     * Check if the player had any damage from physics.
     *
     * @return the boolean
     */
    Boolean isFallInjure();
    
    /**
     * Check if the game is finish.
     *
     * @return the boolean
     */
    boolean isFinish();
    
    /**
     * Check if the player is in game.
     *
     * @return the boolean
     */
    boolean isInGame();
    
    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    @Override
    Point getPosition();
    
    /**
     * Prevents the player from passing through the blockers.
     */
    public void blocked();
    
    /**
     * Push rocks.
     *
     * @param x
     * @param y
     */
    void push(int x, int y);
    
    /**
     * Notify the observer.
     */
    public void setHasMoved();
	
    /**
     * The score.
     *
	 * @param objectiveState
	 */
	void Objective(int objectiveState);
	
	/**
     * Get the score.
     */
	int getScore();
	
	/**
     * Kills the player when he suffers physical damage.
     */
	void fallInjure();

}
