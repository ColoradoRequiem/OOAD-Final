package UI;

import IslandType.Island;

import javax.swing.*;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;


public class UIHandeler {
    Island island;
    JFrame frame;
    JTextArea islandDescription;
    static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    public UIHandeler (Island island){
        this.island = island;
        GameStateActions actionButtonFrame = new GameStateActions(island);
        frame = actionButtonFrame.getButtonFrame();
        islandDescription = new JTextArea(island.getDescription(island.get_player()));
        islandDescription.setLineWrap(true);
        islandDescription.setWrapStyleWord(true);
        islandDescription.setBounds(200,100,200,150);
        //frame.add(islandDescription);


        //JScrollPane scrollList = new JScrollPane(, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.setSize(600,600);
        frame.setVisible(true);
        //frame.add(actionButtonFrame.getButtonFrame());
    }
}
