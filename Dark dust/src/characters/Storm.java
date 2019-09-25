/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import components.StaticSettings;
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
public class Storm {
    private int posX;           //Pozicia X [0-4]
    private int posY;           //Pozicia Y [0-4]
    
    private int strong;         //Sila burky
    
    private BufferedImage image;        //Obrazok reprezentujuci burku

    public Storm(int initDificult) {
        BufferedImage img;
        try{
            img = ImageIO.read(new File(StaticSettings.getPathToPhotos() + "\\Card_tornado.jpg"));
            this.image = img;
            System.out.println("DONE: Storm Card load -> done.");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage() + "Tornado card load -> Fail.");
        }
        
        this.posX = 2;
        this.posY = 2;
        
        this.strong = initDificult;
    }
    
    public void paint(Graphics g,int padding, int maxSize){
        g.drawImage(image, posX*padding, posY*padding, maxSize, maxSize, null);
    }
}
