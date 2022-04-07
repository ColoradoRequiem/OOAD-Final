package IslandType;

import Action.*;
import Event.Event;
import IslandType.*;
import Player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        explore();
    }
    public Island(Season s) {
        _player = new Player();
        _season = s;
        _map = make(new Star());
        _position.add(0);
        _position.add(0);
        explore();
    }

    public void explore() {

        while(true) {
            System.out.println("Explore: "+_position);
            System.out.print(_map.get(_position.get(0)).get(_position.get(1)).getDescription()+"\n");

            ArrayList<Action> actionList = _map.get(_position.get(0)).get(_position.get(1)).getActions();

            ArrayList<Integer> count = new ArrayList<Integer>();
            int printCount = 0;
            for (int i=0; i< actionList.size(); i++) {
                if (actionList.get(i).getTruth(_player)) {
                    System.out.println(printCount + ": " + actionList.get(i).getButtonDescription());
                    printCount += 1;
                    count.add(i);
                }
            }
            // choose action
            int action = readInput();
            ArrayList<Integer> newPos = actionList.get(count.get(action)).click();
            _position = newPos;
        }
    }

    public ArrayList<ArrayList<Event>> make(CreateIsland type) {
        return type.make(_size);
    }

    public int readInput(){
        // https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/#:~:text=1%20Using%20Buffered%20Reader%20Class%20This%20is%20the,command%20line.%20...%204%20Using%20Command%20line%20argument
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int i = Integer.parseInt(br.readLine()); // for Integer Input
            return i;
        } catch(IOException ioe) {
            return -1;
        }

    }
}
