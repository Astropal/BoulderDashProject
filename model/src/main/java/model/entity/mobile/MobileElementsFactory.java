package model.entity.mobile;

import model.Map;

public abstract class MobileElementsFactory {
	
	private static Map MAP;

    /** The Constant ROCK. */
    private static final Rock                rock                = new Rock(MAP);
    /** The Constant DIAMOND. */
    private static final Diamond                diamond                = new Diamond(MAP);
    /** The Constant ENEMY. */
    private static final Enemy                enemy                = new Enemy(MAP);
    /** The Constant ENEMY2. */
    private static final Enemy2                enemy2                = new Enemy2(MAP);


    /**
     * The motionless elements is an array of all possible MotionlessElement.
     */
    private static Mobile[]       mobileElements  = {
    	rock,
    	diamond,
    	enemy,
    	enemy2,};
    
    /**
     * Creates a new ground object.
     *
     * @return the motionless element
     */
    public static Mobile createRock() {
        return rock;
    }
    /**
     * Creates a new ground object.
     *
     * @return the motionless element
     */
    public static Mobile createDiamond() {
        return diamond;
    }
    /**
     * Creates a new ground object.
     *
     * @return the motionless element
     */
    public static Mobile createEnemy() {
        return enemy;
    }
    /**
     * Creates a new ground object.
     *
     * @return the motionless element
     */
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