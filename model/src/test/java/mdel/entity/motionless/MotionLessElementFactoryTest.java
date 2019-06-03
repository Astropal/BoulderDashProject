package mdel.entity.motionless;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.entity.motionless.Door;
import model.entity.motionless.DustWall;
import model.entity.motionless.Ground;
import model.entity.motionless.MotionlessElement;
import model.entity.motionless.Wall;

public class MotionLessElementFactoryTest {
	
	MotionlessElement motionlessElement;
	MotionlessElement wall;
	MotionlessElement dustwall;
	MotionlessElement ground;
	MotionlessElement door;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.dustwall = new DustWall();
		this.wall = new Wall();
		this.ground = new Ground();
		this.door = new Door();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateWall() {
		
		//assertSame(this.wall, this.motionlessElement.createWall());
	}

}
