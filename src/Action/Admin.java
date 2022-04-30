package Action;

import java.util.ArrayList;
import Event.Event;
import Requirement.NameRequirement;
import java.util.*;

public class Admin extends GameActionDeterminate {
    public Admin(ArrayList<ArrayList<Event>> map, ArrayList<Integer> mapPos) {
        _mapPos = mapPos;
        _map = map;

        _req = new NameRequirement();
        _buttonDescription = "(Admin: Win Game).";
    }

    public String getDescription() {
        return _description;
    }

    public ArrayList<Integer> click() { // exit
        return null;
    }
}
