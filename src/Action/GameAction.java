package Action;

import Event.Event;
import Requirement.Requirement;
import Player.*;

import java.util.ArrayList;
import java.util.*;

public abstract class GameAction {
    protected String _description;
    protected String _buttonDescription;
    protected Requirement _req;

    public abstract ArrayList<Integer> click(Player p); // always return new position
    public abstract String getDescription(Player p);
    public String getButtonDescription() {
        return _buttonDescription;
    }
    public boolean getTruth(Player p) {
        if (_req==null) {return true;}
        else if (_req.getValue(p)==true) {return true;}
        else {return false;}
    }
    public void setButtonDescription(String text) {
        _buttonDescription = text;
    }
}

abstract class GameActionDeterminate extends GameAction {
    protected ArrayList<ArrayList<Event>> _map;
    protected ArrayList<Integer> _mapPos = new ArrayList<>();

    // public ArrayList<Integer> getMapPos() {return _mapPos;}
}
