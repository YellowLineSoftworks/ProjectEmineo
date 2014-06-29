/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objects;

import control.EventManager;
import resources.GameObject;

/**
 * @author austinletson
 */
public class Player extends GameObject {
    public Player() {
        super(EventManager.getClock().bufferedDevices[0]);
    }
}
