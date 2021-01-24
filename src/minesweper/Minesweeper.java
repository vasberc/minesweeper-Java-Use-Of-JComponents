/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweper;

import javax.swing.JFrame;

/**
 *
 * @author Βασίλης
 */
public class Minesweeper {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
              
        GameEngine system = new GameEngine("MineSweeper");
        
        system.setSize(250, 325);
        system.setLocationRelativeTo(null);
        system.setResizable(false);
        system.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        system.setVisible(true);
        
        
        
        
       
        
        
        
        
        
        
    }
    
}
