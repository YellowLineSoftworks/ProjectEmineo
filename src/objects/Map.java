/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objects;

import control.EventManager;
import game.Clock;
import java.awt.Image;
import javax.swing.ImageIcon;
import resources.GameObject;
import objects.TowerLocation;

/**
 *
 * @author austinletson
 */
public class Map extends GameObject{

    
    Maps type;
    private static Map currentMap;
    

    
    public Map(Maps m){
        
        super(0, 0, new Image[] {m.image}, EventManager.clock.bufferedDevices[0]);
        type = m;
        
    }

    @Override
    public void draw() {
        super.draw(); 
        for(TowerLocation t : type.towerLocations){
            t.draw();
        }
    }
    
    /**
     * @return the currentMap
     */
    public static Map getCurrentMap() {
        return currentMap;
    }

    /**
     * @param aCurrentMap the currentMap to set
     */
    public static void setCurrentMap(Map aCurrentMap) {
        currentMap = aCurrentMap;
    }
    
    public enum Maps{
    NORTH("North", new ImageIcon(new EventManager().getClass().getResource("/art/map.png")).getImage(), new TowerLocation[] {
        new TowerLocation(203, 609, new ImageIcon(new EventManager().getClass().getResource("/art/towerlocation.png")).getImage()),
        new TowerLocation(158, 443, new ImageIcon(new EventManager().getClass().getResource("/art/towerlocation.png")).getImage()),
        new TowerLocation(160, 400, new ImageIcon(new EventManager().getClass().getResource("/art/towerlocation.png")).getImage()),
        new TowerLocation(40, 420, new ImageIcon(new EventManager().getClass().getResource("/art/towerlocation.png")).getImage()),
        new TowerLocation(280,325, new ImageIcon(new EventManager().getClass().getResource("/art/towerlocation.png")).getImage()),
        new TowerLocation(340, 165, new ImageIcon(new EventManager().getClass().getResource("/art/towerlocation.png")).getImage()),
        new TowerLocation(355, 155, new ImageIcon(new EventManager().getClass().getResource("/art/towerlocation.png")).getImage()),
        new TowerLocation(445, 150, new ImageIcon(new EventManager().getClass().getResource("/art/towerlocation.png")).getImage())
    
    })
    
    ;
    
        
    TowerLocation[] towerLocations;
    String name;
    Image image;
    Maps(String n, Image img, TowerLocation[] tL){
        towerLocations = tL;
        name = n;
        image = img;
    }
}
    
    
}





