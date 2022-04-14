package Requirement;

import java.util.ArrayList;
import Player.Player;
import Crew.*;

public class CliffRequirement implements Requirement {
    public boolean getValue(Player p) {
//        ArrayList<Crew> playerCrew = p.getCrew();
//        for (int i=0; i<playerCrew.size(); i++) {
//            if (playerCrew.get(i).getJob().equals("Climber")) {
//                return true;
//            }
//        }
        return false;
    }
}
