package contract.model;

import java.awt.Point;

import fr.exia.showboard.ISquare;

public interface IElement extends ISquare {

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /**
     * Gets the y.
     *
     * @return the Y
     */
	int getY();

	/**
     * Gets the x.
     *
     * @return the x
     */
	int getX();
	
	/*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
	Point getPosition();
	
	/**
     * Set the y.
     * @param y the y
     */
	public void setY(final int y);
	
	/**
     * Set the x.
     * @param x the x
     */
	public void setX(final int x);
	


}
