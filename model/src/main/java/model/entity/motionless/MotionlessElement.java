package model.entity.motionless;

import model.entity.Element;
import contract.model.IMotionless;
import contract.model.Permeability;
import contract.model.Sprite;

public abstract class MotionlessElement extends Element implements IMotionless{
	
	
    /**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    MotionlessElement(final Sprite sprite, final Permeability permeability) {
        super(sprite, permeability);
    }
    
    
    @Override
	public void destruction() {
    	
	}

}
