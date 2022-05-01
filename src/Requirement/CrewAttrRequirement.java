package Requirement;

import Player.Player;
import Crew.*;
import java.util.ArrayList;

public class CrewAttrRequirement implements Requirement {
    private String _attr;
    private int _req;
    public CrewAttrRequirement(String attr, int req) {
        _attr = attr;
        _req = req;
    }
    public boolean getValue(Player p) {
        ArrayList<Crew> playerCrew = p.getCrew();
        for (int i=0; i<playerCrew.size(); i++) {
            Crew c = playerCrew.get(i);
            if (c.getAttr(_attr)>=_req) {
                return true;
            }
        }
        return false;
    }
}