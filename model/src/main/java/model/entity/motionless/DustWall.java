package model.entity.motionless;

import contract.model.Permeability;
import contract.model.Sprite;

import java.io.IOException;


public class DustWall extends MotionlessElement {
	
    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('^', "DustWall.jpg");
    
    private static final Sprite spriteground	= new Sprite(' ', "Ground.jpg");
    

    /**
     * @param iMap 
     * Instantiates a new tree.
     * @throws  
     */
    public DustWall() {
        super(SPRITE, Permeability.DESTRUCTIBLE);
        
        try {
			spriteground.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    @Override
    public final void destruction(){
    	super.destruction();
    	//this.setSprite(spriteground);
    	System.out.println("Ok");
    }

}
