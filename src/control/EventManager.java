package control;

import graphics.swing.BufferedJFrame;

/**
 *
 * @author Jack
 */
public class EventManager {

    public static void main(String[] args) {
        GameClock clock = new GameClock();
        BufferedJFrame frame = new BufferedJFrame(0,0,680,680,"Emineo");
        frame.centerFrame();
        clock.start(60, frame);
        frame.enableFpsCounter(clock);
    }
    
    //Do not insert additional code into this class. All control code should go into GameClock.
    //Contact Jack or refer to the Viper Engine documentation (under Clock) for usage instructions.
    
}
