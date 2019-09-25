/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import controls.GameController;
import java.awt.Canvas;
import java.awt.Graphics;
import characters.Character;
import java.awt.Dimension;

/**
 *
 * @author Matej
 */
public class PlayerCanvas extends Canvas{
    private GameController gc;

    public PlayerCanvas(GameController gc) {
        super();
        this.gc = gc;
    }
    
    
    public void paint(Graphics g){
        Character ch = gc.getActivePlayer();
        
        int x = getWidth()/ 3;
        int y = x + (getHeight()/6);
        
        ch.paintUser(g, x, y);
        
        Dimension min = new Dimension();
        Dimension max = new Dimension();
        
        //min.height = x 
        
        /*for(Character c : gc.getPlayers()){
            if (ch != c){
                c.paintMinuature(g, x, y, x, y);
            }
        }*/
    }
}
