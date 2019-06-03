package model.entity.mobile;

import model.Map;

public abstract class MobileElementsFactory {
	
	private static Map MAP;
	
	//private static final Player          player          = new Player(4, 4, MAP);

    /** The Constant ROCK. */
    private static final Rock                rock                = new Rock(MAP);
    
    private static final Diamond                diamond                = new Diamond(MAP);
    
    private static final Enemy                enemy                = new Enemy(MAP);
    
    private static final Enemy2                enemy2                = new Enemy2(MAP);


    /**
     * The motionless elements is an array of all possible MotionlessElement.
     */
    private static Mobile[]       mobileElements  = {
    //	player,
    	rock,
    	diamond,
    	enemy,
    	enemy2,};
    
    /*public static Mobile createPlayer() {
        return player;
    }*/

    /**
     * Creates a new ground object.
     *
     * @return the motionless element
     */
    public static Mobile createRock() {
        return rock;
    }
    
    public static Mobile createDiamond() {
        return diamond;
    }
    
    public static Mobile createEnemy() {
        return enemy;
    }
    
    public static Mobile createEnemy2() {
        return enemy2;
    }


    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static Mobile getFromFileSymbol(final char fileSymbol) {
        for (final Mobile mobileElement : mobileElements) {
            if (mobileElement.getSprite().getConsoleImage() == fileSymbol) {
                return mobileElement;
            }
        }
        return null;
    }
}