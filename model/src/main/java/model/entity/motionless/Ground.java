package model.entity.motionless;

import contract.model.Permeability;
import contract.model.Sprite;

public class Ground extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Ground.jpg");

    /**
     * Instantiates a new Ground.
     */
    public Ground() {
        super(SPRITE, Permeability.PENETRABLE);
    }
}
