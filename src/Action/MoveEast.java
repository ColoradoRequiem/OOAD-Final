package Action;

import Event.Event;

import java.util.ArrayList;

public class MoveEast extends GameAction {
    public MoveEast(ArrayList<ArrayList<Event>> map, ArrayList<Integer> mapPos) {
        _mapPos = mapPos;
        _map = map;
        _buttonDescription = "Move east.";
        _req = _map.get(_mapPos.get(0)).get(_mapPos.get(1)+1).getApproachableReq();

        // System.out.println(mapPos.get(0)+" "+(mapPos.get(1)+1)+" "+_req);
    }

    public String getDescription() {
        _description = _map.get(_mapPos.get(0)).get(_mapPos.get(1)+1).getWestDescription(); // traveling east
        return _description;
    }

    public ArrayList<Integer> click() {
        ArrayList<Integer> newPos = new ArrayList<Integer>();
        newPos.add(_mapPos.get(0));
        newPos.add(_mapPos.get(1)+1);
        return newPos;

    }
}