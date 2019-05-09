package com.kata.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {

        System.out.println("If frame is a strike, give input as 'x'\nIf frame is a spare, give input as '5/' or '3/'\n\nEg: 'XXXXXXXX5472'");
        System.out.println("Enter the values of all rolls (Min 11 rolls to Max 21 rolls):");
        Scanner rollInput = new Scanner(System.in);
        String rollsEntered = rollInput.next();
        BowlingGame bowlingGame = new BowlingGame();
        List<String> rolls = prepareArrayOfRolls(rollsEntered);
        bowlingGame.prepareFrames(rolls);
        System.out.println("Total Score: "+ bowlingGame.score());
    }

    public static List<String> prepareArrayOfRolls(String rollsEntered) {
        List<String> rolls = new ArrayList<>();
        for(int rollCount = 0; rollCount < rollsEntered.length(); rollCount++)
        {
            rolls.add(rollsEntered.substring(rollCount,rollCount+1));
        }
        return rolls;
    }

}
