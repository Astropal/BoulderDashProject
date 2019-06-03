package model.entity.mobile;

import java.io.IOException;

import contract.model.IMap;
import contract.model.Permeability;
import contract.model.Sprite;

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
    private static final Sprite spriteDead   = new Sprite('H', "Dead.jpg");

    /**
     * Instantiates a new player.
     * @param map
     *            the map
     */
    public Player(final IMap map) {
        super(sprite, map, Permeability.BLOCKING);
        
        try {
        	spriteTurnUp.loadImage();
			spriteTurnLeft.loadImage();
			spriteTurnRight.loadImage();
			spriteTurnDown.loadImage();
			spriteDead.loadImage();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
    
    /*
     * (non-Javadoc)
     * @see model.entity.mobile.Mobile#moveUp()
     */
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteTurnUp);
    }
    
    /*
     * (non-Javadoc)
     * @see model.entity.mobile.Mobile#moveDown()
     */
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteTurnDown);
    }
    
    /*
     * (non-Javadoc)
     * @see model.entity.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteTurnLeft);
    }

    /*
     * (non-Javadoc)
     * @see model.entity.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteTurnRight);
    }

    /*
     * (non-Javadoc)
     * @see model.entity.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        super.die();
        this.setSprite(spriteDead);
    }

    /*
     * (non-Javadoc)
     * @see model.entity.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
}