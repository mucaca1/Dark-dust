/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import com.sun.javafx.geom.Vec2d;
import components.DefaultTerrainCard;
import components.DirectionEnum;
import components.ItemToEscapeCard;
import components.ItemToHelpCard;
import components.TypeOfCardEnum;
import java.util.ArrayList;
import java.util.Collections;
import characters.Character;
import java.awt.Color;

/**
 *
 * @author Matej
 */
public class GameController{
    private ArrayList<DefaultTerrainCard> terrain;
    private ArrayList<Character> players;

    public GameController() {
        terrain = new ArrayList<>();
        players = new ArrayList<>();
        
        
        
        Character r = new Character();
        r.setColor(Color.BLACK);
        Character o = new Character();
        o.setColor(Color.CYAN);
        o.setPlayerID(0);
        o.setXY(new Vec2d(1, 2));
        players.add(o);
        Character g = new Character();
        g.setColor(Color.GREEN);
        g.setPlayerID(1);
        g.setXY(new Vec2d(1, 2));
        players.add(g);
        r.setPlayerID(2);
        r.setXY(new Vec2d(1, 2));
        players.add(r);
        Character b = new Character();
        b.setColor(Color.BLUE);
        b.setPlayerID(3);
        b.setXY(new Vec2d(1, 2));
        players.add(b);
        Character m = new Character();
        m.setColor(Color.RED);
        m.setPlayerID(4);
        m.setXY(new Vec2d(1, 2));
        players.add(m);
        
        
        
        startInit();
    }
    
    private void startInit(){
        int[] a={0,1,2,3,4};
        int[] b={0,1,2,3,4};

        ArrayList<Pair> pairs = new ArrayList<Pair>();
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if( (i== 0 && j == 2) || (i== 1 && j == 1) || (i== 1 && j == 3) ||
                        (i== 2 && j == 0) || (i== 2 && j == 4) || (i== 3 && j == 1) ||
                        (i== 3 && j == 3) || (i== 4 && j == 2)){
                    pairs.add(new Pair(a[i], b[j], true));
                }
                else{
                    pairs.add(new Pair(a[i], b[j]));
                }
                
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
                if(p.isDust()){
                    t.addDust();
                }
            }
            i++;
        } 
    }
    
       
    public void endGame(){
        terrain.clear();
    }

    public ArrayList<DefaultTerrainCard> getTerrain() {
        return terrain;
    }

    public ArrayList<Character> getPlayers() {
        return players;
    }

    
}
