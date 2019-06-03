package model.entity.mobile;

import java.io.IOException;

import contract.model.IMap;
import contract.model.Permeability;
import contract.model.Sprite;

public class Enemy2 extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('P', "Enemy2.jpg");
    

    /**
     * Instantiates a new enemy2.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param map
     *            the map
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Enemy2(final IMap map) {
        super(sprite, map, Permeability.KILLABLE2);
        
    }
}