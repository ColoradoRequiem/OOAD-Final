package Event;

import Action.Action;
import Player.Player;
import Requirement.*;

import java.util.ArrayList;

public class Cliff extends EventDecorator {
    public Cliff(Event e) {

        e.setApproachableReq(new CliffRequirement());
        // System.out.println(_mapPos.get(0)+" "+_mapPos.get(1)+" "+e.getApproachableReq());
        _decoratedEvent = e;
    }
    public String getDescription() {return "The cliffs here are impassable."+this._decoratedEvent.getDescription();}
    public String getNorthDescription() {return this._decoratedEvent.getNorthDescription()+"To the south you see towering cliffs.";}
    public String getSouthDescription() {return this._decoratedEvent.getSouthDescription()+"To the north you see towering cliffs.";}
    public String getWestDescription() {return this._decoratedEvent.getWestDescription()+"To the east you see towering cliffs.";}
    public String getEastDescription() {return this._decoratedEvent.getEastDescription()+"To the west you see towering cliffs.";}
    public ArrayList<Action> getActions() {
        return this._decoratedEvent.getActions(); // Drop anchor -> Go ashore
    }
}
