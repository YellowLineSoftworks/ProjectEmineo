package control;

import graphics.swing.BufferedJFrame;
import javax.swing.ImageIcon;
import resources.ResolutionCalculator;
import resources.gameobjects.Button;

/**
 *
 * @author Jack
 */
public class EventManager {

    public static GameClock clock;
    
    public static void main(String[] args) {
        clock = new GameClock();
        BufferedJFrame frame = new BufferedJFrame(0, 0, 680, 680, "Emineo");
        frame.centerFrame();
        clock.start(60, frame);
        frame.enableFpsCounter(clock);
    }
    
    public static void start() {
        Button.buttons.clear();
        clock.bufferedDevices[0].clear();
        System.out.println("Started.");
    }
    
    public static void quit() {
        System.exit(0);
    }
    
    public static void options() {
        Button.buttons.clear();
        clock.bufferedDevices[0].clear();
        clock.bufferedDevices[0].drawImage(new ImageIcon(new EventManager().getClass().getResource("/art/map.png")).getImage(), 0, 0, 680, 680);
        clock.bufferedDevices[0].drawImage(new ImageIcon(new EventManager().getClass().getResource("/art/yellowlinesoftworks.png")).getImage(), 220, 640);
        try {
            Button options = new Button(295, 580, new ImageIcon(new EventManager().getClass().getResource("/art/buttons/mainmenu/back.png")).getImage(), 
                    new ImageIcon(new EventManager().getClass().getResource("/art/buttons/mainmenu/backselected.png")).getImage(), 
                    new EventManager().getClass().getMethod("backToMain"),clock.bufferedDevices[0]);
        } catch (Exception e) {
            System.err.println("Problem reaching method \"backToMain\" in class \"Event Manager.\"");
            System.err.println(e.getMessage());
        }
    }
    
    public static void backToMain() {
        Button.buttons.clear();
        clock.bufferedDevices[0].clear();
        try {
            clock.bufferedDevices[0].drawImage(new ImageIcon(new EventManager().getClass().getResource("/art/map.png")).getImage(), 0, 0, 680, 680);
            clock.bufferedDevices[0].drawImage(new ImageIcon(new EventManager().getClass().getResource("/art/yellowlinesoftworks.png")).getImage(), 220, 640);
            clock.bufferedDevices[0].drawImage(new ImageIcon(new EventManager().getClass().getResource("/art/buttons/mainmenu/title.png")).getImage(), 90, 0);
            Button start = new Button(290, 300, new ImageIcon(new EventManager().getClass().getResource("/art/buttons/mainmenu/start.png")).getImage(), 
                    new ImageIcon(new EventManager().getClass().getResource("/art/buttons/mainmenu/startselected.png")).getImage(), 
                    new EventManager().getClass().getMethod("start"),clock.bufferedDevices[0]);
            Button options = new Button(271, 375, new ImageIcon(new EventManager().getClass().getResource("/art/buttons/mainmenu/options.png")).getImage(), 
                    new ImageIcon(new EventManager().getClass().getResource("/art/buttons/mainmenu/optionsselected.png")).getImage(), 
                    new EventManager().getClass().getMethod("options"),clock.bufferedDevices[0]);
            Button quit = new Button(299, 450, new ImageIcon(new EventManager().getClass().getResource("/art/buttons/mainmenu/quit.png")).getImage(), 
                    new ImageIcon(new EventManager().getClass().getResource("/art/buttons/mainmenu/quitselected.png")).getImage(), 
                    new EventManager().getClass().getMethod("quit"),clock.bufferedDevices[0]);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Could not draw images. Quitting.");
            System.exit(1);
        }
    }
    
    //Do not insert additional code into this class. All control code should go into GameClock.
    //Contact Jack or refer to the Viper Engine documentation (under Clock) for usage instructions.
    
}