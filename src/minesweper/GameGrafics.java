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

//Will use it to set the img acording the neighbors with mine
enum Neighbors {
  ZERO(new ImageIcon("img/0.jpg"), 0),  //no mined neighbors
  ONE(new ImageIcon("img/1.jpg"), 1),   //1 mined neighbor
  TWO(new ImageIcon("img/2.jpg"), 2),   //2 mined neighbors
  THREE(new ImageIcon("img/3.jpg"), 3), //3 mined neighbors
  FOUR(new ImageIcon("img/4.jpg"), 4),  //4 mined neighbors
  FIVE(new ImageIcon("img/5.jpg"), 5),  //5 mined neighbors
  SIX(new ImageIcon("img/6.jpg"), 6),   //6 mined neighbors
  SEVEN(new ImageIcon("img/7.jpg"), 7), //7 mined neighbors
  EIGHT(new ImageIcon("img/8.jpg"), 8); //8 mined neighbors
  
  public final ImageIcon icon;
  public final int value;
  
  //This constructor allows to put values on enum variable
  private Neighbors(ImageIcon icon, int value) {
        this.icon = icon;
        this.value = value;
    }
}


public class GameGrafics extends JFrame implements MouseListener{
   
    List<Box> boxes = new ArrayList();//All game objects will live here    
   
    ImageIcon flagIcon = new ImageIcon("img/flag.jpg");
    ImageIcon mineIcon = new ImageIcon("img/mine.png");
    ImageIcon remainingMineIcon = new ImageIcon("img/remainingMines.png");
    int mines = 10;
    int flags = mines;
    
    public GameGrafics()
    {
        super("Mine sewper test");
        GridLayout gridLayout = new GridLayout(9,9);
        setLayout(gridLayout);
        
        boxes.add(null);//we work with index form 1 to 81, every live is pack of 9
        
        //creating all game boxes and put them to the grid
        for(int i=1; i<=81; i++){
            Box box = new Box(i);//create the box with index = i
            boxes.add(box);//put the box to the list            
            box.addMouseListener(this);//listen to users mouse
            add(box);//put the box to the grid           
        }
        generateMines();//genarated random mines
        setNeighbors();//set for each object Neighbors attribute acording the genarated mines
        
        
    }
    
    //genarating mines
    public void generateMines(){
        Random r = new Random();
        int index;
        
        //while you have available mines to place, do
        while(mines>0){
            index = r.nextInt(81)+1;//pick a random index
            //if the box is not alraedy mined
            if(!boxes.get(index).isMined()){
                boxes.get(index).setMine(true);//put a mine
                mines--;//refresh mines plurality
            }
        }
    }
    
    //setting Neighbors attribute 
    public void setNeighbors(){
        //SortedSet<Integer> neiborsMined = new TreeSet<>();
        
        
        Iterator<Box> it = boxes.iterator();// to check all List elements
        Box box = it.next();//put out null element (index 0)
        while (it.hasNext()) {
            box = it.next();
            //if box is not mined
            if(!box.isMined()){
                int num = 0;//to count mined neighbors
                //for all its neigtbors, findneibors(int index) method returns a Set with all neighbors indexes
                for(Integer i : findneighbors(box.getIndex()))                    
                    if(boxes.get(i).isMined())//if current neighbor is mined
                        num+=1;//add his index to neiborsMined                
                //for all Neighbors enums find the one that is equal to num and put it to box attribute
                for(Neighbors n : Neighbors.values()){                    
                    if(n.value == num)
                        box.setNeighbors(n);
                }
                
            }
        }
    }
    
    //finding all my neighbors
    private SortedSet<Integer> findneighbors(int index) {
        SortedSet<Integer> neibors = new TreeSet();//to put all neighbors indexes
        
        //-x axis
        if(index%9 != 1)//if there is box left to me
           neibors.add(index-1);
        //+x axis
        if(index%9 !=0 )//if there is box right to me
            neibors.add(index+1);
        //-y axis
        if(index>9 )    //if the is box above to me
            neibors.add(index-9); 
        //+y axis
        if(index<73 )   //if there is box below to me
            neibors.add(index+9);
        //-x+y axis
        if(index-10>0 && index%9 != 1 ) //if there is box left and above me
            neibors.add(index-10);
        //+x-y axis
        if(index+10<82 && index%9 !=0 ) //if there is box right and below me
            neibors.add(index+10);
        //-x-y axis
        if(index+8<82 && index%9 != 1 ) //if there is box left and below me
            neibors.add(index+8);
        //+x+y axis
        if(index-8>0 && index%9 !=0 )   //if there is box right and above me
            neibors.add(index-8);
        
        return neibors;      
    }
    
    /*Open boxes if are not mined
    * If a box does not have mined neighbors,
    * it opens all not mined neighbors by retro call of itself
    */
    public void openBox(Box box){
         box.setEnabled(false);//open it   
        //if box does not have mined neighbors
        if(box.getNeighbors().value == 0){                    
            box.setIcon(Neighbors.ZERO.icon);//set the icons
            box.setDisabledIcon(Neighbors.ZERO.icon);
            //put all my neighbors in a set
            SortedSet<Integer> neighbors = findneighbors(box.getIndex());
            //for all of them
            for (Integer i : neighbors) {
                if (boxes.get(i).isEnabled()) {//if box is closed
                    openBox(boxes.get(i));//open it
                }
            }
        }
        else if(!box.isMined()){//if box has mined neighbors set the icons          
            box.setIcon(box.getNeighbors().icon);
            box.setDisabledIcon(box.getNeighbors().icon);  
        }
    }
    
    //Checks if player won
    public void checkIfWins(){
        int opend = 0;//to count opend boxes
        Iterator<Box> it = boxes.iterator();// to check all List elements
        Box box = it.next();//put out null element (index 0)
        while (it.hasNext()) {
            box = it.next();
            if(!box.isEnabled())
                opend++;//if bos is opend opend++
            
        }
        if(81-opend == 10){//total boxes = 81 mines = 10 opend has to be 71
                System.out.println("Congratulations you won");
                
            }
    }
    
    //if open a mined box
    public void gameOver() {
        Iterator<Box> it = boxes.iterator();// to check all List elements
        Box box = it.next();//put out null element (index 0)
        while (it.hasNext()) {
            box = it.next();
            //For the rest mined boxes change the icons
            if(box.isMined() && box.isEnabled()){
                box.setIcon(remainingMineIcon);
                box.setDisabledIcon(remainingMineIcon);
            }
            box.setEnabled(false);//make all boxes disable
        }
        System.out.println("Game Over");
        
    }

    @Override    
    public void mouseClicked(MouseEvent e) {
        int index = boxes.indexOf(e.getSource());//get the index of clicked box
        Box box = boxes.get(index);
        //When right click
        if (SwingUtilities.isRightMouseButton(e) ){           
            
            if(box.isEnabled()){         //if box is closed
                
                if(box.isFlaged()){      //and is flaged
                    box.setFlaged(false);//put out the flag
                    box.setIcon(null);   //put out the icon
                    flags++;                //refresh flags plurality
                }
                else if (flags !=0){        //else if there are available flags
                    box.setFlaged(true); //put a flag, set the icon
                    box.setIcon(flagIcon);
                    flags--;                //refresh flags plurality
                }
            }
        }
        //When left click
        else if (SwingUtilities.isLeftMouseButton(e)){
            
            if(box.isEnabled()){
                if (!box.isFlaged()){        //if box is not flaged
                   
                    if(box.isMined()){       //if is mined open it and set the icons
                        box.setEnabled(false);
                        box.setIcon(mineIcon);
                        box.setDisabledIcon(mineIcon);
                        gameOver();
                    }
                    else {
                        openBox(box);        //else call openBox method to open it
                    }               
                    checkIfWins();
                }
            }
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

    