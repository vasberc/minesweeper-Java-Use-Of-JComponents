/*
 * Button Objects of Minesweeper
 */
package minesweper;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Βασίλης
 */


public class MinesweeperObject extends JButton{
    
    private boolean isMine;
    private boolean isFlaged;
    private Neighbors neighborsMined;
    private int index;

    public MinesweeperObject(int index) {
        super();
        this.index = index;
        isMine = false;
        isFlaged = false;
        neighborsMined = Neighbors.ZERO;
    }

    

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

    public void setIsFlaged(boolean isFlaged) {
        this.isFlaged = isFlaged;
    }

    public void setNeighbors(Neighbors neighborsMined) {
        this.neighborsMined = neighborsMined;
    }

    public boolean getIsMine() {
        return isMine;
    }

    public boolean getIsFlaged() {
        return isFlaged;
    }

    public Neighbors getNeighbors() {
        return neighborsMined;
    }
    
    public int getIndex() {
        return index;
    }
    
}
