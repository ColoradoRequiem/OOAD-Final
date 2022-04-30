package IslandType;

import Action.*;
import Event.Event;
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

    public ArrayList<GameAction> getAvailableActions() {
        ArrayList<GameAction> gameActionList = _map.get(_position.get(0)).get(_position.get(1)).getActions();
        ArrayList<GameAction> ret = new ArrayList<GameAction>();

        for (int i = 0; i< gameActionList.size(); i++) {
            if (gameActionList.get(i).getTruth(_player)) {
                ret.add(gameActionList.get(i));
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
    public ArrayList<Integer> get_position(){
        return _position;
    }
    public Player get_player(){return _player;}
}
