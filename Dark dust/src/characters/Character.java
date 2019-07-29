/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package characters;

import java.awt.Image;

/**
 *
 * @author Matej
 */
public class Character {
    private String name;        //Meno hraca
    private int water;          //Kolko vody ma v zasobe [0-?]
    private int posX;           //Pozicia X [0-4]
    private int posY;           //Pozicia Y [0-4]
    private int numberOfMoves;  //Pocet volnych tahov [0-3]
    
    private Image image;        //Obrazok reprezentujuci hraca

    public Character() {
    }
    
    
}
