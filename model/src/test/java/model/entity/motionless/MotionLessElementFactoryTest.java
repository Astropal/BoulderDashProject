
package model.entity.motionless;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.model.IElement;

/**
 * @author Bastien Dupont
 *
 */
public class MotionLessElementFactoryTest {

    
    char expected;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {

    }

    /**
     * Test Get From File Symbol
     */
    @Test
    public void testGetFromFileSymbol() {
        IElement element = new Ground();
        assertEquals(element.getSprite().getImage(), MotionlessElementsFactory.getFromFileSymbol(' ').getSprite().getImage());
    }

    /**
     * Test Create Door
     */
    @Test
    public void testCreateDoor() {
        this.expected = 'X';
        assertEquals(expected, MotionlessElementsFactory.createDoor().getSprite().getConsoleImage());
    }

    /**
     * Test Create DustWall
     */
    @Test
    public void testCreateDustWall() {
        this.expected = '^';
        assertEquals(expected, MotionlessElementsFactory.createDustWall().getSprite().getConsoleImage());
    }

    /**
     * Test Create Ground
     */
    @Test
    public void testCreateGround() {
        this.expected = ' ';
        assertEquals(expected, MotionlessElementsFactory.createGround().getSprite().getConsoleImage());
    }

    /**
     * Test Create Wall
     */
    @Test
    public void testCreateWall() {
        this.expected = 'W';
        assertEquals(expected, MotionlessElementsFactory.createWall().getSprite().getConsoleImage());

    }

}