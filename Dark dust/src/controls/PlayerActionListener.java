/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Matej
 */
public class PlayerActionListener implements ActionListener{
    GameController gc;
    Container canvases;
    public PlayerActionListener(GameController gameController, Container canvases) {
        gc = gameController;
        this.canvases = canvases;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton b = new JButton();
        
        if(ae.getSource().getClass().equals(b.getClass())){
            b = (JButton) ae.getSource();
            if(!b.isBorderPainted()){
                System.out.println("Unable to do this action!");
                return;
            }
        }
        
        if(gc.getActivePlayer().getNumberOfMoves() <= 0){
            System.out.println("Out of turns!");
            return;
        }
        if("Move".equals(ae.getActionCommand())){
            System.out.println("Action: Move");
            gc.moveAction();
        }
        else if("Dig".equals(ae.getActionCommand())){
            System.out.println("Action: Dig");
            gc.digSand();
        }
        else if("Unkeep".equals(ae.getActionCommand())){
            System.out.println("Action: Unkeep");
            gc.unkeepTerrain();
        }
        else if("Pick up item".equals(ae.getActionCommand())){
            System.out.println("Action: Pick up item");
        }
        
        gc.getActivePlayer().useAction();
        
        for (int i = 0; i < canvases.getComponentCount(); i++) {
            canvases.getComponent(i).repaint();
        }
    }
    
}
