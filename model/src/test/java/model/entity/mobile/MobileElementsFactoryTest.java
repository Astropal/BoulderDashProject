
package model.entity.mobile;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.model.IElement;
import model.entity.mobile.MobileElementsFactory;;
/**
 * @author Bastien Dupont
 *
 */
public class MobileElementsFactoryTest {

    
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
        IElement element = new Rock(null);
        assertEquals(element.getSprite().getImage(), MobileElementsFactory.getFromFileSymbol('N').getSprite().getImage());
    }

    /**
     * Test Create Enemy
     */
    @Test
    public void testCreateEnemy() {
        this.expected = 'E';
        assertEquals(expected, MobileElementsFactory.createEnemy().getSprite().getConsoleImage());
    }
    
    /**
     * Test Create Enemy
     */
    @Test
    public void testCreateEnemy2() {
        this.expected = 'P';
        assertEquals(expected, MobileElementsFactory.createEnemy2().getSprite().getConsoleImage());
    }

    /**
     * Test Create Diamond
     */
    @Test
    public void testCreateDiamond() {
        this.expected = 'D';
        assertEquals(expected, MobileElementsFactory.createDiamond().getSprite().getConsoleImage());
    }

    /**
     * Test Create Rock
     */
    @Test
    public void testCreateRock() {
        this.expected = 'N';
        assertEquals(expected, MobileElementsFactory.createRock().getSprite().getConsoleImage());

    }

}