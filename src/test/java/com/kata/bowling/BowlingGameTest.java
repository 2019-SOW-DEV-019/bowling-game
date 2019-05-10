package com.kata.bowling;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.kata.bowling.BowlingGameConstants.*;
import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame game;
    private List<String> rolls;

    @Before
    public void setUp() {
        game = new BowlingGame();
        rolls = new ArrayList<>();
    }

    @Test
    public void shouldReturnZeroWhenAllRollsZero() {
        buildRolls(ZERO_PIN_KNOCK, 20);
        game.prepareFrames(rolls);

        assertEquals(0, game.score());
    }

    @Test
    public void shouldReturn20WhenAllRollswith1PinDown() {
        buildRolls(ONE_PIN_KNOCK, 20);
        game.prepareFrames(rolls);

        assertEquals(20, game.score());
    }

    @Test
    public void shouldReturn14WhenSpareFollowedBy2PinsDown() {
        spare();
        rolls.add(TWO_PIN_KNOCK);
        buildRolls("0", 17);
        game.prepareFrames(rolls);

        assertEquals(14, game.score());
    }

    @Test
    public void shouldReturn14WhenLastFrameIsSpareAnd4PinsDownInBonusRoll() {
        buildRolls(ZERO_PIN_KNOCK, 18);
        spare();
        rolls.add(FOUR_PIN_KNOCK);
        game.prepareFrames(rolls);

        assertEquals(14, game.score());
    }

    @Test
    public void shouldReturn18ForAStrikeFollowedByTwoRollsAs2() {
        strike();
        rolls.add(TWO_PIN_KNOCK);
        rolls.add(TWO_PIN_KNOCK);
        buildRolls(ZERO_PIN_KNOCK, 16);
        game.prepareFrames(rolls);

        assertEquals(18, game.score());
    }

    @Test
    public void shouldReturn34whenStrikeFollowedBySpare() {
        strike();
        spare();
        rolls.add(TWO_PIN_KNOCK);
        buildRolls(ZERO_PIN_KNOCK, 15);
        game.prepareFrames(rolls);

        assertEquals(34, game.score());
    }

    @Test
    public void shouldReturn38WhenSpareFollowedByStrike() {
        spare();
        strike();
        rolls.add(TWO_PIN_KNOCK);
        rolls.add(TWO_PIN_KNOCK);
        buildRolls(ZERO_PIN_KNOCK, 14);
        game.prepareFrames(rolls);

        assertEquals(38, game.score());
    }

    @Test
    public void shouldReturn40WhenStrikeFollowedByStrike() {
        strike();
        strike();
        buildRolls(TWO_PIN_KNOCK, 2);
        buildRolls(ZERO_PIN_KNOCK, 14);
        game.prepareFrames(rolls);

        assertEquals(40, game.score());
    }

    @Test
    public void shouldReturn300WhenAllAreStrike() {
        buildRolls(STRIKE, 12);
        game.prepareFrames(rolls);

        assertEquals(300, game.score());
    }

    @Test
    public void shouldReturn285When10StrikeFollowedBySpare() {
        buildRolls(STRIKE, 10);
        spare();
        game.prepareFrames(rolls);

        assertEquals(285, game.score());
    }

    @Test
    public void shouldReturn282When10StrikeFollowedByTwoBonusRollsAs4() {
        buildRolls("X", 10);
        rolls.add(FOUR_PIN_KNOCK);
        rolls.add(FOUR_PIN_KNOCK);
        game.prepareFrames(rolls);

        assertEquals(282, game.score());
    }

    @Test
    public void shouldReturn270When10StrikeFollowedByTwoBonusRollsAs0() {
        buildRolls("X", 10);
        rolls.add(ZERO_PIN_KNOCK);
        rolls.add(ZERO_PIN_KNOCK);
        game.prepareFrames(rolls);

        assertEquals(270, game.score());
    }

    private void strike() {
        rolls.add(STRIKE);
    }

    private void spare() {
        rolls.add(FIVE_PIN_KNOCK);
        rolls.add(SPARE);
    }

    private void buildRolls(String noOfPinsDown, int noOfRollsToAdd) {
        for (int rollCount = ZERO; rollCount < noOfRollsToAdd; rollCount++) {
            rolls.add(noOfPinsDown);
        }
    }

}
