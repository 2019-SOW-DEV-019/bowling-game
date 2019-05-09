package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;

import static com.kata.bowling.BowlingGameUtil.isNumeric;

public class BowlingGame {

    List<Frame> frames;

    public int score() {
        int score = 0;
        for (int frameCounter = 0; frameCounter < 10; frameCounter++) {
            if(isSpare(frameCounter)) {
                score += spareBonus(frameCounter);
            }
            score += frameScore(frameCounter);
        }
        return score;
    }

    private Integer frameScore(int frameCounter) {
        return frames.get(frameCounter).frameScore();
    }

    private Integer spareBonus(int frameCounter) {
        return frames.get(frameCounter + 1).getRoll1();
    }

    private boolean isSpare(int frameCounter) {
        return frames.get(frameCounter).frameScore() == 10;
    }

    public void prepareFrames(List<String> rolls) {
        frames = new ArrayList<>();
        Frame frame;
        for (int rollCounter = 0; rollCounter < rolls.size(); rollCounter = rollCounter + 2) {
            frame = new Frame();
            if (frames.size() >= 10) {
                Frame bonusFrame = new Frame();
                bonusFrame.setBonus(true);
                if (isNumeric(rolls.get(rollCounter))) {
                    bonusFrame.setRoll1(Integer.valueOf(rolls.get(rollCounter)));
                }else{
                    bonusFrame.setRoll1(10);
                }
                frames.add(bonusFrame);
                break;
            }
            frame.setRoll1(Integer.valueOf(rolls.get(rollCounter)));
            if (isNumeric(rolls.get(rollCounter + 1))) {
                frame.setRoll2(Integer.valueOf(rolls.get(rollCounter + 1)));
            } else {
                frame.setRoll2(10 - frame.getRoll1());
            }
            frames.add(frame);
        }
    }

}
