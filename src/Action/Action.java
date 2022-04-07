package Action;

import Event.Event;
import IslandType.*;
import Requirement.Requirement;
import Player.*;

import java.util.ArrayList;

public abstract class Action {
    protected String _description;
    protected String _buttonDescription;
    protected ArrayList<ArrayList<Event>> _map;
    protected ArrayList<Integer> _mapPos;
    protected Requirement _req = null;


    public abstract ArrayList<Integer> click(); // always return new position
    public abstract String getDescription();
    public String getButtonDescription() {
        return _buttonDescription;
    }
    public boolean getTruth(Player p) {
        if (_req==null) {return true;}
        else if (_req.getValue(p)==true) {return true;}
        else {return false;}
    }
}
