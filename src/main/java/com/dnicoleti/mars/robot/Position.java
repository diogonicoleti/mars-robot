package com.dnicoleti.mars.robot;

import java.io.Serializable;

public class Position implements Serializable {

    private Direction direction;
    private int x;
    private int y;

    public Position() {
        this.direction = Direction.NORTH;
        this.x = 0;
        this.y = 0;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void rotateLeft() {
        direction = direction.left();
    }

    public void rotateRight() {
        direction = direction.right();
    }

    public void move() {
        switch (direction) {
            case NORTH:
                y++;
                break;
            case SOUTH:
                y--;
                break;
            case EAST:
                x++;
                break;
            case WEST:
                x--;
                break;
        }
    }

}
