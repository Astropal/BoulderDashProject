package model.entity.motionless;

import contract.model.Permeability;
import contract.model.Sprite;


public class DustWall extends MotionlessElement {
	
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('^', "DustWall.jpg");
    

    /**
     * @param iMap 
     * Instantiates a new tree.
     * @throws  
     */
    public DustWall() {
        super(SPRITE, Permeability.DESTRUCTIBLE);
        
    }

}
