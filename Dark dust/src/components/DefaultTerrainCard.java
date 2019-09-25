/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import com.sun.javafx.geom.Vec2d;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Matej
 */
public abstract class DefaultTerrainCard {
    private int posX;           //Pozicia X [0-4]
    private int posY;           //Pozicia X [0-4]
    
    private int sand;           //Urcuje pocet kolko krat je policko zasypane pieskom [0-2]
    
    private BufferedImage frontSideImage;       //Predna strana karty [prvotne zahalena]
    private BufferedImage backSideImage;        //Zadna strana karty
    
    private BufferedImage sandLight;            //Piesok prvej urovne
    private BufferedImage sandDark;             //Piesok druhj urovne
    
    private boolean isRevealed;         //Urcuje ci bola karta odhalena

    public DefaultTerrainCard(TypeOfCardEnum type, DirectionEnum direction, Vec2d vector) {
        this.isRevealed = StaticSettings.isVisiableAllCards();
        this.sand = 0;
        
        if (vector != null) {
            posX = (int)vector.x;
            posY = (int)vector.y;
        }
        else{
            posX = 0;
            posY = 0;
        }
        
        BufferedImage img = null;
        
        try{
            if(direction != null && direction != DirectionEnum.None){
                img = ImageIO.read(new File(StaticSettings.getPathToPhotos() + "\\Card_" + type + "_" + direction + ".JPG"));
            }
            else{
                img = ImageIO.read(new File(StaticSettings.getPathToPhotos() + "\\Card_" + type + ".JPG"));
            }
            
            this.frontSideImage = img;
            if(type == TypeOfCardEnum.Water || type == TypeOfCardEnum.FakeWater){
                img = ImageIO.read(new File(StaticSettings.getPathToPhotos() + "\\Card_Background_Water.JPG"));
            }
            else{
                img = ImageIO.read(new File(StaticSettings.getPathToPhotos() + "\\Card_Background.JPG"));
            }
            
            this.backSideImage = img;
            img = null;
            System.out.println("DONE: Card Card_" + type + ".JPG load -> done.");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage() + "Card Card_" + type + ".JPG load -> Fail.");
        }
        
        try{
            img = ImageIO.read(new File(StaticSettings.getPathToPhotos() + "\\Card_Light_Dust.PNG"));
            this.sandLight = img;
            
            img = ImageIO.read(new File(StaticSettings.getPathToPhotos() + "\\Card_Dark_Dust.PNG"));
            this.sandDark = img;
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage() + "Sand card load -> Fail.");
        }
    }
    
    public void reveal(){
        this.isRevealed = true;
    }
    
    public void addDust(){
        this.sand++;
    }
    
    public void removeDust(){
        if(this.sand > 0)
            this.sand--;
    }
    
    public boolean isRevealed(){
        return this.isRevealed;
    }
    
    public void paint(Graphics g,int padding, int maxSize){
        if(isRevealed){
            g.drawImage(frontSideImage, posX*padding, posY*padding, maxSize, maxSize, null);
        }
        else{
            g.drawImage(backSideImage, posX*padding, posY*padding, maxSize, maxSize, null);
        }
        
        switch(this.sand){
            case 1:
                g.setColor(new Color(0, 0, 0, 0));
                g.drawImage(sandLight, posX*padding, posY*padding, maxSize/2, maxSize/2, null);
                
                break;
            case 2:
                g.drawImage(sandDark, posX*padding, posY*padding, maxSize/2, maxSize/2, null);
                break;
            default:
                break;
        }
    }
    
    
    public void setXY(Vec2d vector){
        this.posX = (int) vector.x;
        this.posY = (int) vector.y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
    public Vec2d getPosition(){
        return new Vec2d(posX, posY);
    }
    
    public String toString(){
        return "Terrain card,(x:" + posX + ",y:" + posY + "),sand:"+ sand + "";
    }
    
    public boolean isDust(){
        return (this.sand > 0)? true : false; 
    }
}
