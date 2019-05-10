package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;

import static com.kata.bowling.BowlingGameConstants.*;
import static com.kata.bowling.BowlingGameUtil.isNumeric;

public class BowlingGame {

    private List<Frame> frames;

    public int score() {
        int score = ZERO;
        for (int frameCounter = ZERO; frameCounter < MAX_SIZE_OF_FRAME; frameCounter++) {
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
        if(isStrike(frameCounter + ONE) &&
                !frames.get(frameCounter + ONE).isBonusFrame()){
            return frames.get(frameCounter + ONE).getRoll1()
                    + frames.get(frameCounter + TWO).getRoll1();
        }else{
            return frames.get(frameCounter + ONE).frameScore();
        }
    }

    private boolean isStrike(int frameCounter) {
        return frames.get(frameCounter).getRoll1() == TEN_PIN_DOWN;
    }

    private Integer frameScore(int frameCounter) {
        return frames.get(frameCounter).frameScore();
    }

    private Integer spareBonus(int frameCounter) {
        return frames.get(frameCounter + ONE).getRoll1();
    }

    private boolean isSpare(int frameCounter) {
        return frames.get(frameCounter).getRoll1() != TEN_PIN_DOWN &&
                frames.get(frameCounter).frameScore() == TEN_PIN_DOWN;
    }

    public void prepareFrames(List<String> rolls) {
        frames = new ArrayList<>();
        Frame frame;
        for (int rollCounter = ZERO; rollCounter < rolls.size(); rollCounter = rollCounter + TWO) {
            frame = new Frame();
            if (frames.size() >= MAX_SIZE_OF_FRAME) {
                addBonusFrame(rolls, rollCounter);
                break;
            }
            if(isNumeric(rolls.get(rollCounter)) || "-".equalsIgnoreCase(rolls.get(rollCounter))){
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
        if (isNumeric(rolls.get(rollCounter))) {
            frame.setRoll1(Integer.valueOf(rolls.get(rollCounter)));
        } else {
            frame.setRoll1(ZERO_PIN_DOWN);
        }
        if (isNumeric(rolls.get(rollCounter + ONE)) || "-".equalsIgnoreCase(rolls.get(rollCounter + ONE))) {
            if (isNumeric(rolls.get(rollCounter + ONE))) {
                frame.setRoll2(Integer.valueOf(rolls.get(rollCounter + ONE)));
            } else {
                frame.setRoll2(ZERO_PIN_DOWN);
            }
        } else {
            buildRoll2ValueWhenIsSpare(frame);
        }
    }

    private void buildStrikeFrame(Frame frame) {
        frame.setRoll1(TEN_PIN_DOWN);
        frame.setRoll2(ZERO_PIN_DOWN);
    }

    private void addBonusFrame(List<String> rolls, int rollCounter) {
        Frame bonusFrame = new Frame();
        bonusFrame.setBonus(true);
        if (isNumeric(rolls.get(rollCounter))  || "-".equalsIgnoreCase(rolls.get(rollCounter))) {
            if (isNumeric(rolls.get(rollCounter))) {
                bonusFrame.setRoll1(Integer.valueOf(rolls.get(rollCounter)));
            } else {
                bonusFrame.setRoll1(ZERO_PIN_DOWN);
            }
        } else {
            bonusFrame.setRoll1(TEN_PIN_DOWN);
        }
        if(STRIKE.equalsIgnoreCase(rolls.get(rollCounter - ONE))){
            if (isNumeric(rolls.get(rollCounter + ONE))) {
                if (isNumeric(rolls.get(rollCounter + ONE))) {
                    bonusFrame.setRoll2(Integer.valueOf(rolls.get(rollCounter + ONE)));
                } else {
                    bonusFrame.setRoll2(ZERO_PIN_DOWN);
                }
            } else if(SPARE.equalsIgnoreCase(rolls.get(rollCounter + ONE))) {
                buildRoll2ValueWhenIsSpare(bonusFrame);
            } else {
                bonusFrame.setRoll2(TEN_PIN_DOWN);
            }
        }
        frames.add(bonusFrame);
    }

    private void buildRoll2ValueWhenIsSpare(Frame frame) {
        frame.setRoll2(MAX_PIN_IN_A_FRAME - frame.getRoll1());
    }

}
