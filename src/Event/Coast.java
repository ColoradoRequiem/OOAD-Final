package Event;

import Action.GameAction;

import java.util.ArrayList;
import Player.*;
import Requirement.Requirement;

public class Coast extends EventDecorator {
    public Coast(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription(Player p) {return "The water is shallow. You can drop anchor here and go ashore."+this._decoratedEvent.getDescription(p);}
    public String getNorthDescription(Player p) {return this._decoratedEvent.getNorthDescription(p)+"To the south you see a breadth of approachable shoreline.";}
    public String getSouthDescription(Player p) {return this._decoratedEvent.getSouthDescription(p)+"To the north you see a breadth of approachable shoreline.";}
    public String getWestDescription(Player p) {return this._decoratedEvent.getWestDescription(p)+"To the east you see a breadth of approachable shoreline.";}
    public String getEastDescription(Player p) {return this._decoratedEvent.getEastDescription(p)+"To the west you see a breadth of approachable shoreline.";}
    public ArrayList<GameAction> getActions() {
        return this._decoratedEvent.getActions(); // Drop anchor -> Go ashore
    }
    public Requirement getApproachableReq() {return _decoratedEvent.getApproachableReq();} // just like actions and desc.
}
