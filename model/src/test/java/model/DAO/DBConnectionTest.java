package model.DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBConnectionTest {
	
	DBConnection INSTANCE = new DBConnection();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		DBConnection expected = new DBConnection();
		assertEquals(expected, this.INSTANCE.getInstance());
	}
	
	
	@Test (expected = Exception.class)
	public void testConnect() {
		this.INSTANCE.connect();
	}
	
}
