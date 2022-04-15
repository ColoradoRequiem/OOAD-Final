package Action;

import Event.Event;

import java.util.ArrayList;

public class MoveSouth extends GameAction {
    public MoveSouth(ArrayList<ArrayList<Event>> map, ArrayList<Integer> mapPos) {
        _mapPos = mapPos;
        _map = map;
        _buttonDescription = "Move south.";
        _req = _map.get(_mapPos.get(0)+1).get(_mapPos.get(1)).getApproachableReq();
    }

    public String getDescription() {
        _description = _map.get(_mapPos.get(0)+1).get(_mapPos.get(1)).getNorthDescription(); // traveling south
        return _description;
    }

    public ArrayList<Integer> click() {
        ArrayList<Integer> newPos = new ArrayList<Integer>();
        newPos.add(_mapPos.get(0)+1);
        newPos.add(_mapPos.get(1));
        return newPos;
    }
}
