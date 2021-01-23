/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweper;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Βασίλης
 */
public class SystemGrafics extends JFrame {   
    
    private final FlowLayout flowLayout = new FlowLayout();       
    private GameGrafics gameGrafics ;
    private GameBar gameBar;
    
    public SystemGrafics(String title) {
        super(title);
        setSystemGrafics();
    }
    
    private void setSystemGrafics() {
        
        
        gameGrafics = new GameGrafics();
        gameBar = new GameBar(this);
        setLayout(flowLayout);       
        add(gameBar);
        add(gameGrafics);
        gameGrafics.getLabel().timer.setInitialDelay(0);
        gameGrafics.getLabel().timer.start();
    }
    
    public void resetGame(){
        this.remove(gameGrafics);        
        this.remove(gameBar);
        this.setSystemGrafics();
    }

    public GameGrafics getGameGrafics() {
        return gameGrafics;
    }

    
    
}
