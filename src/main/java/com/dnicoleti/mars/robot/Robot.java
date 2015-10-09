package com.dnicoleti.mars.robot;

import java.io.Serializable;

import javax.inject.Inject;

import com.dnicoleti.mars.ground.Ground;
import com.dnicoleti.mars.robot.coord.Coordinate;

public class Robot implements Serializable {

    private Ground ground;
    private Coordinate coordinate;

    @Inject
    public Robot(Ground ground, Coordinate coordinate) {
        this.ground = ground;
        this.coordinate = coordinate;
    }

    public void receiveControls(String controls) {
        for (char control : controls.toCharArray()) {
            switch (control) {
                case 'M' :
                    coordinate.moveForward(ground);
                    break;
                case 'L' :
                    coordinate.rotateLeft();
                    break;
                case 'R' :
                    coordinate.rotateRight();
                    break;
            }
        }
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}
