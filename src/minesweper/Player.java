/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweper;

import java.io.Serializable;

/**
 *
 * @author Βασίλης
 */
public class Player implements Serializable {    
    
    private String name;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    
    
    
    
    
}
