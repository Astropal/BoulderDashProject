package model;

import java.io.IOException;
import java.util.Observable;

import contract.model.IMobile;
import contract.model.IModel;
import contract.model.IMotionless;
import contract.model.IMap;
import model.entity.mobile.Player;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {
	
	/** The road. */
    private IMap   map;

    /** The my vehicle. */
    private IMobile player;
    
    
    private IMotionless element;
    
    

	/**
	 * Instantiates a new model.
	 */
	public Model(final String fileName) throws IOException {
		
		this.setMap(new Map(fileName));
        this.setPlayer(new Player(this.getMap()));
        this.player.setX(5);
        this.player.setY(5);
       // this.setElement(new DustWall());
	}

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 *
	public HelloWorld getHelloWorld() {
		return this.helloWorld;
	}
	*/
	@Override
    public final IMap getMap() {
        return this.map;
    }
	
	/**
     * Sets the road.
     *
     * @param road
     *            the road to set
     */
    private void setMap(final IMap map) {
        this.map = map;
    }
    
    @Override
    public final IMobile getPlayer() {
        return this.player;
    }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the myVehicle to set
     */
    private void setPlayer(final IMobile player) {
        this.player = player;
    }
    
    @Override
    public final IMotionless getElement() {
        return this.element;
    }
    
    public void setElement(final IMotionless element) {
        this.element = element;
    }

	/**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     *
	private void setHelloWorld(final HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
		this.setChanged();
		this.notifyObservers();
	}*/

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 *
	public void loadHelloWorld(final String code) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setHelloWorld(daoHelloWorld.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}*/

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	@Override
	public entity.HelloWorld getHelloWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadHelloWorld(String code) {
		// TODO Auto-generated method stub
		
	}
}
