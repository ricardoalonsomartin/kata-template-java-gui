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
}
