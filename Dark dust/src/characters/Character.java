/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import com.sun.javafx.geom.Vec2d;
import components.StaticSettings;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    private int numberOfMoves;  //Pocet volnych tahov [0-3]
    private Color color;        //farba hraca
    
    private BufferedImage background;        //Pozadie podlozky hraca
    private BufferedImage playerRepresentation;      //figurka reprezentujuca hraca

    public Character() {
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File(StaticSettings.getPathToPlayerPhotos()+ "\\Character_Background.JPG"));
            this.background = img;
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
    
    
    
    public void paint(Graphics g,int padding){
        g.setColor(color);
        int p = padding/5;
        int x = posX * padding + p*playerID;
        int y = posY * padding + p*4;
        Graphics2D ga = (Graphics2D)g;
        ga.setPaint(color);
        ga.fillOval(x,y,p-5,p-5);
    }
    
    public void paintUser(Graphics g){
        g.drawImage(background, 0, 0, null);
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    
    
}
