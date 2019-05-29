package model.entity.mobile;

import java.io.IOException;

import contract.model.IWalkable;
import contract.model.Permeability;
import contract.model.Sprite;

public class Player extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', "Idle.png");
    
    /** The Constant spriteTurnUp. */
    private static final Sprite spriteTurnUp 	= new Sprite('H', "Up.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('H', "Left.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', "Right.png");
    
    /** The Constant spriteTurnDown. */
    private static final Sprite spriteTurnDown 	= new Sprite('H', "Down.png");

    /** The Constant spriteExplode. */
    private static final Sprite spriteExplode   = new Sprite('H', "Idle.png");

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
    public Player(final int x, final int y, final IWalkable walkable) throws IOException {
        super(x, y, sprite, walkable, Permeability.BLOCKING);
        spriteTurnUp.loadImage();
        spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteTurnDown.loadImage();
        spriteExplode.loadImage();
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