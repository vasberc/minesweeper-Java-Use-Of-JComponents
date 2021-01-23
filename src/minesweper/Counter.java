/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Βασίλης
 */
public class Counter extends JLabel{
    
    private int count;

    public Counter() {
        this.count = -1;
        setLabelOprions();
    }
    
    Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                setText(Integer.toString(count));
            }
        });;

    private void setLabelOprions() {
        this.setPreferredSize(new Dimension(50, 30));
        this.setHorizontalAlignment(SwingConstants.CENTER);        
        this.setOpaque(true);
        this.setBackground(Color.black);
        this.setForeground(Color.red);
        this.setFont(new Font("Digital-7" ,Font.BOLD,28));
    }
    
    
}
