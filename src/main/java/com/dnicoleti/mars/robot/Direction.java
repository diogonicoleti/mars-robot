package com.dnicoleti.mars.robot;

public enum Direction {
    NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

    private final char abbreviation;

    Direction(char abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Direction left() {
        Direction[] values = values();
        return values()[(ordinal() + values.length - 1) % values.length];
    }

    public Direction right() {
        Direction[] values = values();
        return values[(ordinal() + 1) % values.length];
    }

    @Override
    public String toString() {
        return String.valueOf(abbreviation);
    }
}
