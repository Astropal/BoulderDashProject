package model.entity.motionless;

import contract.model.Permeability;
import contract.model.Sprite;

class Obstacle extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('X', "rock.png");

    /**
     * Instantiates a new obstacle.
     */
    Obstacle() {
        super(SPRITE, Permeability.PUSHABLE);
    }
}
