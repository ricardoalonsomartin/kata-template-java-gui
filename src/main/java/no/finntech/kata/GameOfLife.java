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

    public void setDead(int x, int y) {
        cells[x][y] = false;
    }

    public boolean isAlive(int x, int y) {
        return cells[x][y];
    }

    public void evolve() {
        boolean[][] evolvedCells = new boolean[cells.length][cells[0].length];
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells[i].length; j++) {
                int liveCount = countLiveNeighbours(i, j);
                underpopulationRule(evolvedCells, i, j, liveCount);
            }
        }
        cells = evolvedCells;
    }

    private void underpopulationRule(boolean[][] evolvedCells, int i, int j, long liveCount) {
        if(liveCount < 2) {
            evolvedCells[i][j] = false;
        } else {
            evolvedCells[i][j] = true;
        }
    }

    private int countLiveNeighbours(int x, int y) {
        int liveCount = 0;
        for(int i = x - 1; i < x + 1; i++) {
            if(i < 0 || i > cells.length - 1) {
                continue;
            }
            for(int j = y - 1; j < y +1; j++) {
                if(j < 0 || j > cells[0].length - 1) {
                    continue;
                }
                if(isAlive(i, j)) {
                    liveCount++;
                }
            }
        }
        return liveCount;
    }
}
