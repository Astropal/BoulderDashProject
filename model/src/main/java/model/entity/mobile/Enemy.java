package model.entity.mobile;

import java.io.IOException;

import contract.model.IMap;
import contract.model.Permeability;
import contract.model.Sprite;

public class Enemy extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('E', "BatSide.jpg");
    
    /** The Constant spriteTurnUp. */
    private static final Sprite spriteTurnUp 	= new Sprite('E', "BatUp.jpg");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('E', "BatSide.jpg");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('E', "BatSide.jpg");
    
    /** The Constant spriteTurnDown. */
    private static final Sprite spriteTurnDown 	= new Sprite('E', "BatDown.jpg");

    /** The Constant spriteExplode. */
    private static final Sprite spriteExplode   = new Sprite('E', "BatSide.jpg");
    
    private static Sprite spriteEnemy;

    /**
     * Instantiates a new enemy.
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
    public Enemy(final IMap map) {
        super(spriteSelect(), map, Permeability.KILLABLE);
      
        try {
        	spriteTurnUp.loadImage();
			spriteTurnLeft.loadImage();
			spriteTurnRight.loadImage();
			spriteTurnDown.loadImage();
			spriteExplode.loadImage();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    /**
     * Select a sprite randomly
     * @return the enemy sprite
     */
    public static Sprite spriteSelect() {
    	int Dir = (int)(Math.random() * 2);
    	if(Dir == 0) {spriteEnemy = spriteTurnDown;}
    	if(Dir == 1) {spriteEnemy = sprite;}
		return spriteEnemy;}
}