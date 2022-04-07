package Action;

import java.util.ArrayList;
import Event.Event;
import Requirement.NameRequirement;

public class ActionAdmin extends Action {
    public ActionAdmin(ArrayList<ArrayList<Event>> map, ArrayList<Integer> mapPos) {
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
