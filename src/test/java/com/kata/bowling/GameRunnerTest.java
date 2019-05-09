package com.kata.bowling;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class GameRunnerTest {

    @Test
    public void testPrepareRollsForGame() {
        List<String> expected = Arrays.asList("2", "2", "2", "2");
        GameRunner gameRunner = new GameRunner();
        String rollsEntered = "2222";

        assertEquals(expected.get(0), gameRunner.prepareArrayOfRolls(rollsEntered).get(0));
    }
}
