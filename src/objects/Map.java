/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objects;

import control.EventManager;

import java.awt.Image;
import javax.swing.ImageIcon;

import resources.GameObject;

/**
 * @author austinletson
 */
public class Map extends GameObject {


    Maps type;
    private static Map currentMap;


    public Map(Maps m) {

        super(0, 0, 680, 680, new Image[]{m.image}, EventManager.getClock().bufferedDevices[0]);
        type = m;

    }

    @Override
    public void draw() {
        super.draw();
        for (Tower t : type.towers) {
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

    public enum Maps {
        NORTH("North", new ImageIcon(new EventManager().getClass().getResource("/art/map.png")).getImage(),
                new int[][]{{203, 609}, {158, 443}, {160, 400}, {40, 420}, {280, 325}, {340, 165}, {355, 115}, {445, 150}},
                new ImageIcon(new EventManager().getClass().getResource("/art/towerlocation.png")).getImage());


        Tower[] towers;
        String name;
        Image image;

        Maps(String n, Image img, int[][] tL, Image towerLocationImage) {
            name = n;
            image = img;
            towers = new Tower[tL.length];
            for (int i = 0; i < towers.length; i++) {
                towers[i] = new Tower(tL[i][0], tL[i][1], towerLocationImage);
            }
        }
    }
}
    
    






