package contract.model;

import java.awt.Image;
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

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
    @Override
    Image getImage();

	int getY();

	int getX();
	
	Point getPosition();
	
	public void setY(final int y);
	
	public void setX(final int x);
	
	public void setSprite(final Sprite sprite);


}
