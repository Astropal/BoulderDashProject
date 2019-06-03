package model.entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.model.IMap;
import contract.model.Permeability;
import contract.model.Sprite;
import model.entity.mobile.Rock;

public class ElementTest {
	
	Element element;
	Sprite sprite;
	Rock rock;
	IMap map;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.rock = new Rock(map);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPermeability() {
		
		Permeability expected = Permeability.PUSHABLE;
		assertNotNull(this.rock.getPermeability());
		assertEquals(expected, this.rock.getPermeability());
		
	}
	
	@Test
	public void testGetSprite() {
		
		String expected = "Rock.jpg";
		assertNotNull(this.rock.getSprite());
		assertEquals(expected, this.rock.getSprite().getImageName());
		
	}
	
	/*@Test
	public void testGetImage() {
		
		String expected = "Rock.jpg";
		assertNotNull(this.rock.getImage());
		assertEquals(expected, this.rock.getSprite().getImage());
		
	}*/
	
	@Test
	public void testGetX() {
		
		int expected = 0;
		assertNotNull(this.rock.getX());
		assertEquals(expected, this.rock.getX());
	}
	
	@Test
	public void testGetY() {
			
			int expected = 0;
			assertNotNull(this.rock.getY());
			assertEquals(expected, this.rock.getY());
	}
	
	@Test
	public void testGetPosition() {
			
			//Point expected;
			assertNotNull(this.rock.getPosition());
			//assertEquals(expected, this.rock.getY());
		}
	
	

}
