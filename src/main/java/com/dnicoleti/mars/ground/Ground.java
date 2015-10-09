package com.dnicoleti.mars.ground;

import java.io.Serializable;

public class Ground implements Serializable {

    private int width;
    private int height;

    public Ground(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * @return the ground width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the ground height
     */
    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ground ground = (Ground) o;
        if (width != ground.getWidth()) {
            return false;
        }
        return height == ground.getHeight();

    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "Ground{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
