package no.finntech.kata;

import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public final class GameOfLifeImplTest {

    private GameOfLifeImpl game;
    @Before
    public void initObjects() {
        game = new GameOfLifeImpl(3, 3);
    }

    @Test
    public void testInit() {

        assertThat(game.getDimentions()).isEqualTo(new Point(3,3));
    }

    @Test
    public void testIsAlive() {
        game.setAlive(1,1);
        assertThat(game.isAlive(1, 1)).isTrue();
    }

    @Test
    public void testUnderpopulation_withoutNeighbours() {
        game.setAlive(1,1);
        game.evolve();
        assertThat(game.isAlive(1, 1)).isFalse();
    }

    @Test
    public void testUnderpopulation_withTwoNeighbours() {
        game.setAlive(1,1);
        game.setAlive(0,1);
        game.setAlive(2,1);
        game.evolve();
        assertThat(game.isAlive(1, 1)).isTrue();
    }

    @Test
    public void testOvercrowding_withFourNeighbours() {
        game.setAlive(1,1);
        game.setAlive(0,1);
        game.setAlive(2,1);
        game.setAlive(1,2);
        game.setAlive(2,2);
        game.evolve();
        assertThat(game.isAlive(1,1)).isFalse();
    }

    @Test
    public void testOvercrowding_withFiveNeighbours() {
        game.setAlive(1,1);
        game.setAlive(0,1);
        game.setAlive(2,1);
        game.setAlive(1,2);
        game.setAlive(2,2);
        game.setAlive(1,0);
        game.evolve();
        assertThat(game.isAlive(1,1)).isFalse();
    }

    @Test
    public void testWithTwoNeighbours() {
        game.setAlive(1,1);
        game.setAlive(0,1);
        game.setAlive(2,1);
        game.evolve();
        assertThat(game.isAlive(1,1)).isTrue();
    }

    @Test
    public void testWithThreeNeighbours() {
        game.setAlive(1,1);
        game.setAlive(0,1);
        game.setAlive(2,1);
        game.setAlive(1,2);
        game.evolve();
        assertThat(game.isAlive(1,1)).isTrue();
    }

    @Test
    public void testDeadCellWithThreeNeighboursComesAlive() {
        game.setDead(1, 1);
        game.setAlive(0,1);
        game.setAlive(2,1);
        game.setAlive(1,2);
        game.evolve();
        assertThat(game.isAlive(1,1)).isTrue();
    }

    @Test
    public void testDeadCellWithTwoNeighboursIsStillDead() {
        game.setDead(1, 1);
        game.setAlive(2,1);
        game.setAlive(1,2);
        game.evolve();
        assertThat(game.isAlive(1,1)).isFalse();
    }
}
