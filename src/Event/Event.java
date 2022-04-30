package Event;

import Action.*;
import Requirement.Requirement;

import java.util.ArrayList;
import java.util.*;

public class Event {
    private ArrayList<GameAction> _Game_actions = new ArrayList<GameAction>();
    private String _description;
    private String _northDescription;
    private String _southDescription;
    private String _westDescription;
    private String _eastDescription;

    protected Requirement _approachReq = null;

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

        // _approachable = true;
    }
    public String getDescription() {
        String desc = _description;
        ArrayList<GameAction> gameActionList = getActions();
        for (GameAction a : gameActionList) { // need get actions for decorator here
            desc += " "+a.getDescription();
        }
        return desc;
    }

    public String getNorthDescription() {return _northDescription;}
    public String getSouthDescription() {return _southDescription;}
    public String getWestDescription() {return _westDescription;}
    public String getEastDescription() {return _eastDescription;}

    public void getMoveActions() {
        if (0<=_mapPos.get(0) && _mapPos.get(0)<_size-1) { // need some boolean for if this move is possible
            _Game_actions.add(new MoveSouth(_map, _mapPos));
        }
        if (0<_mapPos.get(0) && _mapPos.get(0)<=_size-1) {
            _Game_actions.add(new MoveNorth(_map, _mapPos));
        }
        if (0<=_mapPos.get(1) && _mapPos.get(1)<_size-1) {
            _Game_actions.add(new MoveEast(_map, _mapPos));
        }
        if (0<_mapPos.get(1) && _mapPos.get(1)<=_size-1) {
            _Game_actions.add(new MoveWest(_map, _mapPos));
        }
    }

    public ArrayList<GameAction> getActions() {
        _Game_actions = new ArrayList<GameAction>();
        getMoveActions();
        return _Game_actions;
    }
    public void setActions() {
        _Game_actions = new ArrayList<GameAction>();}
    public void setApproachableReq(Requirement r) {_approachReq = r;}
    public Requirement getApproachableReq() {return _approachReq;}



}
