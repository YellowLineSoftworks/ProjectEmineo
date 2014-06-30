package objects;

import control.EventManager;
import resources.GameObject;

import java.awt.*;

/**
 * Created by austinletson on 6/28/14.
 */
public class TowerUpgrade extends GameObject {


    Tower towerToUpgrade;
    int level;
    Image towerImage;
    Image towerUpgradeButtonImage;


    public TowerUpgrade(TowerUpgrades enumeratedUpgrade, Tower tTU) {
        super(EventManager.getClock().bufferedDevices[0]);
        towerToUpgrade = tTU;
        level = enumeratedUpgrade.level;
        towerImage = enumeratedUpgrade.towerImage;
        towerUpgradeButtonImage = enumeratedUpgrade.towerUpgradeButtonImage;

        try {
            addFunctionOnClick(Tower.class.getMethod("upgradeTower", TowerUpgrade.class), new Object[] {this}, tTU);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    public enum TowerUpgrades {

        ;
        int level;
        Image towerUpgradeButtonImage;
        Image towerImage;

        TowerUpgrades(int l, Image tI, Image tUBI) {
            level = l;
            towerImage = tI;
            towerUpgradeButtonImage = tUBI;
        }
    }
}
