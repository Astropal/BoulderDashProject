package model.entity.mobile;


import contract.model.IMap;
import contract.model.Permeability;
import contract.model.Sprite;

public class Diamond extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('D', "Diamond.jpg");

    /**
     * Instantiates a new obstacle.
     */
    public Diamond(final IMap map) {
        super(SPRITE, map, Permeability.REMOVEABLE);
        
    }
    
}
