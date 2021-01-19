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

enum Neighbors {
  ZERO(new ImageIcon("img/0.jpg"), 0),
  ONE(new ImageIcon("img/1.jpg"), 1),
  TWO(new ImageIcon("img/2.jpg"), 2),
  THREE(new ImageIcon("img/3.jpg"), 3),
  FOUR(new ImageIcon("img/4.jpg"), 4),
  FIVE(new ImageIcon("img/5.jpg"), 5),
  SIX(new ImageIcon("img/6.jpg"), 6),
  SEVEN(new ImageIcon("img/7.jpg"), 7),
  EIGHT(new ImageIcon("img/8.jpg"), 8);
  
  public final ImageIcon icon;
  public final int value;
  
  private Neighbors(ImageIcon icon, int value) {
        this.icon = icon;
        this.value = value;
    }
}

public class Grafics extends JFrame implements ActionListener, MouseListener{
   // private  Map<JButton, Integer> buttons = new HashMap();
    List<MinesweeperObject> buttons = new ArrayList();
    
    Font font = new Font("Arial",Font.BOLD ,12 );
    ImageIcon icon = new ImageIcon("img/flag.jpg");
    int mines = 10;
    
    public Grafics()
    {
        super("Mine sewper test");
        GridLayout gridLayout = new GridLayout(9,9);
        setLayout(gridLayout);
        
        buttons.add(null);
        
                
        for(int i=1; i<82; i++){
            MinesweeperObject button = new MinesweeperObject(i);
            buttons.add(button);            
            button.addActionListener(this);
            button.addMouseListener(this);
            add(button);           
        }
        generateMines();
        setNeighbors();
        
        
    }
    
    public void generateMines(){
        Random r = new Random();
        int index;
        while(mines>0){
            index = r.nextInt(81)+1;
            if(!buttons.get(index).getIsMine()){
                buttons.get(index).setIsMine(true);
                mines--;
            }
        }
    }
    
    public void setNeighbors(){
        SortedSet<Integer> neiborsMined = new TreeSet<>();
        int num;
        for (Iterator<MinesweeperObject> it = buttons.iterator(); it.hasNext();) {
            MinesweeperObject button = it.next();
            if(button!=null && !button.getIsMine()){                
                for(Integer i : findneibors(button.getIndex()))
                    if(buttons.get(i).getIsMine())
                        neiborsMined.add(i);
                num = neiborsMined.size();
                for(Neighbors n : Neighbors.values()){
                    if(n.value == num)
                        button.setNeighbors(n);
                }
                neiborsMined.clear();
            }
        }
    }
    
    private SortedSet<Integer> findneibors(int index) {
        SortedSet<Integer> neibors = new TreeSet();
      
        if(index%9 != 1)
           neibors.add(index-1);
        if(index>9 )
            neibors.add(index-9);
        if(index%9 !=0 )
            neibors.add(index+1);
        if(index<73 )
            neibors.add(index+9);
        if(index-10>0 && index%9 != 1 )
            neibors.add(index-10);
        if(index+10<82 && index%9 !=0 )
            neibors.add(index+10);
        if(index-8>0 && index%9 !=0 )
            neibors.add(index-8);
        if(index+8<82 && index%9 != 1 )
            neibors.add(index+8);
        
        return neibors;      
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = buttons.indexOf(e.getSource());
        MinesweeperObject button = buttons.get(index);
        System.out.print(index+" ");      
        button.setEnabled(false);
        if(button.getIsMine()){
            button.setIcon(new ImageIcon("img/mine.png"));
            button.setDisabledIcon(new ImageIcon("img/mine.png"));
        }
        else{
            button.setIcon(button.getNeighbors().icon);
            button.setDisabledIcon(button.getNeighbors().icon);
        }
       //button.setIcon(null);
       
       
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = buttons.indexOf(e.getSource());
        MinesweeperObject button = buttons.get(index);
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

    
    
}
