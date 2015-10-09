package com.dnicoleti.mars.robot.coord;

import java.io.Serializable;

import com.dnicoleti.mars.ground.Ground;

public class Coordinate implements Serializable {

    private Direction direction;
    private int x;
    private int y;

    public Coordinate() {
        this(Direction.NORTH, 0, 0);
    }

    public Coordinate(Direction direction, int x, int y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the current {@link Direction}
     * @return the current direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return x-axis position
     */
    public int getX() {
        return x;
    }

    /**
     * @return y-axis position
     */
    public int getY() {
        return y;
    }

    /**
     * Rotate the current <code>direction</code> 90 degrees to left
     */
    public void rotateLeft() {
        direction = direction.left();
    }

    /**
     * Rotates the current <code>direction</code> 90 degrees to right
     */
    public void rotateRight() {
        direction = direction.right();
    }

    /**
     * Updates the position based on its <code>direction</code> and the boundaries of a given <code>ground</code>
     * @param ground {@link Ground} to determine the boundaries
     */
    public void moveForward(Ground ground) {
        switch (direction) {
            case NORTH:
                if (y < ground.getHeight() - 1) {
                    y++;
                }
                break;
            case SOUTH:
                if (y > 0) {
                    y--;
                }
                break;
            case EAST:
                if (x < ground.getWidth() - 1) {
                    x++;
                }
                break;
            case WEST:
                if (x > 0) {
                    x--;
                }
                break;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Coordinate that = (Coordinate) o;
        if (getX() != that.getX()) {
            return false;
        }
        if (getY() != that.getY()) {
            return false;
        }
        return getDirection() == that.getDirection();
    }

    @Override
    public int hashCode() {
        int result = getDirection().hashCode();
        result = 31 * result + getX();
        result = 31 * result + getY();
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "direction=" + direction +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
