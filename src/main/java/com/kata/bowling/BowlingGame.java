package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;

import static com.kata.bowling.BowlingGameUtil.isNumeric;

public class BowlingGame {

    private List<Frame> frames;

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

    private Integer strikeBonus(int frameCounter) {
        if(isStrike(frameCounter + 1) &&
                !frames.get(frameCounter + 1).isBonusFrame()){
            return frames.get(frameCounter + 1).getRoll1()
                    + frames.get(frameCounter + 2).getRoll1();
        }else{
            return frames.get(frameCounter + 1).frameScore();
        }
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
        return frames.get(frameCounter).getRoll1() != 10 &&
                frames.get(frameCounter).frameScore() == 10;
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
                buildFrameWhenRollIsNotAStrike(rolls, frame, rollCounter);
            } else{
                buildStrikeFrame(frame);
                rollCounter--;
            }
            frame.setBonus(false);
            frames.add(frame);
        }
    }

    private void buildFrameWhenRollIsNotAStrike(List<String> rolls, Frame frame, int rollCounter) {
        frame.setRoll1(Integer.valueOf(rolls.get(rollCounter)));
        if (isNumeric(rolls.get(rollCounter + 1))) {
            frame.setRoll2(Integer.valueOf(rolls.get(rollCounter + 1)));
        } else {
            buildRoll2ValueWhenIsSpare(frame);
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
        } else {
            bonusFrame.setRoll1(10);
        }
        if("X".equalsIgnoreCase(rolls.get(rollCounter-1))){
            if (isNumeric(rolls.get(rollCounter+1))) {
                bonusFrame.setRoll2(Integer.valueOf(rolls.get(rollCounter+1)));
            } else if("/".equalsIgnoreCase(rolls.get(rollCounter+1))) {
                buildRoll2ValueWhenIsSpare(bonusFrame);
            } else {
                bonusFrame.setRoll2(10);
            }
        }
        frames.add(bonusFrame);
    }

    private void buildRoll2ValueWhenIsSpare(Frame frame) {
        frame.setRoll2(10 - frame.getRoll1());
    }

}
