package com.company;

import IslandType.*;
import Action.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Island test = new Island();
        while (true) {
            String d = test.getDescription();
            ArrayList<Action> availableActions = test.getAvailableActions();

            // create button and actionListener for each available action

            // within the listener
            // ArrayList<Integer> newPos = availableActions.get(count.get(action)).click();
            // test.setPosition(newPos.get(0), newPos,get(1)

            // clear all buttons / Img / description
        }
    }
}
