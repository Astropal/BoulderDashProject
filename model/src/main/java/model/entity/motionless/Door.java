package model.entity.motionless;

import java.io.IOException;

import contract.model.Permeability;
import contract.model.Sprite;

public class Door extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('X', "Door.jpg");

    /**
     * Instantiates a new Door.
     */
   public Door() {
        super(SPRITE, Permeability.FINISHABLE);
        
        try {
        	SPRITE.loadImage();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
