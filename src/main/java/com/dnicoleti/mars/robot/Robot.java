package com.dnicoleti.mars.robot;

import com.dnicoleti.mars.ground.Ground;

import javax.inject.Inject;
import java.io.Serializable;

public class Robot implements Serializable {

    @Inject
    private Position position;
    @Inject
    private Ground ground;

    public void receiveControls(String controls) {
        for (char control : controls.toCharArray()) {
            switch (control) {
                case 'M' :
                    position.move();
                    break;
                case 'L' :
                    position.rotateLeft();
                    break;
                case 'R' :
                    position.rotateRight();
                    break;
            }
        }
    }

    public Position getPosition() {
        return position;
    }

}
