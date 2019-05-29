package model.entity.mobile;

import java.awt.Point;

import contract.model.IMobile;
import contract.model.IWalkable;
import model.entity.Element;
import contract.model.Permeability;
import contract.model.Sprite;
import fr.exia.showboard.IBoard;

abstract class Mobile extends Element implements IMobile {

    /**
     * The x.
     */
    private Point   position;

    /** The alive. */
    private Boolean alive = true;

    /** The road. */
    private IWalkable   walkable;

    /** The board. */
    private IBoard  board;

    /**
     * Instantiates a new mobile.
     *
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final Sprite sprite, final IWalkable walkable, final Permeability permeability) {
        super(sprite, permeability);
        this.setWalkable(walkable);
        this.position = new Point();
    }

    /**
     * Instantiates a new mobile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final int x, final int y, final Sprite sprite, final IWalkable walkable, final Permeability permeability) {
        this(sprite, walkable, permeability);
        this.setX(x);
        this.setY(y);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveUp()
     */
    @Override
    public void moveUp() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveLeft()
     */
    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveDown()
     */
    @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveRight()
     */
    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#doNothing()
     */
    @Override
    public void doNothing() {
        this.setHasMoved();
    }

    /**
     * Sets the has moved.
     */
    private void setHasMoved() {
        this.getWalkable().setMobileHasChanged();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getX()
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) {
        this.getPosition().x = x;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getY()
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the road is an infinite loop, there's a modulo
     *            based on the road height.
     */
    public final void setY(final int y) {
        this.getPosition().y = (y + this.getWalkable().getHeight()) % this.getWalkable().getHeight();
        
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    public IWalkable getWalkable() {
        return this.walkable;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
    private void setWalkable(final IWalkable walkable) {
        this.walkable = walkable;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isAlive()
     */
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Dies.
     */
    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }
    
    public void blocked() {
    	if(this.getX() == 0) {
    		this.setX(this.getX() + 1);}
    	else if (this.getX() == 19) {
    		this.setX(this.getX() - 1);}
    	
    	if(this.getY() == 0) {
    		this.setY(this.getY() + 1);}
    	else if (this.getY() == 15) {
    		this.setY(this.getY() - 1);}
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isBlocked()
     */
    @Override
    public Boolean isBlocked() {
        return this.getWalkable().getOnTheWalkXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
    
    @Override
    public Boolean isPushable() {
        return this.getWalkable().getOnTheWalkXY(this.getX(), this.getY()).getPermeability() == Permeability.PUSHABLE;
    }
    
    @Override
    public Boolean isDestructible(){
		return this.getWalkable().getOnTheWalkXY(this.getX(), this.getY()).getPermeability() == Permeability.DESTRUCTIBLE;
    	
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getPosition()
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }

}
