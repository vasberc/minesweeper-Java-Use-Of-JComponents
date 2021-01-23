/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweper;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Βασίλης
 */
public class GameBar extends JPanel implements MouseListener{
    private JButton button ;
    private final BorderLayout layout = new BorderLayout();       
    private Counter counter;
    
    private final SystemGrafics system;
    
   

    public GameBar(SystemGrafics system) {
        this.system = system;
        setBar(system.getGameGrafics());
        
    }
    
     private void setBar(GameGrafics gameGrafics) {
        ImageIcon BarIcon = new ImageIcon("img/Minesweeperboard.png");
        layout.setHgap(30);
        this.setLayout(layout);       
        button = new JButton();
        button.setIcon(BarIcon);
        button.setToolTipText("Restart Game");
        counter = gameGrafics.getLabel();
        button.setPreferredSize(new Dimension(30, 30));
        button.addMouseListener(this);
        add(counter, BorderLayout.LINE_START);
        add(button, BorderLayout.CENTER);
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(50, 30));
        add(label, BorderLayout.LINE_END);
    }

    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        system.resetGame();
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
        return button;
    }

   
    
}
