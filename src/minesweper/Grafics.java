/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweper;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Βασίλης
 */
public class Grafics extends JFrame implements ActionListener, MouseListener{
   // private  Map<JButton, Integer> buttons = new HashMap();
    List<JButton> buttons = new ArrayList();
    List<Integer> gameObjects = new ArrayList();
    Font font = new Font("Arial",Font.BOLD ,12 );
    ImageIcon icon = new ImageIcon("img/flag.jpg"); 
    
    public Grafics()
    {
        super("Mine sewper test");
        GridLayout gridLayout = new GridLayout(9,9);
        setLayout(gridLayout);
        
        buttons.add(null);
        gameObjects.add(null);
                
        for(int i=1; i<82; i++){
            JButton button = new JButton();
            buttons.add(button);            
            button.addActionListener(this);
            button.addMouseListener(this);
            add(button);
            gameObjects.add(i);
        
            
        }
    }
        

    @Override
    public void actionPerformed(ActionEvent e) {
       int index = buttons.indexOf(e.getSource());
       JButton button = buttons.get(index);
       System.out.print(index+" ");      
      
       button.setEnabled(false);
       button.setIcon(new ImageIcon("img/1.jpg"));
       button.setDisabledIcon(new ImageIcon("img/1.jpg"));
       //button.setIcon(null);
       
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = buttons.indexOf(e.getSource());
        JButton button = buttons.get(index);
        if (SwingUtilities.isRightMouseButton(e) ){
            
            System.out.println("Right Worked on "+ index);
            findneibors(index); 
            button.setIcon(icon);
        }
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

    private void findneibors(int index) {
        SortedSet<Integer> neibors = new TreeSet();
        System.out.println("My neibors are");
        if(index%9 != 1)
           neibors.add(index-1);
        if(index>9)
            neibors.add(index-9);
        if(index%9 !=0)
            neibors.add(index+1);
        if(index<73)
            neibors.add(index+9);
        if(index-10>0 && index%9 != 1)
            neibors.add(index-10);
        if(index+10<82 && index%9 !=0)
            neibors.add(index+10);
        if(index-8>0 && index%9 !=0)
            neibors.add(index-8);
        if(index+8<82 && index%9 != 1)
            neibors.add(index+8);
        System.out.println(neibors);
        
        
        
    }
        
        
    
    
}
