package Event;

import Action.*;
import java.util.ArrayList;

public class Event {
    private ArrayList<Action> _actions = new ArrayList<Action>();
    private String _description;
    private String _northDescription;
    private String _southDescription;
    private String _westDescription;
    private String _eastDescription;

    protected ArrayList<Integer> _mapPos = new ArrayList<Integer>();
    private int _size;
    protected ArrayList<ArrayList<Event>> _map;

    public Event() { // used for item decorator
    }


    public Event(int x, int y, int size, ArrayList<ArrayList<Event>> map) {
        _mapPos.add(x);
        _mapPos.add(y);
        _size = size;
        _map = map;

        _description = "";
        _northDescription = "";
        _southDescription = "";
        _westDescription = "";
        _eastDescription = "";

        // These are the basic actions and what the decorator adds onto
        if (0<=_mapPos.get(0) && _mapPos.get(0)<_size-1) {
            _actions.add(new MoveSouth(_map, _mapPos));
        }
        if (0<_mapPos.get(0) && _mapPos.get(0)<=_size-1) {
            _actions.add(new MoveNorth(_map, _mapPos));
        }
        if (0<=_mapPos.get(1) && _mapPos.get(1)<_size-1) {
            _actions.add(new MoveEast(_map, _mapPos));
        }
        if (0<_mapPos.get(1) && _mapPos.get(1)<=_size-1) {
            _actions.add(new MoveWest(_map, _mapPos));
        }
    }
    public String getDescription() {
        String desc = _description;
        ArrayList<Action> actionList = this.getActions();
        for (Action a : actionList) { // need get actions for decorator here
            desc += " "+a.getDescription();
        }

        return desc;
    }
    public String getNorthDescription() {return _northDescription;}
    public String getSouthDescription() {return _southDescription;}
    public String getWestDescription() {return _westDescription;}
    public String getEastDescription() {return _eastDescription;}

    public ArrayList<Action> getActions() {return _actions;}


}
