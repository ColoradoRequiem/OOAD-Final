package SaveLoader;

import Crew.Crew;
import Item.*;
import Player.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveLoader {
    File saveFile;
    ArrayList<String> Player_Updates = new ArrayList<String>();
    ArrayList<String> Crew_Updates= new ArrayList<String>();
    ArrayList<String> Inventory_updates= new ArrayList<String>();
    public SaveLoader(File saveFile){
        this.saveFile = saveFile;
    }
    public Player getPlayer(){
        //https://stackoverflow.com/questions/21989887/how-to-print-lines-from-a-file-that-contain-a-specific-word-using-java
        try{
            Scanner scanner = new Scanner(saveFile);
            while(scanner.hasNext()){
                String curLine = scanner.nextLine();
                if (curLine.contains("Player_Name"))
                    Player_Updates.add(curLine);
                else if (curLine.contains("Player_Inventory"))
                    Inventory_updates.add(curLine);
                else if (curLine.contains("Crew_Name")){
                    Crew_Updates.add(curLine);
                }
            }
            String Name = Player_Updates.get(Player_Updates.size()-1).substring(13, Player_Updates.get(Player_Updates.size()-1).indexOf(';'));
            int CurrentIsland = Integer.parseInt(Player_Updates.get(Player_Updates.size()-1).substring(Player_Updates.get(Player_Updates.size()-1).indexOf(';') + 18, Player_Updates.get(Player_Updates.size()-1).indexOf(';') + 19));
            System.out.println(Name + " " + CurrentIsland);
            Player p = new Player(Name, getCrew(Crew_Updates), CurrentIsland);
        } catch (FileNotFoundException e){
            System.out.println("problem Loading");
        }
        return new Player();
    }
    private ArrayList<Crew> getCrew(ArrayList<String> Crew_Updates){
        ArrayList<Crew> crewArrayList = new ArrayList<Crew>();
        for(String s: Crew_Updates){
            String CrewName = s.substring(s.indexOf(':')+1, s.indexOf(';'));
            s = s.substring(s.indexOf(';'));
            String CrewRace = s.substring(s.indexOf(':')+1, s.indexOf(';'));
            s = s.substring(s.indexOf(';'));
            String personality = s.substring(s.indexOf(':')+1, s.indexOf(';'));
            s=s.substring(s.indexOf(';'));
            Item rightHand =  getItem(s.substring(s.indexOf(':')+1, s.indexOf(';')));
            s= s.substring(s.indexOf(';'));
            Item leftHand =  getItem(s.substring(s.indexOf(':')+1, s.indexOf(';')));
            s = s.substring(s.indexOf(';'));
            ArrayList<Integer> _attr = new ArrayList<Integer>();
            _attr.add(Integer.parseInt(s.substring(s.indexOf(':')+1, s.indexOf(';'))));
            s = s.substring(s.indexOf(';'));
            _attr.add(Integer.parseInt(s.substring(s.indexOf(':')+1, s.indexOf(';'))));
            s = s.substring(s.indexOf(';'));
            _attr.add(Integer.parseInt(s.substring(s.indexOf(':')+1, s.indexOf(';'))));
            s = s.substring(s.indexOf(';'));
            _attr.add(Integer.parseInt(s.substring(s.indexOf(':')+1, s.indexOf(';'))));
            s = s.substring(s.indexOf(';'));
            _attr.add(Integer.parseInt(s.substring(s.indexOf(':')+1, s.indexOf(';'))));
            crewArrayList.add(new Crew(CrewName, CrewRace, CrewJob,  ))
        }
    }
    private Item getItem(String ItemType){
       if(!ItemType.equals("null")) {
           switch (ItemType) {
               case "Cutlass":
                   return new Cutlass();
           }
           return new Cutlass();
       }
       else{
           return null;
       }


    }
}
