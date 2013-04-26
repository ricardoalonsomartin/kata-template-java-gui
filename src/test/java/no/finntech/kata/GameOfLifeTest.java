package no.finntech.kata;

import java.awt.*;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public final class GameOfLifeTest {

    private GameOfLife game;
    @Before
    public void initObjects() {
        game = new GameOfLife(3, 3);
    }

    @Test
    public void testInit() {

        assertThat(game.getDimentions()).isEqualTo(new Point(3,3));
    }

    @Test
    public void testIsAlive() {
        game.setAlive(1,1);
        assertThat(game.isAlive(1,1)).isTrue();
    }

    @Test
    public void testUnderpopulation() {
        game.setAlive(1,1);
        game.evolve();
        assertThat(game.isAlive(1,1)).isFalse();
    }
}
