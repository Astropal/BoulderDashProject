package model.entity.mobile;

import contract.model.IMap;
import contract.model.Permeability;
import contract.model.Sprite;

public class Enemy2 extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('P', "Enemy2.jpg");
    

    /**
     * Instantiates a new enemy2.
     * @param map
     *            the map
     */
    public Enemy2(final IMap map) {
        super(sprite, map, Permeability.KILLABLE2);
        
    }
}