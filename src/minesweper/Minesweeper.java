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
        Grafics grafics = new Grafics();
        grafics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grafics.setSize(400, 400);
        grafics.setResizable(false);
        grafics.setVisible(true);
    }
    
}
