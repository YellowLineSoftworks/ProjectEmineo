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
    Image towerUpgradeButtonPressedImage;

    public TowerUpgrade(TowerUpgrades enumeratedUpgrade, Tower tTU) {
        
        super(EventManager.getClock().bufferedDevices[0]);
        towerToUpgrade = tTU;
        level = enumeratedUpgrade.level;
        towerImage = enumeratedUpgrade.towerImage;
        towerUpgradeButtonImage = enumeratedUpgrade.towerUpgradeButtonImage;
        towerUpgradeButtonPressedImage = enumeratedUpgrade.towerUpgradeButtonPressedImage;

    }    

    public static enum TowerUpgrades {

        BASIC_TOWER(1, new ImageIcon(new EventManager().getClass().getResource("/art/buttons/tower/basic.png")).getImage(),
                new ImageIcon(new EventManager().getClass().getResource("/art/buttons/tower/basic.png")).getImage(),
                new ImageIcon(new EventManager().getClass().getResource("/art/buttons/tower/basicpressed.png")).getImage())
        ;
        int level;
        Image towerUpgradeButtonImage;
        Image towerUpgradeButtonPressedImage;
        Image towerImage;

        TowerUpgrades(int l, Image tI, Image tUBI, Image tUBPI) {
            level = l;
            towerImage = tI;
            towerUpgradeButtonImage = tUBI;
            towerUpgradeButtonPressedImage = tUBPI;
        }
        
    }
    
}