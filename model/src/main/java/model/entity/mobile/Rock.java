package model.entity.mobile;


import contract.model.IMap;
import contract.model.Permeability;
import contract.model.Sprite;

public class Rock extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('N', "Rock.jpg");

    /**
     * Instantiates a new obstacle.
     */
    public Rock(final IMap map) {
        super(SPRITE, map, Permeability.PUSHABLE);
        
    }
    
}
