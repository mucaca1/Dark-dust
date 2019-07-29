/**
 *
 */
package dark.dust;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Matej
 */
public class DarkDust {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame application = new JFrame("Dark Dust");
        
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        application.setSize(1280, 720);
        
        application.setVisible(true);
    }
    
}
