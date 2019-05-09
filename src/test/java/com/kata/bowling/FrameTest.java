package com.kata.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrameTest {

    Frame frame;

    @Before
    public void setUp() throws Exception {
        frame = new Frame();
    }

    @Test
    public void shouldReturn2WhenBothRollsAre1() {
        frame.setRoll1(1);
        frame.setRoll2(1);
        frame.setBonus(false);

        assertEquals(2, (int) frame.frameScore());
    }

    @Test
    public void shouldBeTrueForOneOrTwoBonusRolls() {
        frame.setRoll1(1);
        frame.setRoll2(2);
        frame.setBonus(true);

        assertTrue(frame.isBonusFrame());
    }

}