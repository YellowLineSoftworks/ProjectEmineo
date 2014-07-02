package objects;

import control.EventManager;
import resources.GameObject;

import javax.swing.*;
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

        BASIC_TOWER(1, new ImageIcon(new TowerUpgrade(null, null).getClass().getResource("/art/buttons/mainmenu/startselected.png")).getImage(),
                new ImageIcon(new TowerUpgrade(null, null).getClass().getResource("/art/buttons/mainmenu/startselected.png")).getImage())

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
