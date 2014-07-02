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
    List<Button> towerUpgradeButtons;


    TowerUpgrade currentUpgrade;

    public Tower(int x, int y, Image image) {
        super(x, y, x + 40, y + 40, new Image[]{image}, EventManager.getClock().bufferedDevices[0]);

        try {

            addFunctionOnClick(this.getClass().getMethod("displayTowerUpgrades"), new Object[]{}, this);
        } catch (NoSuchMethodException e) {
            System.err.println(e.getMessage());
        }



    }

    /**
     * upgradesTower
     */

    public void upgradeTower(TowerUpgrade towerUpgrade) {
        level = towerUpgrade.level;
        this.changeSprites(new Image[]{towerUpgrade.towerImage});
        currentUpgrade = towerUpgrade;
        for(int i = 0; i<towerUpgradeButtons.size();i++){
            towerUpgradeButtons.get(i).destroy();
        }

    }


    public void displayTowerUpgrades(){
        towerUpgradeButtons = new ArrayList();
        int counter = 0;
        int x = 0;
        int y = 0;

        TowerUpgrade.TowerUpgrades[] possibleEnumerations = TowerUpgrade.TowerUpgrades.class.getEnumConstants();

        for(int i = 0; i < possibleEnumerations.length; i++){
            System.out.println();
            if(possibleEnumerations[i].level == level + 1){
                switch(counter){
                    case 0:
                        x = location.x;
                        y = location.y - 20;
                        break;
                    case 1:
                        x = location.x - 20;
                        y = location.y - 10;
                    case 2:
                        x = location.x + 20;
                        y = location.x -10;


                }
                try {
                    towerUpgradeButtons.add(new Button(x, y, possibleEnumerations[i].towerImage, possibleEnumerations[i].towerImage,
                            Tower.class.getDeclaredMethod( "upgradeTower", TowerUpgrade.class),
                            this, new Object[] {new TowerUpgrade(possibleEnumerations[i], this)}, EventManager.getClock().bufferedDevices[0]));

                }catch(Exception e){
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }

            }
        }
    }


}
