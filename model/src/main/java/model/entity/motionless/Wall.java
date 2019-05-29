package model.entity.motionless;

import contract.model.Permeability;
import contract.model.Sprite;

class Wall extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('W', "wall.png");

    /**
     * Instantiates a new ditchLeft.
     */
    Wall() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
