package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    List<Frame> frames;

    public int score(List<String> rolls) {
        int score = 0;
        for (int frameCounter = 0; frameCounter < frames.size(); frameCounter++) {
            if(frames.get(frameCounter).frameScore() == 10) {
                score += frames.get(frameCounter + 1).getRoll1();
            }
            score += frames.get(frameCounter).frameScore();
        }
        return score;
    }

    public void prepareFrames(List<String> rolls) {
        frames = new ArrayList<>();
        Frame frame;
        for (int rollCounter = 0; rollCounter < rolls.size(); rollCounter = rollCounter + 2) {
            frame = new Frame();
            frame.setRoll1(Integer.valueOf(rolls.get(rollCounter)));
            if (isNumeric(rolls.get(rollCounter + 1))) {
                frame.setRoll2(Integer.valueOf(rolls.get(rollCounter + 1)));
            } else {
                frame.setRoll2(10 - frame.getRoll1());
            }
            frames.add(frame);
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
