package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;

import static com.kata.bowling.BowlingGameUtil.isNumeric;

public class BowlingGame {

    List<Frame> frames;

    public int score() {
        int score = 0;
        for (int frameCounter = 0; frameCounter < 10; frameCounter++) {
            score += frameScore(frameCounter);
            if(isStrike(frameCounter)){
                score += strikeBonus(frameCounter);
            }
            if(isSpare(frameCounter)) {
                score += spareBonus(frameCounter);
            }
        }
        return score;
    }

    private int strikeBonus(int frameCounter) {
        return frames.get(frameCounter + 1).getRoll1()
                + frames.get(frameCounter + 2).getRoll1();
    }

    private boolean isStrike(int frameCounter) {
        return frames.get(frameCounter).getRoll1() == 10;
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
                addBonusFrame(rolls, rollCounter);
                break;
            }
            if(isNumeric(rolls.get(rollCounter))){
                frame.setRoll1(Integer.valueOf(rolls.get(rollCounter)));
                if (isNumeric(rolls.get(rollCounter + 1))) {
                    frame.setRoll2(Integer.valueOf(rolls.get(rollCounter + 1)));
                } else {
                    frame.setRoll2(10 - frame.getRoll1());
                }
            } else{
                buildStrikeFrame(frame);
                rollCounter--;
            }
            frames.add(frame);
        }
    }

    private void buildStrikeFrame(Frame frame) {
        frame.setRoll1(10);
        frame.setRoll2(0);
    }

    private void addBonusFrame(List<String> rolls, int rollCounter) {
        Frame bonusFrame = new Frame();
        bonusFrame.setBonus(true);
        if (isNumeric(rolls.get(rollCounter))) {
            bonusFrame.setRoll1(Integer.valueOf(rolls.get(rollCounter)));
        }else{
            bonusFrame.setRoll1(10);
        }
        frames.add(bonusFrame);
    }

}
