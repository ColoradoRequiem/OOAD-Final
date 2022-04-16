package Action;

import Event.Event;

import java.util.ArrayList;

public class MoveWest extends GameAction {
    public MoveWest(ArrayList<ArrayList<Event>> map, ArrayList<Integer> mapPos) {
        _mapPos = mapPos;
        _map = map;
        _buttonDescription = "Move west.";
        _req = _map.get(_mapPos.get(0)).get(_mapPos.get(1)-1).getApproachableReq();
    }

    public String getDescription() {
        _description = _map.get(_mapPos.get(0)).get(_mapPos.get(1)-1).getEastDescription(); // traveling west
        return _description;
    }

    public ArrayList<Integer> click() {
        ArrayList<Integer> newPos = new ArrayList<Integer>();
        newPos.add(_mapPos.get(0));
        newPos.add(_mapPos.get(1)-1);
        return newPos;

    }
}