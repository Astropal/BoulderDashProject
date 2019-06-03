package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.model.IElement;
import model.entity.mobile.Rock;

public class MapTest {

	Map map;
	String txtmap = "road.txt";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map = new Map(txtmap);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWidht() {

		int expected = 47;
		assertEquals(expected, this.map.getWidth());
	}

	@Test
	public void testGetHeight() {

		int expected = 27;
		assertEquals(expected, this.map.getHeight());
	}
	
	@Test
	public void testGetOnTheMapXY() {

		IElement expected = new Rock(map);
		assertSame(expected, this.map.getOnTheMapXY(15,5));
	}
	

}
