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
    
    public boolean removeCounter(){
        if(--count < 0){
            return false;
        }
        return true;
    }
    
    public void addCounter(){
        count++;
    }
}
