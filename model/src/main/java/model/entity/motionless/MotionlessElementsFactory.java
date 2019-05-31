package model.entity.motionless;


public abstract class MotionlessElementsFactory {
	
	private static final Wall          wall          = new Wall();

    /** The Constant TREE. */
    private static final DustWall                dustwall                = new DustWall();

    /** The Constant MACADAM. */
    private static final Ground             ground             = new Ground();


    /**
     * The motionless elements is an array of all possible MotionlessElement.
     */
    private static MotionlessElement[]       motionlessElements  = {
    	wall,
    	ground,
        dustwall, };
    
    public static MotionlessElement createWall() {
        return wall;
    }

    /**
     * Creates a new ground object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createGround() {
        return ground;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDustWall() {
        return dustwall;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return ground;
    }
}