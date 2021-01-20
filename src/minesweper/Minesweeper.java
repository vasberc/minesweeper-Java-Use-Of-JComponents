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
        
        GameGrafics gameGrafics = new GameGrafics();
        gameGrafics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameGrafics.setSize(300, 300);
        gameGrafics.setResizable(false);
        gameGrafics.setVisible(true);
    }
    
}
