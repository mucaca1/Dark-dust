/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Matej
 */
public abstract class DefaultTerrainCard {
    private int posX;           //Pozicia X [0-4]
    private int posY;           //Pozicia X [0-4]
    
    private int sand;           //Urcuje pocet kolko krat je policko zasypane pieskom [0-2]
    
    private Image frontSideImage;       //Predna strana karty [prvotne zahalena]
    private Image backSideImage;        //Zadna strana karty
    
    private boolean isRevealed;         //Urcuje ci bola karta odhalena

    public DefaultTerrainCard() {
        this.isRevealed = Boolean.FALSE;
    }
    
    public void paint(Graphics g){
        if(isRevealed){
            g.drawImage(frontSideImage, posX, posX, null);
        }
        else{
            g.drawImage(backSideImage, posX, posX, null);
        }
    }
}
