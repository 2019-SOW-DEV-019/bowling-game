package com.kata.bowling;

public class Frame {
    Integer roll1;
    Integer roll2;
    private Boolean bonusFrame;

    public Integer getRoll1() {
        return roll1;
    }

    public Integer getRoll2() {
        return roll2;
    }

    public void setRoll1(Integer roll1) {
        this.roll1 = roll1;
    }

    public void setRoll2(Integer roll2) {
        this.roll2 = roll2;
    }

    public Integer frameScore() {
        return roll1 + roll2;
    }

    public void setBonus(boolean bonusFrame) {
        this.bonusFrame = bonusFrame;
    }

    public Boolean isBonusFrame() {
        return bonusFrame;
    }
}
