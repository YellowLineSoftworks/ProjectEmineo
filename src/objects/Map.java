/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objects;

import control.EventManager;
import game.Clock;
import java.awt.Image;
import resources.GameObject;

/**
 *
 * @author austinletson
 */
public class Map extends GameObject{
    
    Maps type;
    
    public Map(Maps m){
        super(0, 0, new Image[] {m.image}, EventManager.clock.bufferedDevices[0]);
    }
    
}


enum Maps{
    
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
