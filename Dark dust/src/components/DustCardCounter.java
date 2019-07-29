/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author Matej
 */
public class DustCardCounter{
    private int count;              //Pocet pieku [0-48]

    public DustCardCounter() {
        this.count = 48;
    }
    
    private void checkCount(){
        if(this.count <= 0){
            //you lose game
            System.out.println("TO DO: Lose game");
        }
    }
}
