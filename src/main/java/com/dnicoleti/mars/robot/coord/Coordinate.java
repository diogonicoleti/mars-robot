package com.dnicoleti.mars.robot.coord;

import java.io.Serializable;

import com.dnicoleti.mars.ground.Ground;

public class Coordinate implements Serializable {

    private int x;
    private int y;
    private Direction direction;

    public Coordinate() {
        this(0, 0, Direction.NORTH);
    }

    public Coordinate(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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
     * Returns the current {@link Direction}
     * @return the current direction
     */
    public Direction getDirection() {
        return direction;
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
