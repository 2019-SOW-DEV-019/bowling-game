package com.kata.bowling;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    BowlingGame game;
    List<String> rolls;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
        rolls = new ArrayList<>();
    }

    @Test
    public void shouldReturnZeroWhenAllRollsZero() {
        buildRolls("0");

        assertEquals(0, game.score(rolls));
    }

    @Test
    public void shouldReturn20WhenAllRollswith1PinDown() {
        buildRolls("1");

        assertEquals(20, game.score(rolls));
    }

    private void buildRolls(String noOfRollsToAdd) {
        for (int rollCount = 0; rollCount < 20; rollCount++) {
            rolls.add(noOfRollsToAdd);
        }
    }
}
