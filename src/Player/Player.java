package Player;

import java.util.ArrayList;
import Crew.*;

public class Player {
    private String _name;
    private ArrayList<Crew> _crew = new ArrayList<Crew>();

    public Player() {
        _name = "Admin";
        _crew.add(new Crew());
    }

    public String getName() {return _name;}
    public ArrayList<Crew> getCrew() {return _crew;}

}
