package model.entity.motionless;

import contract.model.Permeability;
import contract.model.Sprite;

class DustWall extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('^', "Tree.jpg");

    /**
     * Instantiates a new tree.
     */
    DustWall() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
