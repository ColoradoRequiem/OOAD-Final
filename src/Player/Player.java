package Player;

import java.util.ArrayList;
import Crew.*;

public class Player {
    private String _name;
    private ArrayList<Crew> _crew = new ArrayList<Crew>();
    private int _currIsland;
    public Player() {
        _name = "Admin";//Admin
        _crew.add(new Crew());
        _crew.add(new Crew());
        _currIsland = 0;
    }
    public Player(String _name, ArrayList<Crew> _crew, int _currIsland){
        this._name =_name;
        this._crew = _crew;
        this._currIsland = _currIsland;
    }

    public String getName() {return _name;}
    public ArrayList<Crew> getCrew() {return _crew;}
    public int getCurrentIsland(){return _currIsland;}

}
