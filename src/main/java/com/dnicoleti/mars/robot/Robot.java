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

    /**
     * <p>Receives a {@code String} which can contain the chars <b>L</b>, <b>R</b> and <b>M</b></p>
     *
     * <p><b>L</b> and <b>R</b> makes the robot rotate on its axis 90 degrees left or right, respectively,
     * without moving from its current position.<br/>
     * <b>M</b> makes the robot move one position forward.</p>
     *
     * <p><em>Example:</em> If robot is in coordinate (0,0,N), the control <b>MML</b>
     * will get it in coordinate (0,2,W)</p>
     *
     * @param controls the control string
     */
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

    /**
     * Returns the current {@link Coordinate}
     * @return the current coordinate
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

}
