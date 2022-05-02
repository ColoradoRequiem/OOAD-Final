package com.company;

import Crew.Crew;
import IslandType.*;
import Action.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Item.Cutlass;
import Observer.ConcreteObserver;
import Player.Player;
import SaveLoader.SaveLoader;
import UI.GameStateActions;
import UI.ImageJframe;
import UI.UIHandeler;

public class Main extends Utils {

    public static void main(String[] args) {
         File save = new File(System.getProperty("user.dir") + "\\src\\Saves\\Save.txt");
         ConcreteObserver observer = new ConcreteObserver(save);
         Player testPlayer = new Player();
         observer.update(testPlayer);
         observer.update(new Cutlass());
         observer.update(new Crew());
        observer.Save();
        SaveLoader saveLoader = new SaveLoader(save);
        saveLoader.getPlayer();
         //Island test = new Island();
         //UIHandeler handler = new UIHandeler(test);
            /**JTextArea IslandDescription = new JTextArea(test.getDescription());
            IslandDescription.setLineWrap(true);
            IslandDescription.setWrapStyleWord(true);
            IslandDescription.setBounds(200, 100, 200, 150);
            frame.add(IslandDescription);
            ArrayList<GameAction> availableActions = test.getAvailableActions();
            GameStateActions actionButtons = new GameStateActions(availableActions, test);
            JPanel scrollable = actionButtons.getButtonFrame();
            JScrollPane scrollList = new JScrollPane(scrollable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            // create button and actionListener for each available action
            frame.add(scrollList);
            // within the listener
            // ArrayList<Integer> newPos = availableActions.get(count.get(action)).click();
            // test.setPosition(newPos.get(0), newPos,get(1)
            frame.setSize(600, 600);
            frame.setVisible(true);
            **/
    }
}
