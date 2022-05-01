package Action;

import java.util.ArrayList;
import Event.Event;
import Player.Player;
import Requirement.CrewAttrRequirement;
import Requirement.NameRequirement;
import java.util.*;

public class OpenDoor extends GameActionDeterminate {
    public OpenDoor(ArrayList<ArrayList<Event>> map, ArrayList<Integer> mapPos) {
        _mapPos = mapPos;
        _map = map;
        _buttonDescription = "Open the door.";
        _req = new CrewAttrRequirement("WIS", 1);
    }

    public String getDescription(Player p) {
        return _description;
    }

    public ArrayList<Integer> click(Player p) { // exit
        return null;
    }
}
