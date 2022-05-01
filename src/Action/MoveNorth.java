package Action;

import Event.Event;
import Player.Player;

import java.util.ArrayList;

public class MoveNorth extends GameActionDeterminate {
    public MoveNorth(ArrayList<ArrayList<Event>> map, ArrayList<Integer> mapPos) {
        _mapPos = mapPos;
        _map = map;
        _buttonDescription = "Move north.";
        _req = _map.get(_mapPos.get(0)-1).get(_mapPos.get(1)).getApproachableReq();
    }

    public String getDescription(Player p) {
        _description = _map.get(_mapPos.get(0)-1).get(_mapPos.get(1)).getSouthDescription(p); // traveling north
        return _description;
    }

    public ArrayList<Integer> click(Player p) {
        ArrayList<Integer> newPos = new ArrayList<Integer>();
        newPos.add(_mapPos.get(0)-1);
        newPos.add(_mapPos.get(1));
        return newPos;
    }
}