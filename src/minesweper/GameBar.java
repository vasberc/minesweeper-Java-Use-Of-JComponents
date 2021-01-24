/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Βασίλης
 * 
 * This class provide us the game bar
 * Game bar has a layout, a system, a timer and a reset button
 */
public class GameBar extends JPanel implements MouseListener{
    private JButton resetGame ;
    private JButton highScores;
    private final BorderLayout layout = new BorderLayout();       
    private  final Counter counter = new Counter();   
    private final GameEngine engine;  

    public GameBar(GameEngine engine) {
        this.engine = engine;
        setBar();
        
    }
    
    //init the GameBar
    private void setBar() {
        ImageIcon barIcon = new ImageIcon("img/Minesweeperboard.png");
        ImageIcon  statsIcon= new ImageIcon("img/stats.png");
        layout.setHgap(30); //Space between the components
        this.setLayout(layout);       
        resetGame = new JButton();
        resetGame.setIcon(barIcon);
        resetGame.setToolTipText("New Game");        
        resetGame.setPreferredSize(new Dimension(30, 30));
        resetGame.addMouseListener(this);
        add(counter, BorderLayout.LINE_START);
        add(resetGame, BorderLayout.CENTER);
        highScores = new JButton();
        highScores.setIcon(statsIcon);
        highScores.setToolTipText("Show High Scores");   
        highScores.setPreferredSize(new Dimension(50, 30));
        highScores.addMouseListener(this);
        add(highScores, BorderLayout.LINE_END);
    }    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==resetGame)
            engine.resetGame();//this is triggered when the reset button is clicked
        else if (e.getSource()==highScores)
            engine.showStats();
    }

    @Override
    public void mousePressed(MouseEvent e) {        
    }

    @Override
    public void mouseReleased(MouseEvent e) {        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public JButton getButton() {
        return resetGame;
    }
    
    public Counter getCounter() {
        return counter;
    }
    
    public JButton getHighScores() {
        return highScores;
    }

   
    
}
