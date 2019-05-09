package com.kata.bowling;

import java.util.List;

public class BowlingGame {
    public int score(List<String> rolls) {
        int score = 0;
        for (String roll : rolls){
            score += Integer.valueOf(roll);
        }
        return score;
    }
}
