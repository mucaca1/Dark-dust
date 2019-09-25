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
import characters.Storm;
import components.DustCardCounter;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

/**
 *
 * @author Matej
 */
public class GameController{
    private ArrayList<DefaultTerrainCard> terrain;
    private ArrayList<Character> players;
    
    private Storm storm;
    
    private DustCardCounter dustCounter;
    
    private Character activePlayer;
    
    private JButton[] buttons;
    
    private DefaultTerrainCard selectedTerrain;

    public GameController() {
        terrain = new ArrayList<>();
        players = new ArrayList<>();
        dustCounter = new DustCardCounter();
        storm = new Storm(0);
        selectedTerrain = null;
        
        
        Character r = new Character("Alfonz");
        r.setColor(Color.BLACK);
        Character o = new Character("Anca");
        o.setColor(Color.CYAN);
        o.setPlayerID(0);
        o.setXY(new Vec2d(1, 2));
        players.add(o);
        Character g = new Character("Karol");
        g.setColor(Color.GREEN);
        g.setPlayerID(1);
        g.setXY(new Vec2d(1, 2));
        players.add(g);
        r.setPlayerID(2);
        r.setXY(new Vec2d(1, 2));
        players.add(r);
        Character b = new Character("Oto");
        b.setColor(Color.BLUE);
        b.setPlayerID(3);
        b.setXY(new Vec2d(1, 2));
        players.add(b);
        Character m = new Character("Fero");
        m.setColor(Color.RED);
        m.setPlayerID(4);
        m.setXY(new Vec2d(1, 2));
        players.add(m);
        
        
        
        startInit();
    }

    public DefaultTerrainCard getSelectedTerrain() {
        return selectedTerrain;
    }

    public void setSelectedTerrain(DefaultTerrainCard selectedTerrain) {
        this.selectedTerrain = selectedTerrain;
    }

    
    
    
    
    private void startGame(){
        activePlayer = players.get(0);
        activePlayer.startPlayerTurn();
        activePlayer = players.get((int)(activePlayer.getPlayerID() % players.size()));
    }
    
    private void nextTurn(){
        activePlayer = players.get((int)(activePlayer.getPlayerID() % players.size()));
        activePlayer.startPlayerTurn();
    }
    
    public void moveAction(){
        activePlayer.setXY(selectedTerrain.getPosition());
        buttonsPermission(checkActions());
    }
    
    public void digSand(){
        selectedTerrain.removeDust();
        buttonsPermission(checkActions());
        dustCounter.addCounter();
    }
    
    public void unkeepTerrain(){
        selectedTerrain.reveal();
        buttonsPermission(checkActions());
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
                    dustCounter.removeCounter();
                }
            }
            i++;
        } 
        
        startGame();
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
    
    public Character getActivePlayer(){
        return activePlayer;
    }

    public Storm getStorm() {
        return storm;
    }

    public void drawItemCard(){
        
    }
    
    public void buttonsPermission(Map<String,Boolean >buttonActionPermission){
        if(buttonActionPermission == null){
            for (int i = 0; i < this.buttons.length; i++) {
                this.buttons[i].setBorderPainted(false);
            }
        }
        else{
            this.buttons[0].setBorderPainted(buttonActionPermission.get("move"));
            this.buttons[1].setBorderPainted(buttonActionPermission.get("dig"));
            this.buttons[2].setBorderPainted(buttonActionPermission.get("unkeep"));
            this.buttons[3].setBorderPainted(buttonActionPermission.get("pickUpItem"));
        }
        
    }
    
    public void addButtons(Component[] buttons){
        
        this.buttons = new JButton[buttons.length];
        
        for (int i = 0; i < buttons.length; i++) {
            this.buttons[i] = (JButton) buttons[i];
        }
    }
    
        public Map checkActions(){
        if(getSelectedTerrain() == null){
            return null;
        }
        Vec2d pPos = getActivePlayer().getPosition();
        Vec2d cPos = getSelectedTerrain().getPosition();
        
        Vec2d diferencePosition = new Vec2d(pPos.x - cPos.x, pPos.y - cPos.y);
        
        Map<String, Boolean> actions = new HashMap();
        if(((diferencePosition.x*diferencePosition.x) + (diferencePosition.y*diferencePosition.y)) > 1){
            //move false
            actions.put("move", Boolean.FALSE);
        }
        else{
            //move true
            actions.put("move", Boolean.TRUE);
        }
        
        if((((diferencePosition.x*diferencePosition.x) + (diferencePosition.y*diferencePosition.y)) < 2 ) && selectedTerrain.isDust()){
            //move true
            actions.put("dig", Boolean.TRUE);
        }
        else{
            //move false
            actions.put("dig", Boolean.FALSE);
        }
        
        if((diferencePosition.x == 0) && (diferencePosition.y == 0) && !getSelectedTerrain().isDust() && !getSelectedTerrain().isRevealed()){
            //unkeep true
            actions.put("unkeep", Boolean.TRUE);
        }
        else{
            //unkeep false
            actions.put("unkeep", Boolean.FALSE);
        }
        
        
        ArrayList<DefaultTerrainCard> terrain = getTerrain();
        
        TypeOfCardEnum cardTypes[] = new TypeOfCardEnum[]{TypeOfCardEnum.Compass,TypeOfCardEnum.Engine, TypeOfCardEnum.Helm, TypeOfCardEnum.Propeller};
        
        ArrayList<ItemToEscapeCard> canPickUp = new ArrayList();
        for (int i = 0; i < cardTypes.length; i++) {
            for(DefaultTerrainCard t : terrain){
                if(t instanceof ItemToEscapeCard && t.isRevealed()){
                    ItemToEscapeCard item = (ItemToEscapeCard) t;
                    if(item.getType() == cardTypes[i]){
                        canPickUp.add(item);
                    }
                }
            }
        }
        
        actions.put("pickUpItem", Boolean.FALSE);
        
        for (int i = 0; i < canPickUp.size()-1; i++) {
            if(canPickUp.get(i).getType() == canPickUp.get(i+1).getType()){
                //mam dva typy kariet
                double y = (canPickUp.get(i).getDirection() == DirectionEnum.Horizontal) ? canPickUp.get(i).getPosY() : canPickUp.get(i+1).getPosY();
                double x = (canPickUp.get(i).getDirection() == DirectionEnum.Vertical) ? canPickUp.get(i).getPosX() : canPickUp.get(i+1).getPosX();
                Vec2d itemPos = new Vec2d(x, y);
                if(pPos.equals(itemPos)){
                    actions.put("pickUpItem", Boolean.TRUE);
                    break;
                }
            }
        }
        
        return actions;
    }
}
