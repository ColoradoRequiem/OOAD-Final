package IslandType;

import Action.*;
import Event.Event;
import Player.Player;


import java.lang.reflect.Array;
import java.util.ArrayList;


public class Island {
    public Season _season;
    private ArrayList<ArrayList<Event>> _map;
    int _size;

    private Player _player;
    private ArrayList<Integer> _position = new ArrayList<Integer>();


    public Island() {
        _player = new Player();
        // _season = Utils.randSeason();
        TutorialIsland tut = new TutorialIsland();
        _position = tut.getStart();
        _size = tut.getSize();
        _map = make(tut);

    }
    public Island(Season s) {
        _player = new Player();
        _season = s;
        TutorialIsland tut = new TutorialIsland();
        _position = tut.getStart();
        _size = tut.getSize();
        _map = make(tut);
    }

    public String getDescription(Player p) {
        return _map.get(_position.get(0)).get(_position.get(1)).getDescription(p) + "\n";
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
        ArrayList<ArrayList<Event>> ret = type.make();
        // System.out.println(ret.size());
        _size = ret.size();
        return ret;
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
