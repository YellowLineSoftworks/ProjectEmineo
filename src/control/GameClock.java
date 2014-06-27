package control;

import game.Clock;
import java.io.File;
import javax.swing.ImageIcon;

/**
 * @author Jack
 */
public class GameClock extends Clock {
    
    public void init() {
        try {
            bufferedDevices[0].drawImage(new ImageIcon(getClass().getResource("/art/map.png")).getImage(), 0, 0, 680, 680);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Could not draw images. Quitting.");
            System.exit(1);
        }
    }
    
    public void tick() {
        
    }
    
}