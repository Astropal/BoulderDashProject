package model.entity.mobile;


import contract.model.IMobile;

import contract.model.IElement;
import contract.model.IMap;
import model.entity.Element;
import contract.model.Permeability;
import contract.model.Sprite;
import fr.exia.showboard.IBoard;
import model.entity.motionless.MotionlessElementsFactory;

abstract class Mobile extends Element implements IMobile {
	
    /** The alive. */
    private Boolean alive = true;

    /** The road. */
    private IMap   map;

    /** The board. */
    private IBoard  board;
    
    private int Dir;
    
    int objective = 4;
    
    int objectiveState = 0;
    
    boolean finish = false;
    

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
    Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
        super(sprite, permeability);
        this.setMap(map);
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
    Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
        this(sprite, map, permeability);
        this.setX(x);
        this.setY(y);
        this.setMap(map);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveUp()
     */
    @Override
    public void moveUp() {
    	fillEmptySpace(this.getX(), this.getY());
        this.setY(this.getY() - 1);
        Dir = 1;
        this.setMap(getMap());
        this.setHasMoved();
    }
    
    @Override
    public void destruction() {
    	fillEmptySpace(this.getX(), this.getY());
    	this.setHasMoved();
	}

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveLeft()
     */
    @Override
    public void moveLeft() {
    	fillEmptySpace(this.getX(), this.getY());
        this.setX(this.getX() - 1);
        Dir = 4;
        this.setMap(getMap());
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveDown()
     */
    @Override
    public void moveDown() {
    	fillEmptySpace(this.getX(), this.getY());
        this.setY(this.getY() + 1);
        Dir = 2;
        this.setMap(getMap());
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveRight()
     */
    @Override
    public void moveRight() {
    	fillEmptySpace(this.getX(), this.getY());
        this.setX(this.getX() + 1);
        Dir = 3;
        this.setMap(getMap());
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#doNothing()
     */
    @Override
    public void doNothing() {
    	Dir = 0;
        this.setHasMoved();
    }

    /**
     * Sets the has moved.
     */
    public void setHasMoved() {
        this.getMap().setMapHasChanged();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getX()
     */


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
    	else if (this.getX() == 40) {
    		this.setX(this.getX() - 1);}
    	
    	if(this.getY() == 0) {
    		this.setY(this.getY() + 1);}
    	else if (this.getY() == 10) {
    		this.setY(this.getY() - 1);}
        this.setHasMoved();
    }
    
    public void fillEmptySpace(int x, int y) {
		IElement bg = MotionlessElementsFactory.createGround();
		bg.setX(x);
		bg.setY(y);
		this.getMap().setOnTheMapXY(bg, x, y);
	}
    
    public void push(int x, int y) {
    	IElement bg = MobileElementsFactory.createRock();
    	bg.setX(x);
		bg.setY(y);
		
		if(Dir == 3 && this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
		this.getMap().setOnTheMapXY(bg, this.getX() + 1, this.getY());
		}else if(Dir == 3){this.setX(this.getX() - 1); this.getMap().setOnTheMapXY(bg, this.getX() + 1, this.getY());}
		
		if(Dir == 4 && this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE){
		this.getMap().setOnTheMapXY(bg, this.getX() - 1, this.getY());
		}else if(Dir == 4){this.setX(this.getX() + 1); this.getMap().setOnTheMapXY(bg, this.getX() - 1, this.getY());}
		
		if(Dir == 1 && this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE) {
		this.getMap().setOnTheMapXY(bg, this.getX(), this.getY() - 1);
		}else if(Dir == 1){this.setY(this.getY() + 1); this.getMap().setOnTheMapXY(bg, this.getX(), this.getY() - 1);}
		
		if (Dir == 2 && this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE){
		this.getMap().setOnTheMapXY(bg, this.getX(), this.getY() + 1);
		}else if(Dir == 2){this.setY(this.getY() - 1); this.getMap().setOnTheMapXY(bg, this.getX(), this.getY() + 1);}
		
		this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isBlocked()
     */
    @Override
    public Boolean isBlocked() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
    
    @Override
    public Boolean isPushable() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.PUSHABLE;
    }
    
    @Override
    public Boolean isDestructible(){
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.DESTRUCTIBLE;
    	
    }
    
    @Override
    public Boolean isRemoveable(){
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.REMOVEABLE;
    	
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    public IMap getMap() {
        return this.map;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
    private void setMap(final IMap map) {
        this.map = map;
    }
   

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }
    
    public void Objective(int objectiveState){
        this.objectiveState = objectiveState;
        this.getMap().setOnTheMapXY(MotionlessElementsFactory.createGround(), this.getX(), this.getY());
        	if(objectiveState == objective) {
        		finish = true;
        	}
        }
        
        public int getScore() {
    		return objectiveState;
    	}
        
        public boolean isFinish() {
        	return finish;
        }

}
