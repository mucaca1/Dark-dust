/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dark.dust;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Matej
 */
public class DarkDustFrame extends JFrame{
    
    
    public DarkDustFrame(){
        this.setTitle("Dark Dust");
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    public void paint(Graphics g){
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src\\Imges\\BoardGameCards\\Card_components_cave.JPG"));
        } catch (IOException e) {
            System.out.println("Exception " + e.getMessage());
        }
        g.drawImage(img, 0, 0, 200, 200, this);
    }
}
