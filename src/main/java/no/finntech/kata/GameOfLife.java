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
                checkRules(evolvedCells, i, j, liveCount);
            }
        }
        cells = evolvedCells;
    }

   private void checkRules(boolean[][] evolvedCells, int i, int j, long liveCount) {
        if(liveCount < 2) {
            evolvedCells[i][j] = false;
        } else if(liveCount > 3) {
            evolvedCells[i][j] = false;
        } else {
            evolvedCells[i][j] = true;
        }

    }

    private int countLiveNeighbours(int x, int y) {
        int liveCount = 0;

        if ((x+1 < cells.length) && isAlive(x+1,y)){
            liveCount++;
        }
        if ((y+1 < cells[0].length) && isAlive(x,y+1)){
            liveCount++;
        }
        if ((x+1 < cells.length) && (y+1 < cells[0].length) &&  isAlive(x+1,y+1)){
            liveCount++;
        }
        if ((x-1 >= 0) && isAlive(x-1,y)){
            liveCount++;
        }
        if ((y-1 >= 0) && isAlive(x,y-1)) {
            liveCount++;
        }
        if ((x-1 >= 0) && (y-1 >= 0) && isAlive(x-1,y-1)){
            liveCount++;
        }
        if ((x-1 >= 0) && (y+1 < cells[0].length) && isAlive(x-1,y+1)) {
            liveCount++;
        }
        if ((x+1 < cells.length) && (y-1 >= 0) && isAlive(x+1,y-1)){
            liveCount++;
        }

        return liveCount;
    }
}
