package model.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.entity.mobile.Rock;
import contract.model.Permeability;;
/**
 * @author Bastien Dupont
 *
 */
public class ElementTest {


    Rock rock;

    /**
     * Instantiate Rock
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        this.rock = new Rock(null);
    }

    /**
     * Test Get Permeability
     */
    @Test
    public void testgetPermeability() {
        final Permeability PExpected = Permeability.PUSHABLE;
        assertEquals(PExpected,this.rock.getPermeability());
    }

    /**
     * Test Get Sprite
     */
    @Test
    public void testgetSprite() {
        assertNotNull(this.rock.getSprite());
    }
}