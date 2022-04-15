package UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import Action.GameAction;
import IslandType.Island;

public class GameStateActions {
    private JPanel buttonFrame;
    private ImageIcon buttonIcon;
    private Island island;
    public GameStateActions(Island island){
        buttonFrame = new JPanel();
        buttonFrame.setLayout(null);
        this.island = island;
        BufferedImage buttonImage;
        try {
            buttonImage = ImageIO.read(new File("E:\\Downloads\\button.png"));

        }
        catch (IOException e){
            buttonImage = null;
        }
        buttonIcon = new ImageIcon(buttonImage);
        ArrayList<JButton> buttonArr= getButtons(island);
        addButtons(buttonArr);
    }
    private void addButtons(ArrayList<JButton> buttonArr){
        for (JButton button:buttonArr) {
            buttonFrame.add(button);
            System.out.println("adding Buttons");
        }
    }
    public JFrame getButtonFrame() {
        JFrame frame = new JFrame("Pirate Game");
        JScrollPane scrollPane = new JScrollPane(buttonFrame, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        addTextArea();
        frame.add(scrollPane,0);

        return frame;
    }
    public ArrayList<JButton> getButtons(Island island){
        int i = 0;
        ArrayList<GameAction> actions = island.getAvailableActions();
        System.out.println(actions.size());
        ArrayList<JButton> buttons = new ArrayList<JButton>();
        for (GameAction action:actions) {
            JButton temp = new JButton(action.getButtonDescription(),buttonIcon);
            temp.setHorizontalTextPosition(JButton.CENTER);
            temp.setVerticalTextPosition(JButton.CENTER);
            temp.setBorder(new EmptyBorder(0,0,0,0));
            temp.setBounds(215,220+60*(i+1), 180, 80);
            temp.setContentAreaFilled(false);
            temp.addActionListener( e ->
            {

                ArrayList<Integer> newPos = action.click();
                if (newPos !=null) {
                    island.setPosition(newPos.get(0), newPos.get(1));
                    this.update();
                    System.out.println(island.get_position());
                }
            });
            buttons.add(temp);
            i++;
        }
        System.out.println(buttons.size());
        return buttons;
    }
    private void addTextArea(){
        JTextArea text = new JTextArea(island.getDescription());
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setOpaque(false);
        text.setBounds(200,125,200,200);
        buttonFrame.add(text);
    }
    private void update(){
        System.out.println("call Update");
        buttonFrame.removeAll();
        buttonFrame.invalidate();
        ArrayList<JButton> newButtons = getButtons(island);
        addButtons(newButtons);
        addTextArea();
        buttonFrame.repaint();
    }
}
