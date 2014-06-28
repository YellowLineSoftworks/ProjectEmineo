
package objects;

import control.EventManager;
import java.awt.Image;
import resources.GameObject;

/**
 *
 * @author austinletson
 */
public class TowerLocation extends GameObject{
    
    public TowerLocation(int x, int y, Image image){
        super(x, y, x+40, y+40, new Image[] {image}, EventManager.clock.bufferedDevices[0]);
    }
}
