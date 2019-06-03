/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package model;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import contract.model.IMap;
import contract.model.IMobile;



public class ModelTest {
	
	Model model;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        this.model = new Model(null);
    }

    @After
    public void tearDown() throws Exception {
    }


    /**
     * @throws IOException 
     */
    @Test
    public void testGetMap() throws IOException {
    	
    	IMap map = new Map("Road.txt");
    	Assert.assertSame(map, this.model.getMap());
    }
    
    @Test
    public void testGetPlayer() {
    	
    	IMobile player = null;
    	Assert.assertSame(player, this.model.getPlayer());
    }
    
   
}
