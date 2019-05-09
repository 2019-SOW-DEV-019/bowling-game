package com.kata.bowling;

import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameUtilTest {

    @Test
    public void shouldBeTrueIfGivenStringIsANumber() {
        assertTrue(BowlingGameUtil.isNumeric("6"));
    }
}