package Event;

import Action.GameAction;
import Player.Player;
import Requirement.*;

import java.util.ArrayList;

public class Cliff extends EventDecorator {
    public Cliff(Event e) {

        e.setApproachableReq(new CliffRequirement());
        _decoratedEvent = e;
    }
    public String getDescription(Player p) {return "The cliffs here are impassable."+this._decoratedEvent.getDescription(p);}
    public String getNorthDescription(Player p) {return this._decoratedEvent.getNorthDescription(p)+"To the south you see towering cliffs.";}
    public String getSouthDescription(Player p) {return this._decoratedEvent.getSouthDescription(p)+"To the north you see towering cliffs.";}
    public String getWestDescription(Player p) {return this._decoratedEvent.getWestDescription(p)+"To the east you see towering cliffs.";}
    public String getEastDescription(Player p) {return this._decoratedEvent.getEastDescription(p)+"To the west you see towering cliffs.";}
    public ArrayList<GameAction> getActions() {
        return this._decoratedEvent.getActions();
    }
    public Requirement getApproachableReq() {return _decoratedEvent.getApproachableReq();} // just like actions and desc.
}
