package controller;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.model.IModel;
import contract.view.IView;

public class ControllerTest {
	IView view;
	IModel model;
	Controller controller;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.controller = new Controller(view,model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetOrderPerformer() {
		
		assertNotNull(this.controller.getOrderPeformer());
		
	}

}
