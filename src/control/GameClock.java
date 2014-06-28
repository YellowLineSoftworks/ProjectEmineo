package control;

import game.Clock;
import javax.swing.ImageIcon;
import resources.gameobjects.Button;

/**
 * @author Jack
 */
public class GameClock extends Clock {
    
    public void init() {
        try {
            bufferedDevices[0].drawImage(new ImageIcon(getClass().getResource("/art/map.png")).getImage(), 0, 0, 680, 680);
            bufferedDevices[0].drawImage(new ImageIcon(getClass().getResource("/art/yellowlinesoftworks.png")).getImage(), 220, 640);
            bufferedDevices[0].drawImage(new ImageIcon(getClass().getResource("/art/buttons/mainmenu/title.png")).getImage(), 90, 0);
            Button start = new Button(290, 300, new ImageIcon(getClass().getResource("/art/buttons/mainmenu/start.png")).getImage(), 
                    new ImageIcon(getClass().getResource("/art/buttons/mainmenu/startselected.png")).getImage(), 
                    new EventManager().getClass().getMethod("start"),bufferedDevices[0]);
            Button options = new Button(271, 375, new ImageIcon(getClass().getResource("/art/buttons/mainmenu/options.png")).getImage(), 
                    new ImageIcon(getClass().getResource("/art/buttons/mainmenu/optionsselected.png")).getImage(), 
                    new EventManager().getClass().getMethod("options"),bufferedDevices[0]);
            Button quit = new Button(299, 450, new ImageIcon(getClass().getResource("/art/buttons/mainmenu/quit.png")).getImage(), 
                    new ImageIcon(getClass().getResource("/art/buttons/mainmenu/quitselected.png")).getImage(), 
                    new EventManager().getClass().getMethod("quit"),bufferedDevices[0]);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Could not draw images. Quitting.");
            System.exit(1);
        }
    }
    
    public void tick() {
        
    }
    
}