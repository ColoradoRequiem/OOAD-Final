package Event;

import Action.*;
import Requirement.Requirement;

import java.util.ArrayList;
import java.util.*;

import Player.*;

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
    public String getDescription(Player p) {
        String desc = _description;
        ArrayList<GameAction> gameActionList = getActions();
        for (GameAction a : gameActionList) { // need get actions for decorator here
            desc += " "+a.getDescription(p);
        }
        return desc;
    }

    public String getNorthDescription(Player p) {return _northDescription;}
    public String getSouthDescription(Player p) {return _southDescription;}
    public String getWestDescription(Player p) {return _westDescription;}
    public String getEastDescription(Player p) {return _eastDescription;}

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
