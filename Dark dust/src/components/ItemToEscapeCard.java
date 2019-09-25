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
public class ItemToEscapeCard extends DefaultTerrainCard{
    private DirectionEnum direction;        //Urcuje ktorym smerom karta ukazuje
    
    private TypeOfCardEnum type;                  //Urcuje konkretny typ karty

    public ItemToEscapeCard(TypeOfCardEnum type, DirectionEnum direction, Vec2d vector){
        super(type, direction, vector);
        this.type = type;
        this.direction = direction;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public TypeOfCardEnum getType() {
        return type;
    }
    
    
    public void paint(){
        
    }
}
