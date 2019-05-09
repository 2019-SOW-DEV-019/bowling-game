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
        buildRolls("0", 20);
        game.prepareFrames(rolls);

        assertEquals(0, game.score());
    }

    @Test
    public void shouldReturn20WhenAllRollswith1PinDown() {
        buildRolls("1", 20);
        game.prepareFrames(rolls);

        assertEquals(20, game.score());
    }

    @Test
    public void shouldReturn14WhenSpareFollowedBy2PinsDown() {
        rolls.add("7");
        rolls.add("/");
        rolls.add("2");
        buildRolls("0", 17);
        game.prepareFrames(rolls);

        assertEquals(14, game.score());
    }

    private void buildRolls(String noOfPinsDown, int noOfRollsToAdd) {
        for (int rollCount = 0; rollCount < noOfRollsToAdd; rollCount++) {
            rolls.add(noOfPinsDown);
        }
    }
}
