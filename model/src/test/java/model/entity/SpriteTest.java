package model.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.entity.mobile.Rock;

/**
 * @author Bastien Dupont based on work of Laetitia
 *
 */
public class SpriteTest {

    Rock rock;

    /**
     * Instanciates a new rock
     * @throws Exception the Exception
     */
    @Before
    public void setUp() throws Exception {
        this.rock = new Rock(null);
    }

    /**
     *  test get the image
     */
    @Test
    public void testgetImageName() {
        final String SExpected = "Rock.jpg";
        assertEquals(SExpected, this.rock.getSprite().getImageName());

    }

    /**
     * test the get console image
     */
    @Test
    public void testgetConsoleImage() {
        final char CExpected = 'N';
        assertEquals(CExpected, this.rock.getSprite().getConsoleImage());
    }

}