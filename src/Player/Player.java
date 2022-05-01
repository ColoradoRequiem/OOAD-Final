package Player;

import java.util.ArrayList;
import Crew.*;
import Item.*;

public class Player {
    private String _name;
    private ArrayList<Crew> _crew = new ArrayList<Crew>();
    private ArrayList<Item> _inventory = new ArrayList<Item>();

    public Player() {
        _name = "Admin";//Admin
        _crew.add(new Crew());
        _crew.add(new Crew());
    }

    public String getName() {return _name;}
    public ArrayList<Crew> getCrew() {return _crew;}
    public void addItem(Item i) {_inventory.add(i);}


}
