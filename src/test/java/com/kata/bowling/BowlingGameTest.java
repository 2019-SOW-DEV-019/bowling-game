package com.kata.bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    @Test
    public void shouldReturnZeroWhenAllRollsZero() {
        BowlingGame game = new BowlingGame();

        assertEquals(0, game.score());
    }
}
