package Requirement;

import Player.Player;
import Crew.*;
import java.util.ArrayList;

public class ItemRequirement implements Requirement {
    private String _item;
    public ItemRequirement(String item) {
        _item = item;
    }
    public boolean getValue(Player p) {
        ArrayList<Crew> playerCrew = p.getCrew();
        for (int i=0; i<playerCrew.size(); i++) {
            Crew c = playerCrew.get(i);
            if (c.getRightHandItem().equals(_item) || c.getLeftHandItem().equals(_item)) {
                return true;
            }
        }
        return false;
    }
}
