/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import com.sun.javafx.geom.Vec2d;
import components.DirectionEnum;
import components.ItemToEscapeCard;
import components.ItemToHelpCard;
import components.TypeOfCardEnum;
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
    /*ItemToHelpCard card;
    ItemToEscapeCard card1;
    ItemToHelpCard card2;
    ItemToEscapeCard card3;
    ItemToEscapeCard card4;
    ItemToHelpCard card5;
    ItemToEscapeCard card6;
    ItemToEscapeCard card7;
    ItemToEscapeCard card8;
    ItemToHelpCard card9;*/
    
    public DarkDustFrame(){
        this.setTitle("Dark Dust");
        this.setSize(1280, 720);            //size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(new DesertCanvas());
        
        /*card = new ItemToHelpCard(TypeOfCardEnum.Cave, null);
        card1 = new ItemToEscapeCard(TypeOfCardEnum.Compass, DirectionEnum.Horizontal, new Vec2d(400, 0));
        card2 = new ItemToHelpCard(TypeOfCardEnum.Components, new Vec2d(800, 0));
        card3 = new ItemToEscapeCard(TypeOfCardEnum.Engine, DirectionEnum.Vertical, new Vec2d(0, 400));
        card4 = new ItemToEscapeCard(TypeOfCardEnum.Exit, DirectionEnum.None, new Vec2d(400, 400));
        card5 = new ItemToHelpCard(TypeOfCardEnum.FakeWater, new Vec2d(1600, 000));
        card6 = new ItemToEscapeCard(TypeOfCardEnum.Helm, DirectionEnum.Vertical, new Vec2d(800, 400));
        card7 = new ItemToEscapeCard(TypeOfCardEnum.Propeller, DirectionEnum.Vertical, new Vec2d(1200, 000));
        card8 = new ItemToEscapeCard(TypeOfCardEnum.Start, DirectionEnum.None, new Vec2d(1200, 400));
        card9 = new ItemToHelpCard(TypeOfCardEnum.Water, new Vec2d(1600, 400));*/
        
        this.setVisible(true);
        
    }
    
    
    public void paint(Graphics g){
        
        /*BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src\\Imges\\BoardGameCards\\Card_components_cave.JPG"));
        } catch (IOException e) {
            System.out.println("Exception " + e.getMessage());
        }
        g.drawImage(img, 0, 0, 200, 200, this);*/
        /*card.paint(g);
        card1.paint(g);
        card2.paint(g);
        card3.paint(g);
        card4.paint(g);
        card5.paint(g);
        card6.paint(g);
        card7.paint(g);
        card8.paint(g);
        card9.paint(g);*/
    }
}
