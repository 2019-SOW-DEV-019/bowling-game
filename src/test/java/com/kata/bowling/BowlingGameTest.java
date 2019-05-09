package com.kata.bowling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    @Test
    public void shouldReturnZeroWhenAllRollsZero() {
        BowlingGame game = new BowlingGame();
        List<String> rolls = new ArrayList<>();
        for (int rollCount = 0; rollCount < 20; rollCount++) {
            rolls.add("0");
        }

        assertEquals(0, game.score(rolls));
    }

    @Test
    public void shouldReturn20WhenAllRollswith1PinDown() {
        BowlingGame game = new BowlingGame();
        List<String> rolls = new ArrayList<>();
        for (int rollCount = 0; rollCount < 20; rollCount++) {
            rolls.add("1");
        }

        assertEquals(20, game.score(rolls));
    }
}
