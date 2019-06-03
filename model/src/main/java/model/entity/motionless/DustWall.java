package model.entity.motionless;

import contract.model.Permeability;
import contract.model.Sprite;


public class DustWall extends MotionlessElement {
	
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('^', "DustWall.jpg");
    

    /**
     * Instantiates a new DustWall. 
     */
    public DustWall() {
        super(SPRITE, Permeability.DESTRUCTIBLE);
        
    }

}
