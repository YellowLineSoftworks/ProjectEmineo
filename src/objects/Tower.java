
package objects;

import control.EventManager;
import java.awt.Image;
import resources.GameObject;
import resources.Sprite;

/**
 *
 * @author austinletson
 */
public class Tower extends GameObject{

    int level = 0;

    public Tower(int x, int y, Image image){
        super(x, y, x+40, y+40, new Image[] {image}, EventManager.getClock().bufferedDevices[0]);
    }

    /**
     * upgradesTower
     */

    public void upgradeTower(TowerUpgrade towerUpgrade){
        level = towerUpgrade.level;
        //setimage to  tower ugraade image

    }


}
