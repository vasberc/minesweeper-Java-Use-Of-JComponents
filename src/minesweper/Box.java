/*
 * Button Objects of Minesweeper
 */
package minesweper;

import javax.swing.JButton;

/**
 *
 * @author Βασίλης
 */


public class Box extends JButton{
    
    private boolean Mined;//controls a mine is behind
    private boolean Flaged;//controls if the user put flag on top
    private Neighbors neighborsMined;//number of naighbors with mine
    private final int index;//index of the object in the ArrayList

    //Constructor
    public Box(int index) {
        super();//init all the JButton attributes
        this.index = index;
        //default values, befor mine genarating
        Mined = false;
        Flaged = false;
        neighborsMined = Neighbors.ZERO;
    }

    

    public void setMine(boolean Mined) {
        this.Mined = Mined;
    }

    public void setFlaged(boolean Flaged) {
        this.Flaged = Flaged;
    }

    public void setNeighbors(Neighbors neighborsMined) {
        this.neighborsMined = neighborsMined;
    }

    public boolean isMined() {
        return Mined;
    }

    public boolean isFlaged() {
        return Flaged;
    }

    public Neighbors getNeighbors() {
        return neighborsMined;
    }
    
    public int getIndex() {
        return index;
    }
    
}
