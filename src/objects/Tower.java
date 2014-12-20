package objects;

import control.EventManager;
import resources.GameObject;
import resources.gameobjects.*;
import resources.gameobjects.Button;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import objects.TowerUpgrade;

/**
 * @author austinletson
 */
public class Tower extends GameObject {

    int level = 0;
    static List<Button> towerUpgradeButtons;
    TowerUpgrade currentUpgrade;
    private static boolean upgradesDisplayed = false;

    public Tower(int x, int y, Image image) {
        
        super(x, y, x + 40, y + 40, new Image[]{image}, EventManager.getClock().bufferedDevices[0]);
        try {
            addFunctionOnClick(this.getClass().getMethod("displayTowerUpgrades"), new Object[]{}, this);
        } catch (NoSuchMethodException e) {
            System.err.println(e.getMessage());
        }

    }

    public void upgradeTower(TowerUpgrade towerUpgrade) {
        
        level = towerUpgrade.level;
        this.changeSprites(new Image[]{towerUpgrade.towerImage});
        currentUpgrade = towerUpgrade;
        for(int i = 0; i<towerUpgradeButtons.size();i++){
            towerUpgradeButtons.get(i).destroy();
        }
        upgradesDisplayed = false;

    }

    public void displayTowerUpgrades(){
        if (!upgradesDisplayed) {
            towerUpgradeButtons = new ArrayList();
            int counter = 0;
            TowerUpgrade.TowerUpgrades[] possibleEnumerations = TowerUpgrade.TowerUpgrades.class.getEnumConstants();
            List<TowerUpgrade.TowerUpgrades> displayedEnumerations = new ArrayList();
            for(int i = 0; i < possibleEnumerations.length; i++){
                if(possibleEnumerations[i].level == level + 1){
                    displayedEnumerations.add(possibleEnumerations[i]);
                }
            }
            //Deterine X and Y
            for (TowerUpgrade.TowerUpgrades upgrade : displayedEnumerations) {
                try {
                    Image img = upgrade.towerUpgradeButtonImage;
                    int x = location.x - (img.getWidth(null)-40)/2;
                    int y = location.y + 50;
                    towerUpgradeButtons.add(new Button(x, y, upgrade.towerUpgradeButtonImage, upgrade.towerUpgradeButtonPressedImage,
                        Tower.class.getDeclaredMethod("upgradeTower", TowerUpgrade.class),
                        this, new Object[] {new TowerUpgrade(upgrade, this)}, EventManager.getClock().bufferedDevices[0]));
                } catch(Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
            }
            upgradesDisplayed = true;
        } else {
            for(int i = 0; i<towerUpgradeButtons.size();i++){
                towerUpgradeButtons.get(i).destroy();
            }
            upgradesDisplayed = false;
            displayTowerUpgrades();
        }
    }

}
