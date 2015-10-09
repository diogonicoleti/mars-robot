package com.dnicoleti.mars.robot.coord;

public enum Direction {
    NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

    private final char abbreviation;

    Direction(char abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Returns the left direction for the current direction.
     * <blockquote><pre>
     * Direction.NORTH.left();  // WEST
     * Direction.WEST.left();   // SOUTH
     * Direction.SOUTH.left();  // EAST
     * Direction.EAST.left();   // NORTH
     * </pre></blockquote>
     * @return the left direction
     */
    public Direction left() {
        Direction[] values = values();
        return values()[(ordinal() + values.length - 1) % values.length];
    }

    /**
     * Returns the right direction for the current direction.
     * <blockquote><pre>
     * Direction.NORTH.right();  // EAST
     * Direction.EAST.right();   // SOUTH
     * Direction.SOUTH.right();  // WEST
     * Direction.WEST.right();   // NORTH
     * </pre></blockquote>
     * @return the right direction
     */
    public Direction right() {
        Direction[] values = values();
        return values[(ordinal() + 1) % values.length];
    }

    @Override
    public String toString() {
        return String.valueOf(abbreviation);
    }
}
