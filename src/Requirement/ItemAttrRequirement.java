package Requirement;

import Player.Player;
import Crew.*;
import java.util.ArrayList;

public class ItemAttrRequirement implements Requirement {
    private String _attr;
    public ItemAttrRequirement(String attr) {
        _attr = attr;
    }
    public boolean getValue(Player p) {
        ArrayList<Crew> playerCrew = p.getCrew();
        for (int i=0; i<playerCrew.size(); i++) {
            Crew c = playerCrew.get(i);
            if (c.getRightHandItem() != null) {
                for (String a : c.getRightHandItem().getAttr()) {
                    if (a.equals(_attr)) {return true;}
                }
            }
            if (c.getLeftHandItem() != null) {
                for (String a : c.getLeftHandItem().getAttr()) {
                    if (a.equals(_attr)) {return true;}
                }
            }
        }
        return false;
    }
}
