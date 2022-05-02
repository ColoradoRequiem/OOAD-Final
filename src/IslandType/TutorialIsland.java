package IslandType;
import Event.*;
import com.company.Utils;
import java.util.ArrayList;
import java.util.*;

public class TutorialIsland extends Utils implements CreateIsland  {
    private int size = 4;
    private ArrayList<Integer> startPos = new ArrayList<Integer>();
    public ArrayList<ArrayList<Event>> make() {
        startPos.add(3);
        startPos.add(0);
        ArrayList<ArrayList<Event>> map = new ArrayList<ArrayList<Event>>();

        // RACE: Dwarf
        // ***** DAY *********
        // w, s, s, w, w, w, w
        // M, t, ^, t, s, s, w
        // s, x, t, e, e, e, M
        // p, M, e, e, e, s, w
        // M, s, s, c, e, s, w
        // w, w, w, s, g, s, w
        // w, w, w, w, s, w, w

        ArrayList<Event> row0 = new ArrayList<Event>();
        row0.add(new BasicWater(new Event(0,0, size, map)));
        row0.add(new Coast(new Event(0,1, size, map)));
        row0.add(new Coast(new Event(0,2, size, map)));
        row0.add(new BasicWater(new Event(0,3, size, map)));
//        row0.add(new BasicWater(new Event(0,4, size, map)));
//        row0.add(new BasicWater(new Event(0,5, size, map)));
//        row0.add(new BasicWater(new Event(0,6, size, map)));
        map.add(row0);

        ArrayList<Event> row1 = new ArrayList<Event>();
        row1.add(new Cliff(new Event(1,0, size, map)));
        row1.add(new Forest(new Event(1,1, size, map)));
        row1.add(new HiddenDoor(new Forest(new Event(1,2, size, map))));
        row1.add(new Forest(new Event(1,3, size, map)));
//        row1.add(new BasicWater(new Event(1,4, size, map)));
//        row1.add(new BasicWater(new Event(1,5, size, map)));
//        row1.add(new BasicWater(new Event(1,6, size, map)));
        map.add(row1);

        ArrayList<Event> row2 = new ArrayList<Event>();
        row2.add(new Coast(new Event(2,0, size, map)));
        row2.add(new Chest(new BasicLand(new Event(2,1, size, map))));
        row2.add(new Forest(new Event(2,2, size, map)));
        row2.add(new BasicLand(new Event(2,3, size, map)));

        map.add(row2);

        ArrayList<Event> row3 = new ArrayList<Event>();
        row3.add(new BasicWater(new Event(3,0, size, map)));
        row3.add(new Cliff(new Event(3,1, size, map)));
        row3.add(new BasicLand(new Event(3,2, size, map)));
        row3.add(new BasicLand(new Event(3,3, size, map)));

        map.add(row3);

        // p=player , x=chest , t=forest , c=cave , g=goblins , a=abandoned hut
        // * = village , v = pitfall , > running bulls (push you right an event, happens once)
        // ^ = Mountain (has hidden stairway), m = mimic ,

        // Village (factory pattern):
            // Randomly choose race of village, maybe based off race of island
            // General Store : Randomly create a shop-keeper

        // Cave: entrance -> hallway -> split
        // (Choose) right -> Boulder cut off path behind (time to remove) -> Carvings -> Skeleton ->

        // (Choose) left -> Stairway down -> stairway down w/ spikes from wall w/ dead body -> door -> mimic

        // * need to make an 'ahead' action
        // water needs to have the requirement of a ship
        // when we land, we should save the ship and remove it rom the player
        // only to give it back to them when they return to that spot and take the action




        return map;
    }
    public int getSize() {return size;}
    public ArrayList<Integer> getStart() {return startPos;}
}
