package IslandType;
import Event.*;
import com.company.Utils;
import java.util.ArrayList;

public class StarIsland extends Utils implements CreateIsland  {
    public ArrayList<ArrayList<Event>> make(int size) { // make size always odd to have a center
        ArrayList<ArrayList<Event>> map = new ArrayList<ArrayList<Event>>();
        for (int i=0; i<size; i++) {
            ArrayList<Event> row = new ArrayList<Event>();
            for (int j=0; j<size; j++) {
                if (i==0 & j==0) {
                    row.add(new Admin(new BasicWater(new Event(i, j, size, map))));
                }
                else {
                    row.add(new BasicWater(new Event(i, j, size, map)));
                }
            }
            map.add(row);
        }


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
