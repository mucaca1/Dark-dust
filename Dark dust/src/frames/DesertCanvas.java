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
import controls.Pair;
import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Matej
 */
public class DesertCanvas extends Canvas{
    private ArrayList<DefaultTerrainCard> terrain;

    public DesertCanvas() {
        super();
        terrain = new ArrayList<>();
        
        startInit();
    }
    
    public void startInit(){
        Random randomGenerator = new Random();

        int[] a={0,1,2,3,4};
        int[] b={0,1,2,3,4};

        ArrayList<Pair> pairs = new ArrayList<Pair>();
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                pairs.add(new Pair(a[i], b[j]));
            }
        }
        Collections.shuffle(pairs);
        
        terrain.add(new ItemToHelpCard(TypeOfCardEnum.Cave, null));
        terrain.add(new ItemToHelpCard(TypeOfCardEnum.Cave, null));
        
        terrain.add(new ItemToEscapeCard(TypeOfCardEnum.Compass, DirectionEnum.Horizontal, null));
        terrain.add(new ItemToEscapeCard(TypeOfCardEnum.Compass, DirectionEnum.Vertical, null));
        
        terrain.add(new ItemToEscapeCard(TypeOfCardEnum.Engine, DirectionEnum.Horizontal, null));
        terrain.add(new ItemToEscapeCard(TypeOfCardEnum.Engine, DirectionEnum.Vertical, null));
        
        terrain.add(new ItemToEscapeCard(TypeOfCardEnum.Helm, DirectionEnum.Horizontal, null));
        terrain.add(new ItemToEscapeCard(TypeOfCardEnum.Helm, DirectionEnum.Vertical, null));
        
        terrain.add(new ItemToEscapeCard(TypeOfCardEnum.Propeller, DirectionEnum.Horizontal, null));
        terrain.add(new ItemToEscapeCard(TypeOfCardEnum.Propeller, DirectionEnum.Vertical, null));
        
        terrain.add(new ItemToEscapeCard(TypeOfCardEnum.Start, DirectionEnum.None, null));
        terrain.add(new ItemToEscapeCard(TypeOfCardEnum.Exit, DirectionEnum.None, null));
        
        terrain.add(new ItemToHelpCard(TypeOfCardEnum.Water, null));
        terrain.add(new ItemToHelpCard(TypeOfCardEnum.FakeWater, null));
        terrain.add(new ItemToHelpCard(TypeOfCardEnum.FakeWater, null));
        
        for (int i = 0; i < 10; i++) {
            terrain.add(new ItemToHelpCard(TypeOfCardEnum.Components, null));
        }
        
        System.out.println("Terrain count: " + terrain.size());
        int i = 0;
        System.out.println(pairs.size());
        for(DefaultTerrainCard t : terrain){
            
            Pair p = pairs.get(i);
            System.out.println(i + " [X: " + p.getX() + ", Y: " + p.getY() + "]");
            if(!(p.getX() == 2 && p.getY() == 2)){
                t.setXY(new Vec2d((double)p.getX(), (double)p.getY()));
            }
            
            i++;
        }
    }
    
    public void endGame(){
        terrain.clear();
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
        for(DefaultTerrainCard t : terrain){
            t.paint(g,maxSize + 5 , maxSize);
        }
    }
}
