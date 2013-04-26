package no.finntech.kata;

import java.awt.*;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public final class GameOfLifeTest {

    @Test
    public void testInit() {
        GameOfLife game = new GameOfLife(3, 3);

        assertThat(game.getDimentions()).isEqualTo(new Point(3,3));
    }

    @Test
    public void testIsAlive() {
        GameOfLife game = new GameOfLife(3, 3);
        game.setAlive(1,1);
        assertThat(game.isAlive(1,1)).isTrue();
    }
}
