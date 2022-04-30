package Action;

import Event.Event;

import java.util.ArrayList;
import java.util.*;

public class MoveEast extends GameActionDeterminate {
    public MoveEast(ArrayList<ArrayList<Event>> map, ArrayList<Integer> mapPos) {
        _mapPos = mapPos;
        _map = map;
        _buttonDescription = "Move east.";
        _req = _map.get(_mapPos.get(0)).get(_mapPos.get(1)+1).getApproachableReq();
        // _req = _map.get(_mapPos.get(0)).get(_mapPos.get(1)+1).getApproachableReq();
    }

    public String getDescription() {
        _description = _map.get(_mapPos.get(0)).get(_mapPos.get(1)+1).getWestDescription();
        // _description = _map.get(_mapPos.get(0)).get(_mapPos.get(1)+1).getWestDescription(); // traveling east
        return _description;
    }

    public ArrayList<Integer> click() {

        ArrayList<Integer> newPos = new ArrayList<Integer>();
        newPos.add(_mapPos.get(0));
        newPos.add(_mapPos.get(1)+1);
        return newPos;

    }
}