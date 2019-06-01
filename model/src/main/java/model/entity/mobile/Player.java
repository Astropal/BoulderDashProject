package model.entity.mobile;

import java.io.IOException;

import contract.model.IMap;
import contract.model.Permeability;
import contract.model.Sprite;
import model.entity.motionless.MotionlessElementsFactory;;

public class Player extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', "Idle.jpg");
    
    /** The Constant spriteTurnUp. */
    private static final Sprite spriteTurnUp 	= new Sprite('H', "Up.jpg");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('H', "Left.jpg");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', "Right.jpg");
    
    /** The Constant spriteTurnDown. */
    private static final Sprite spriteTurnDown 	= new Sprite('H', "Down.jpg");

    /** The Constant spriteExplode. */
    private static final Sprite spriteExplode   = new Sprite('H', "Idle.jpg");

    /**
     * Instantiates a new my vehicle.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param road
     *            the road
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Player(final int x, final int y, final IMap map) {
        super(sprite, map, Permeability.BLOCKING);
        
        try {
        	spriteTurnUp.loadImage();
			spriteTurnLeft.loadImage();
			spriteTurnRight.loadImage();
			spriteTurnDown.loadImage();
			spriteExplode.loadImage();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteTurnUp);
    }
    
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteTurnDown);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteTurnLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteTurnRight);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        super.die();
        this.setSprite(spriteExplode);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
}