/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

/**
 *
 * @author Matej
 */
public class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair otherPair = (Pair) obj;
        if (this.getX() != otherPair.getX() || this.getY() != otherPair.getY()) {
            return false;
        }

        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
