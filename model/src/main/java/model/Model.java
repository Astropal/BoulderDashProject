package model;

import java.io.IOException;
import java.util.Observable;

import contract.model.IMobile;
import contract.model.IModel;
import contract.model.IMap;
import model.entity.mobile.Player;

/**
 * The Class Model.
 *
 * @author Bastien Dupont based on work of Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {
	
	/** The map. */
    private IMap   map;

    /** The Player. */
    private IMobile player;
    

	/**
	 * Instantiates a new model.
	 * @param fileName the fileName
	 * @throws IOException the IOException
	 */
	public Model(final String fileName) throws IOException {
		
		this.setMap(new Map(fileName));
        this.setPlayer(new Player(this.getMap()));
        this.player.setX(5);
        this.player.setY(5);
       // this.setElement(new DustWall());
	}
	
	/*
	 * (Non Java-doc)
	 * 
	 * Get the map.
	 */
	@Override
    public final IMap getMap() {
        return this.map;
    }
	
	/**
     * Sets the road.
     *
     * @param map
     *            the map to set
     */
    private void setMap(final IMap map) {
        this.map = map;
    }
    
    /*
	 * (Non Java-doc)
	 * 
	 * Get the player.
	 */
    @Override
    public final IMobile getPlayer() {
        return this.player;
    }

    /**
     * Sets the player.
     *
     * @param player
     *            the player to set
     */
    private void setPlayer(final IMobile player) {
        this.player = player;
    }

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
