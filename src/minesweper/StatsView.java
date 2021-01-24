/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Βασίλης
 * 
 * This class will be the grafic of Stats view
 */
public class StatsView extends JPanel{
    
    private ArrayList<Player> players = new ArrayList<>();
    private Path path;
    private File scores;

    public StatsView() {
        
        path = Paths.get("saves/scores.saves");        
        
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        setPreferredSize(new Dimension(225, 250));
        
        LoadScores();
        
        
    }
    
    public void LoadScores () {
        
        try {
            scores = new File("saves/scores.saves");
            if(!scores.exists())
                scores.createNewFile();
            ObjectInputStream input = new ObjectInputStream(Files.newInputStream(path));
            
            for(int i=1; i<=10; i++) {
                Player player = (Player) input.readObject();
                players.add(player);       
                
            }
            
        }
        catch (ClassNotFoundException ex) {
            System.err.println("Invalid object type.");
        }
        catch(EOFException endofFileException) {
            
            System.out.printf("%nNo more records%n");            
        } 
        catch (IOException ex) {
           System.err.println("Error reading from file.");
        }
        
        players.sort((Player p1, Player p2) -> {
            return p1.getScore()-p2.getScore();
        });
        addPlayersToPanel();
        
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    void checkHighScores(int count) {
       
        int record = count;
        if(players.size()<10)
            players.add(new Player(JOptionPane.showInputDialog("Enter youe Name"), record));
        else if(players.get(9).getScore() > record)
                    players.add(new Player(JOptionPane.showInputDialog("Enter youe Name"), record));
        
        players.sort((Player p1, Player p2) -> {
            return p1.getScore()-p2.getScore();
        });
        if(players.size() > 10)
            players.remove(10);
        ObjectOutputStream output;
        try {
            output = new ObjectOutputStream(Files.newOutputStream(path));
            for(Player p : players)
                output.writeObject(p);
        } catch (IOException ex) {
            System.err.println("Error opening file.");
        }
        addPlayersToPanel();
        
    }

    private void addPlayersToPanel() {
        this.removeAll();
        this.repaint();
        JLabel label = new JLabel();
        label.setText("******Best Scores******");
        
        add(label); 
        for(Player p : players){
           label = new JLabel();
           label.setText(players.indexOf(p)+1+") Player Name: "+p.getName()+" time record: "+p.getScore()+"''");
           
           add(label); 
        }
    }
   
    
}
