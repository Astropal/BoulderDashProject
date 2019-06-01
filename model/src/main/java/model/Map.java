package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import contract.model.IElement;
import contract.model.IMap;
import contract.model.Permeability;
import model.entity.mobile.Enemy;
import model.entity.mobile.Mobile;
import model.entity.mobile.MobileElementsFactory;
import model.entity.motionless.Ground;
import model.entity.motionless.MotionlessElementsFactory;

public class Map extends Observable implements IMap {

    /** The width. */
    private int          width;

    /** The height. */
    private int          height;

    /** The on the road. */
    private IElement[][] onTheMap;

    /**
     * Instantiates a new road with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    Map(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
    }

    /**
     * Loads file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
				if (((line.toCharArray()[x]) == 'D') || ((line.toCharArray()[x]) == 'N') || ((line.toCharArray()[x]) == 'E')) {
                this.setOnTheMapXY(MobileElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            	}else {this.setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);}
             }

            line = buffer.readLine();
            y++;
        } 
        buffer.close();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getWidth()
     */
    @Override
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getHeight()
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(final int height) {
        this.height = height;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getOnTheRoadXY(int, int)
     */
    @Override
    public IElement getOnTheMapXY(final int x, final int y) {
        return this.onTheMap[x][y];
    }
   
    /**
     * Sets the on the road XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public void setOnTheMapXY(final IElement element, final int x, final int y) {
        this.onTheMap[x][y] = element;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#setMobileHasChanged()
     */
    @Override
    public final void setMapHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getObservable()
     */
    @Override
    public Observable getObservable() {
        return this;
    }
    
    public IElement[][] getMap() {
		return onTheMap;
	}
    
    public boolean isEmpty(int x, int y) {
		if (getOnTheMapXY(x, y).getClass().equals(Ground.class)) {
			return true;
		}
		return false;
	}
    
    public void moveEnemy(Mobile element) {
		int x = 0;
		int y = 0;
		x = element.getX();
		y = element.getY();

		if (isEmpty(x + 1, y)) {
			element.setX(x + 1);
			element.setY(y);
		} else if (isEmpty(x, y - 1) && !isEmpty(x + 1, y)) {
			element.setX(x);
			element.setY(y - 1);
		} else if (isEmpty(x - 1, y) && !isEmpty(x, y - 1) && !isEmpty(x + 1, y)) {
			element.setX(x - 1);
			element.setY(y);
		} else if (isEmpty(x, y - 1) && !isEmpty(x - 1, y) && !isEmpty(x, y - 1) && !isEmpty(x + 1, y)) {
			element.setX(x);
			element.setY(y - 1);
		} else {
			element.doNothing();
		}
	}
    
    public void lookForAndMoveEnemy() {
		IElement[][] elem = getMap();
		for (int j = 0; j < elem.length; j++) {
			for (int i = 0; i < elem[i].length; i++) {
				if (getOnTheMapXY(i, j).getClass().equals(Enemy.class)) {
					moveEnemy((Mobile) getOnTheMapXY(i, j));
				}
			}
		}
	}
    
    public void gravity() throws InterruptedException {
    	for (int y = this.getHeight()-1;y > 0; y--) {
			for (int x = this.getWidth()-1; x > 0; x--) {
				if(this.getOnTheMapXY(x, y).getPermeability() == Permeability.PUSHABLE && this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE){
					this.setOnTheMapXY(MotionlessElementsFactory.createGround(), x, y);
					this.setOnTheMapXY(MobileElementsFactory.createRock(), x, y+1);
				}
				if(this.getOnTheMapXY(x, y).getPermeability() == Permeability.REMOVEABLE && this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE){
					this.setOnTheMapXY(MotionlessElementsFactory.createGround(), x, y);
					this.setOnTheMapXY(MobileElementsFactory.createDiamond(), x, y+1);
				}
				if(this.getOnTheMapXY(x, y).getPermeability() == Permeability.REMOVEABLE && this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.BLOCKING){
					this.setOnTheMapXY(MobileElementsFactory.createRock(), x, y - 1);
				}
			}
		}
	}
    
    public void moveEnemy() throws InterruptedException {
    	for (int y = this.getHeight()-1;y > 0; y--) {
			for (int x = this.getWidth()-1; x > 0; x--) {
				int Dir = (int)(Math.random() * 4);
				if(Dir == 0 && this.getOnTheMapXY(x, y).getPermeability() == Permeability.KILLABLE && this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE){
					this.setOnTheMapXY(MotionlessElementsFactory.createGround(), x, y);
					this.setOnTheMapXY(MobileElementsFactory.createEnemy(), x, y+1);
				}
				if(Dir == 1 && this.getOnTheMapXY(x, y).getPermeability() == Permeability.KILLABLE && this.getOnTheMapXY(x, y - 1).getPermeability() == Permeability.PENETRABLE){
					this.setOnTheMapXY(MotionlessElementsFactory.createGround(), x, y);
					this.setOnTheMapXY(MobileElementsFactory.createEnemy(), x, y-1);
				}
				if(Dir == 2 && this.getOnTheMapXY(x, y).getPermeability() == Permeability.KILLABLE && this.getOnTheMapXY(x + 1, y).getPermeability() == Permeability.PENETRABLE){
					this.setOnTheMapXY(MotionlessElementsFactory.createGround(), x, y);
					this.setOnTheMapXY(MobileElementsFactory.createEnemy(), x+1, y);
				}
				if(Dir == 3 && this.getOnTheMapXY(x, y).getPermeability() == Permeability.KILLABLE && this.getOnTheMapXY(x - 1, y).getPermeability() == Permeability.PENETRABLE){
					this.setOnTheMapXY(MotionlessElementsFactory.createGround(), x, y);
					this.setOnTheMapXY(MobileElementsFactory.createEnemy(), x-1, y);
				}
			}
		}
	}
}