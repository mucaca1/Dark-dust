/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import com.sun.javafx.geom.Vec2d;

/**
 *
 * @author Matej
 */
public class ItemToHelpCard extends DefaultTerrainCard{
    private TypeOfCardEnum type;       //Typ karty

    public ItemToHelpCard(TypeOfCardEnum type, Vec2d vector) {
        super(type, null, vector);
        this.type = type;
    }
}