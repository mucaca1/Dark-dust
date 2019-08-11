/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import com.sun.javafx.geom.Vec2d;
import components.DefaultTerrainCard;
import components.DirectionEnum;
import components.ItemToEscapeCard;
import components.ItemToHelpCard;
import components.TypeOfCardEnum;
import controls.GameController;
import controls.Pair;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import characters.Character;

/**
 *
 * @author Matej
 */
public class DesertCanvas extends Canvas implements MouseListener, MouseMotionListener{
    private GameController gc;
    
    private DefaultTerrainCard selectedTerrain;
    
    public DesertCanvas(GameController gc) {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.gc = gc;
        this.selectedTerrain = null;
    }

    public void paint(Graphics g){
        System.out.println("W: " + getWidth() + " H: " + getHeight());
        int maxSize;
        if(getWidth() > getHeight()){
            maxSize = getHeight()/5;
        }
        else{
            maxSize = getWidth()/5;
        }
        for(DefaultTerrainCard t : gc.getTerrain()){
            t.paint(g,maxSize, maxSize-5);
            if(t.equals(selectedTerrain)){
                g.setColor(Color.green);
                g.drawLine(t.getPosX()*maxSize, t.getPosY()*maxSize, t.getPosX()*maxSize + maxSize - 5, t.getPosY()*maxSize + maxSize - 5);
            }
        }
        for(Character c : gc.getPlayers()){
            c.paint(g, maxSize);
        }
    }    

    @Override
    public void mouseClicked(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        
        int maxSize;
        if(getWidth() > getHeight()){
            maxSize = getHeight()/5;
        }
        else{
            maxSize = getWidth()/5;
        }
        this.selectedTerrain = null;
        for(DefaultTerrainCard t : gc.getTerrain()){
            if(x > t.getPosX()*maxSize && x < ((t.getPosX()*maxSize) + maxSize - 5)
                    && y >= t.getPosY()*maxSize && y <= (t.getPosY()*maxSize + maxSize - 5)){
                System.out.println(t.toString());
                this.selectedTerrain = t;
            }
        }
        System.out.println(maxSize);
        System.out.println(me.paramString());
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
