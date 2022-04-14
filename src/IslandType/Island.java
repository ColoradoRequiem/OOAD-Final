package IslandType;

import Action.*;
import Event.Event;
import IslandType.*;
import Player.Player;


import java.util.ArrayList;


public class Island {
    public Season _season;
    private ArrayList<ArrayList<Event>> _map;
    int _size = 7;

    private Player _player;
    private ArrayList<Integer> _position = new ArrayList<Integer>();


    public Island() {
        _player = new Player();
        _season = Utils.randSeason();
        _map = make(new Star());
        _position.add(0);
        _position.add(0);
    }
    public Island(Season s) {
        _player = new Player();
        _season = s;
        _map = make(new Star());
        _position.add(0);
        _position.add(0);
    }

    public String getDescription() {
        return _map.get(_position.get(0)).get(_position.get(1)).getDescription() + "\n";
    }

    public ArrayList<Action> getAvailableActions() {
        ArrayList<Action> actionList = _map.get(_position.get(0)).get(_position.get(1)).getActions();
        ArrayList<Action> ret = new ArrayList<Action>();

        for (int i=0; i< actionList.size(); i++) {
            if (actionList.get(i).getTruth(_player)) {
                ret.add(actionList.get(i));
            }
        }
        _map.get(_position.get(0)).get(_position.get(1)).setActions(); // might not be needed
        return ret;
    }

    public ArrayList<Integer> getPosition() {
        return _position;
    }

    public ArrayList<ArrayList<Event>> make(CreateIsland type) {
        return type.make(_size);
    }
    public void setPosition(int x, int y) {
        _position.set(0, x);
        _position.set(1, y);
    }


}
