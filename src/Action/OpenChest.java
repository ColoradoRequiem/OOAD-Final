package Action;

import java.util.ArrayList;
import Event.Event;
import Player.Player;
import Item.*;

import Requirement.CliffRequirement;
import Requirement.CrewAttrRequirement;
import Requirement.NameRequirement;
import java.util.*;
import Event.*;

public class OpenChest extends GameActionDeterminate {
    private boolean _hasBeenOpened;
    private int _state;
    public OpenChest(ArrayList<ArrayList<Event>> map, ArrayList<Integer> mapPos, int state, boolean beenOpened) {
        _mapPos = mapPos;
        _map = map;
        _hasBeenOpened = beenOpened;
        _state = state;
        if (_state == 0) {
            _buttonDescription = "Open chest.";
        }
        else {
            _buttonDescription = "Close chest.";
        }
    }

    public String getDescription(Player p) {
        return _description;
    }

    public ArrayList<Integer> click(Player p) {
        if (!_hasBeenOpened) {
            p.getCrew().get(0).setLeftHandItem(new Cutlass());
        }
        return null;
    }

}
