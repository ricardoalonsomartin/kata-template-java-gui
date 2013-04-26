package no.finntech.kata;

import java.awt.*;

public final class GameOfLife {

    private boolean[][] cells;

    public GameOfLife(int x, int y) {
        cells = new boolean[x][y];
    }

    public Point getDimentions() {
        return new Point(cells.length, cells[0].length);
    }

    public void setAlive(int x, int y) {
        cells[x][y] = true;
    }

    public boolean isAlive(int x, int y) {
        return cells[x][y];
    }
}
