package com.company;

import IslandType.*;
import Action.*;
import java.util.ArrayList;

public class Main extends Utils {

    public static void main(String[] args) {
        Island test = new Island();
        while (true) {
            System.out.println("Explore: ["+test.getPosition().get(0)+" "+test.getPosition().get(1)+"]");
            String d = test.getDescription();
            ArrayList<Action> availableActions = test.getAvailableActions();

            System.out.println(d);
            for (int j=0; j<availableActions.size(); j++) {
                System.out.println(j+" "+availableActions.get(j).getButtonDescription());
            }

            int i = Utils.readInput();

            ArrayList<Integer> newPos = availableActions.get(i).click();
            test.setPosition(newPos.get(0), newPos.get(1));

            // clear all buttons / Img / description
        }
    }
}
