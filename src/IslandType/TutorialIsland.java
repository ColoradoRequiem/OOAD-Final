package IslandType;
import Event.*;
import com.company.Utils;
import java.util.ArrayList;
import java.util.*;

public class TutorialIsland extends Utils implements CreateIsland  {
    public ArrayList<ArrayList<Event>> make(int size) { // make size always odd to have a center
        size = 7;
        ArrayList<ArrayList<Event>> map = new ArrayList<ArrayList<Event>>();

        // RACE: Dwarf
        // ***** DAY *********
        // w, s, s, w, w, w, w
        // M, ^, t, s, s, s, w
        // p, x, t, e, e, e, M
        // M, s, e, e, e, s, w
        // w, w, s, c, e, s, w
        // w, w, w, s, g, s, w
        // w, w, w, w, s, w, w

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

        ArrayList<Event> row = new ArrayList<Event>();
        row.add(new Admin(new BasicWater(new Event(i, j, size, map))));
        map.put(Arrays.asList(0, 0), new BasicWater(new Event(0,0, size, map)));



        int center = Math.floorDiv(size, 2);
        int islandSize = Math.floorDiv(size, 2);
        int tmpSize = islandSize;

        for (int i=0; i<islandSize+1; i++) {
            for (int j=tmpSize; j>0; j--) {
                // map.get(center).set(center, new BasicLand(new Event(i, j, size, map)));

                map.get(center-i).set(center, new BasicLand(new Event(center-i, center, size, map)));
                map.get(center+i).set(center, new BasicLand(new Event(center+i, center, size, map)));

                map.get(center).set(center-j, new BasicLand(new Event(center, center-j, size, map)));
                map.get(center).set(center+j, new BasicLand(new Event(center, center+j, size, map)));

                if (i-1>0) {
                    map.get(center-i+1).set(center+j-1, new Coast(new Event(center-i+1, center+j-1, size, map)));
                    map.get(center-i+1).set(center-j+1, new Coast(new Event(center-i+1, center-j+1, size, map)));
                    map.get(center+i-1).set(center+j-1, new Coast(new Event(center+i-1, center+j-1, size, map)));
                    map.get(center+i-1).set(center-j+1, new Coast(new Event(center+i-1, center-j+1, size, map)));
                }
            }
            if (i-1>0) {
                tmpSize-=1;
            }
        }

        return map;
    }
}
