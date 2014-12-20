package objects;

import control.EventManager;
import resources.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

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
            towerImage = new BufferedImage(tI.getWidth(null)/2, tI.getHeight(null)/2, BufferedImage.TYPE_INT_ARGB);
            towerImage.getGraphics().drawImage(tUBPI, l, id, null);
            Image tile = new ImageIcon(new EventManager().getClass().getResource("/art/buttons/tower/tile.png")).getImage();
            Image tilePressed = new ImageIcon(new EventManager().getClass().getResource("/art/buttons/tower/tilepressed.png")).getImage();
            BufferedImage finalTile = new BufferedImage(tile.getWidth(null), tile.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            finalTile.getGraphics().drawImage(tile, 0, 0, null);
            finalTile.getGraphics().drawImage(tUBI, 10, 10, tile.getWidth(null) - 10, tile.getHeight(null) - 30, 0,0, tUBI.getWidth(null), tUBI.getHeight(null),  null);
            towerUpgradeButtonImage = finalTile;
            BufferedImage finalTilePressed = new BufferedImage(tilePressed.getWidth(null), tilePressed.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            finalTilePressed.getGraphics().drawImage(tilePressed, 0, 0, null);
            finalTilePressed.getGraphics().drawImage(tUBPI, 10, 10, tilePressed.getWidth(null) - 10, tilePressed.getHeight(null) - 30, 0, 0, tUBPI.getWidth(null), tUBPI.getHeight(null), null);
            towerUpgradeButtonPressedImage = finalTilePressed;
        }
        
    }
    
}