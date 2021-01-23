/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweper;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Βασίλης
 */
public class Minesweeper {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
              
        SystemGrafics system = new SystemGrafics("MineSweeper");
        
        system.setSize(250, 325);
        system.setLocationRelativeTo(null);
        system.setResizable(false);
        system.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        system.setVisible(true);
        
        
        
        
       
        
        
        
        
        
        
    }
    
}
