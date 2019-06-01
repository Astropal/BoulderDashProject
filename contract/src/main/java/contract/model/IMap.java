package contract.model;

import java.util.Observable;

import contract.model.IElement;


public interface IMap {
	
	/**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the on the road XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
    IElement getOnTheMapXY(int x, int y);
    
    public void setOnTheMapXY(final IElement element, final int x, final int y);

    /**
     * Sets the mobile has changed.
     */
    void setMapHasChanged();

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();

	void lookForAndMoveEnemy();
	
	void gravity() throws InterruptedException;
	
	void moveEnemy() throws InterruptedException;
    


}
