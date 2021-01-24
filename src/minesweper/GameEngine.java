/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweper;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Βασίλης
 * 
 * This class provide us the main Window
 * As we can see thw main window has a layout, the gameGrafics and a gameBar
 */
public class GameEngine extends JFrame {   
    
    private final FlowLayout flowLayout = new FlowLayout();       
    private GameGrafics gameGrafics ;
    private GameBar gameBar;
    private StatsView stats;

    
    
    public GameEngine(String title) {
        super(title);
        setGameEngine();
    }

   
    
    private void setGameEngine() {
        
        
        gameGrafics = new GameGrafics(this);
        gameBar = new GameBar(this);
        stats = new StatsView();
        
        setLayout(flowLayout);       
        add(gameBar);
        add(gameGrafics);
        
        //The counter starts when all grafics are ready
        gameBar.getCounter().timer.setInitialDelay(0);
        gameBar.getCounter().timer.start();
    }
    
    //this method reset the game
    public void resetGame(){
        this.remove(gameGrafics); //remove all grafics    
        this.remove(stats); //remove all grafics   
        this.remove(gameBar);
        this.repaint();
        this.setGameEngine(); //set them again, all objects are new
    }
    
    public void showStats() {
       
       
        this.gameBar.getCounter().timer.stop();
        this.remove(gameGrafics); //remove all grafics  
        
        this.remove(stats); //remove all grafics   
        this.remove(gameBar);
        this.repaint();
        this.repaint();
        this.validate();
        this.add(gameBar);        
        this.add(stats);        
        this.validate();
        
        
        
        
        
    }
    
    //Help GameBar class communicate with GameGrafics class  
    public GameGrafics getGameGrafics() {
        return gameGrafics;
    }
    //Help GameGrafics class communicate with GameBar class  
     public GameBar getGameBar() {
        return gameBar;
    }
     
    public StatsView getStats() {
       return stats;
    }
    
}
