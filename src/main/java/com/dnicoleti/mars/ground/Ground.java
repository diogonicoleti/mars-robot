package com.dnicoleti.mars.ground;

import java.io.Serializable;

public class Ground implements Serializable {

    private int width;
    private int height;

    public Ground(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
