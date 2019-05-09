package com.kata.bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrameTest {

    @Test
    public void shouldReturn2WhenBothRollsAre1() {
        Frame frame = new Frame();
        frame.setRoll1(1);
        frame.setRoll2(1);

        assertEquals(2, (int) frame.frameScore());
    }

}