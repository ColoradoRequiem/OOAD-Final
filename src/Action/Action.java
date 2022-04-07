package Action;

import Event.Event;
import IslandType.*;

import java.util.ArrayList;

public abstract class Action {
    protected String _description;
    protected String _buttonDescription;
    protected ArrayList<ArrayList<Event>> _map;
    protected ArrayList<Integer> _mapPos;

    public abstract ArrayList<Integer> click(); // always return new position
    public abstract String getDescription();
    public String getButtonDescription() {
        return _buttonDescription;
    }
}
