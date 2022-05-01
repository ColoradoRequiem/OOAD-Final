package Action;

import java.util.ArrayList;
import Event.Event;
import Player.Player;
import Item.*;

import Requirement.CrewAttrRequirement;
import Requirement.NameRequirement;
import java.util.*;

public class OpenChest extends GameActionDeterminate {
    public OpenChest(ArrayList<ArrayList<Event>> map, ArrayList<Integer> mapPos) {
        _mapPos = mapPos;
        _map = map;
        _buttonDescription = "Open the chest.";
    }

    public String getDescription(Player p) {
        return _description;
    }

    public ArrayList<Integer> click(Player p) { // exit
        p.addItem(new Cutlass());
        return null;
    }
}
