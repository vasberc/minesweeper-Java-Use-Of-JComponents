/*
 * Button Objects of Minesweeper
 */
package minesweper;

import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JButton;

/**
 *
 * @author Βασίλης
 */


public class Box extends JButton implements Comparable<Box>{
    
    private boolean Mined;//controls a mine is behind
    private boolean Flaged;//controls if the user put flag on top
    private Neighbors neighborsMined;//number of naighbors with mine
    private SortedSet<Box> neighbors;//All neighbor boxes    
    private final int index;//index of the object in the ArrayList

    //Constructor
    public Box(int index) {
        super();//init all the JButton attributes
        this.index = index;
        //default values, before mine generating
        Mined = false;
        Flaged = false;
        neighbors = new TreeSet<>();
        neighborsMined = Neighbors.ZERO;
        
    }

    public void setNeighbors(SortedSet<Box> neighbors) {
        this.neighbors = neighbors;
    }

    public void setMine(boolean Mined) {
        this.Mined = Mined;
    }

    public void setFlaged(boolean Flaged) {
        this.Flaged = Flaged;
    }

    public void setNeighborsMined(Neighbors neighborsMined) {
        this.neighborsMined = neighborsMined;
    }

    public boolean isMined() {
        return Mined;
    }

    public boolean isFlaged() {
        return Flaged;
    }

    public Neighbors getNeighborsMined() {
        return neighborsMined;
    }

    public SortedSet<Box> getNeighbors() {
        return neighbors;
    }
    
    public int getIndex() {
        return index;
    }
    
    @Override
    public int compareTo(Box b) { 
        if(this.Flaged && !b.Flaged)
            return 1;
        else if (!this.Flaged && b.Flaged)
            return -1;
        else
            return index-b.getIndex();
    }
        
    
}
