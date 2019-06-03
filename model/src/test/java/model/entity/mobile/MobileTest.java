package model.entity.mobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.model.IMap;
import contract.model.Permeability;
import contract.model.Sprite;
import junit.framework.Assert;
import model.Map;

public class MobileTest {

	private Mobile mobile;
	private IMap map;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		this.mobile = new Rock(map);

	}

	@After
	public void tearDown() throws Exception {
	}
/*
	@Test
	public void testIsBlocking() {
		
		Permeability expected = Permeability.BLOCKING;
		assertEquals(expected,  this.mobile.getOnTheMapXY(4,4).getPermeability());
	}
	@Test
	public void testIsPushable() {
		
		Permeability expected = Permeability.PUSHABLE;
		assertEquals(expected, this.mobile.getOnTheMapXY(4,4).getPermeability());
	}
	@Test
	public void testIsFinishable() {
		
		Permeability expected = Permeability.BLOCKING;
		assertEquals(expected, this.mobile.getOnTheMapXY(4,4).getPermeability());
	}
	@Test
	public void testIsDead() {
		
		Permeability expected = Permeability.KILLABLE;
		assertEquals(expected, this.mobile.getOnTheMapXY(4,4).getPermeability());
	}
	
	@Test
	public void testIsOut() {
		
		Permeability expected = Permeability.FINISHABLE;
		assertEquals(expected, this.mobile.getOnTheMapXY(4,4).getPermeability());
	}
	
	@Test
	public void testIsFallInjure() {
		
		Permeability expected = Permeability.BLOCKING;
		assertEquals(expected, this.mobile.getOnTheMapXY(4,4).getPermeability());
	}
	
	@Test
	public void testIsDestructible() {
		
		Permeability expected = Permeability.DESTRUCTIBLE;
		assertEquals(expected, this.mobile.getOnTheMapXY(7,5).getPermeability());
	}
	
	@Test
	public void testIsRemoveable() {
		
		Permeability expected = Permeability.REMOVEABLE;
		assertEquals(expected, ((IMap) this.mobile).getOnTheMapXY(9,9).getPermeability());
	}
	*/
	@Test
	public void testGetScore() {
		
		int expected = 0;
		assertEquals(expected, this.mobile.getScore());
	}
	
	@Test
	public void testIsFinish() {
		
		Boolean expected = false;
		assertEquals(expected, this.mobile.isFinish());
	}
	@Test
	public void testIsInGame() {
		
		Boolean expected = true;
		assertEquals(expected, this.mobile.isInGame());
	}
}
