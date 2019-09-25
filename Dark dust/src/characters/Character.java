/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import com.sun.javafx.geom.Vec2d;
import components.Card;
import components.StaticSettings;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Matej
 */
public class Character {
    private int playerID;       //id hraca [0-4]
    private String name;        //Meno hraca
    private int water;          //Kolko vody ma v zasobe [0-?]
    private int maxWater;        //Kolko maximalne vody vie odniest
    private int posX;           //Pozicia X [0-4]
    private int posY;           //Pozicia Y [0-4]
    private int numberOfMoves;  //Pocet volnych tahov [0-4]
    private Color color;        //farba hraca
    
    private BufferedImage background;        //Pozadie podlozky hraca
    
    private ArrayList<Card> cards;

    public Character(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(StaticSettings.getPathToPlayerPhotos()+ "\\Character_Background.JPG"));
            this.background = img;
            System.out.println("DONE: Card Character_Background.JPG load -> done.");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage() + "Character background -> Fail.");
        }
    }
    
    public void setXY(Vec2d vector){
        this.posX = (int) vector.x;
        this.posY = (int) vector.y;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public Vec2d getPosition(){
        return new Vec2d(posX, posY);
    }

    public int getNumberOfMoves() {
        return numberOfMoves;
    }
    
    public void useAction(){
        if(this.numberOfMoves <= 0){
            return;
        }
        else{
            this.numberOfMoves--;
        }
    }

    public int getPlayerID() {
        return playerID;
    }
    
    
    
    public void startPlayerTurn(){
        this.numberOfMoves = 4;
    }
    
    public void paint(Graphics g,int padding){
        g.setColor(color);
        int p = padding/5;
        int x = posX * padding + p*playerID;
        int y = posY * padding + p*4;
        Graphics2D ga = (Graphics2D)g;
        ga.setPaint(color);
        ga.fillOval(x,y,p-5,p-5);
    }
    
    public void paintUser(Graphics g, int xMax, int yMax){
        Graphics2D ga = (Graphics2D)g;
        g.drawImage(background, 0, 0, xMax, yMax, null);
        ga.setColor(color);
        
        int x = xMax / 30;
        int y = yMax / 23;
        
        int fontSize = y*2;
        ga.fillOval(x, y, x*2, x*2);
        g.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, fontSize));
        g.drawString(name, x*4, y*2);
        
        
        ga.setColor(Color.BLACK);
        g.setFont(new Font("SERIF", Font.PLAIN | Font.BOLD, fontSize/2));
        String text = "Wather\n" + this.water + " / " + this.maxWater;
        int yNewLine = yMax / 2;
        for (String line : text.split("\n")){
            g.drawString(line, x*2, yNewLine += g.getFontMetrics().getHeight());
        }
        
        
        text = "Steps\n" + this.numberOfMoves;
        yNewLine = (yMax / 2) + (yMax / 4);
        for (String line : text.split("\n")){
            g.drawString(line, x*2, yNewLine += g.getFontMetrics().getHeight());
        }
        
        text = "Info o slecialnych\nAbilitach\nktore\tu \nbudu";
        yNewLine = (yMax / 2) - (yMax / 4);
        for (String line : text.split("\n")){
            g.drawString(line, xMax/2, yNewLine += g.getFontMetrics().getHeight());
        }
    }
    
    public void paintMinuature(Graphics g, int x, int y, int xMax, int yMax){
        int fontSize = 10;
        g.setColor(color);
        g.fillRect(x, y, xMax, yMax);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, fontSize));
        g.drawString(name, x + ((xMax-x)/10), y - ((yMax - y)/3));
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    
    public void addItemCard(Card itemCard){
        this.cards.add(itemCard);
    }
    
}
