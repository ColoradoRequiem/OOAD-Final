package UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JMenuBar menuBar;
    private JMenu Game, Crew;
    private JFrame Jframe;
    public GameStateActions(Island island){
        buttonFrame = new JPanel();
        buttonFrame.setLayout(null);
        this.island = island;
        BufferedImage buttonImage;
        System.out.println(System.getProperty("user.dir") + "\\src\\UI\\button.png");
        try {
            buttonImage = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\UI\\button.png"));
            System.out.println(System.getProperty("user.dir") + "\\button.png");
        }
        catch (IOException e){
            buttonImage = null;
        }
        buttonIcon = new ImageIcon(buttonImage);
        ArrayList<JButton> buttonArr= getButtons(island);
        addButtons(buttonArr);
        menuBar = getMenuBar();


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
        frame.add(scrollPane, 0);
        frame.setJMenuBar(menuBar);
        this.Jframe = frame;
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

                ArrayList<Integer> newPos = action.click(island.get_player());
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
        JTextArea text = new JTextArea(island.getDescription(island.get_player()));
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
    private JMenuBar getMenuBar(){
        JMenuBar newMenuBar= new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenu crewMenu = new JMenu("crew");
        JMenuItem Exit = new JMenuItem("Exit");
        JMenu excursionManagment = getExcursionManagement();
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        
        crewMenu.add(excursionManagment);
        addCrewItemManagementMenus(crewMenu, getCrewItemManagementMenus());
        gameMenu.add(getSavesMenu());
        gameMenu.add(produceSaveButton());
        gameMenu.add(Exit);


        newMenuBar.add(gameMenu);
        newMenuBar.add(crewMenu);


        return newMenuBar;
    }
    private void exit(){
        this.Jframe.setVisible(false);
        this.Jframe.dispose();
    }
    private JMenu getExcursionManagement(){
        JMenu newMenu = new JMenu("Excursion Management");
        for (Crew.Crew c:island.get_player().getCrew()) {
            newMenu.add(new JCheckBoxMenuItem(c.getName()));
        }
        return newMenu;
    }
    private void addCrewItemManagementMenus(JMenu crew, ArrayList<JMenu> menus){
        for (JMenu menu: menus) {
            crew.add(menu);
        }
    }
    private ArrayList<JMenu> getCrewItemManagementMenus(){
        ArrayList<JMenu> arrMenus = new ArrayList<JMenu>();
        for (Crew.Crew c:island.get_player().getCrew()) {
            JMenu tempMenu = new JMenu(c.getName());
            JCheckBoxMenuItem tempCheckBox = new JCheckBoxMenuItem("item");
            tempMenu.add(tempCheckBox);
            arrMenus.add(tempMenu);
        }
        return arrMenus;
    }

    //https://stackoverflow.com/questions/1844688/how-to-read-all-files-in-a-folder-from-java
    private ArrayList<String> getSaves(){
        ArrayList<String> saveFiles = new ArrayList<String>();
        String saveFolder = System.getProperty("user.dir") + "\\src\\Saves";
        File folder = new File(saveFolder);
        for (final File saveFile: folder.listFiles()){
                System.out.println(saveFile.getName());
                saveFiles.add(saveFile.getName());
        }
        return saveFiles;
    }
    private JMenu getSavesMenu(){
        ArrayList<String> saves = getSaves();
        JMenu SaveMenu = new JMenu("Load Save");
        for (String saveName: saves) {
            JMenuItem tempItem = new JMenuItem(saveName);
            SaveMenu.add(tempItem);
        }
        return SaveMenu;
    }
    //add check to see if there is current save
    private JMenuItem produceSaveButton(){
        int SaveNumber = getSaves().size();
        JMenuItem saveItem = new JMenuItem("Save Game");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String saveFolder = System.getProperty("user.dir") + "\\src\\Saves";
                final File saveFile = new File(saveFolder,"Save"+SaveNumber +".txt");
                try {
                    saveFile.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        return saveItem;
    }


}
