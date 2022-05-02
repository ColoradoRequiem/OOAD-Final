package Observer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Crew.Crew;
import Item.Item;
import Player.Player;

public class ConcreteObserver {
    File save;
    String newSaveContents= "";
    public ConcreteObserver(File save){
        this.save = save;
    }
    public void update(Item update){
        newSaveContents = newSaveContents + "+Player_Inventory: "+ update.getName() + ";\n";
    }
    public void update(Player update){
        newSaveContents = newSaveContents + "+Player_Name: " + update.getName() + "; Current_Island: " + update.getCurrentIsland() + ";\n";
    }
    public void update(Crew update){
        // STR CON DEX CHA WIS INT
        ArrayList<Integer> attr = update.getAttrArr();
        String right_hand = "null";
        String left_hand = "null";
        if (update.getLeftHandItem() != null)
            left_hand = update.getLeftHandItem().getName();
        if (update.getRightHandItem() != null)
            right_hand = update.getRightHandItem().getName();
        newSaveContents = newSaveContents + "+Crew_Name: "+update.getName() +"; Crew_Race: " + update.getRace() +"; Crew_Personality: " + update.getPersonality()+ "; right_hand: " + right_hand
                + "; left_hand: " + left_hand + "; STR: " + attr.get(0) + "; CON: " + attr.get(1) + "; DEX: " + attr.get(2) + "; CHA: " + attr.get(3) + "; WIS: " + attr.get(4)
                + "; INT: " + attr.get(5) + ";\n";
    }
    public void Save(){
        try {
            System.out.println(newSaveContents);
            FileWriter fw = new FileWriter(save, true);
            fw.write(newSaveContents);
            fw.close();
            newSaveContents = "";
        } catch (IOException e){
            System.out.println("problem Saving");
        }
    }
}
