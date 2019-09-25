/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Matej
 */
public class Card {
    private BufferedImage background;
    private BufferedImage cardImage;

    public Card(int initCard) {
        BufferedImage img = null;
        
        try{
            if(initCard == 1){
                img = ImageIO.read(new File(StaticSettings.getPathToPhotos() + "\\Card_Storm.JPG"));
            }
            else{
                img = ImageIO.read(new File(StaticSettings.getPathToPhotos() + "\\Card_EquipmentCard.JPG"));
            }
            
            this.background = img;
            
            System.out.println("DONE: Card load -> done.");
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage() + "Card load -> Fail.");
        }
    }
    
    public void paint(Graphics g){
        g.drawImage(background, 0, 0, null);
    }
    
}
