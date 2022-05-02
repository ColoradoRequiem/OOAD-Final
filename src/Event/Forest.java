package Event;

import Action.GameAction;
import Player.Player;
import Requirement.*;

import java.util.ArrayList;

public class Forest extends EventDecorator {
    public Forest(Event e) {
        e.setApproachableReq(new ItemAttrRequirement("Slashing"));
        _decoratedEvent = e;
    }
    public String getDescription(Player p) {return "The thick trees blot out the sunlight."+this._decoratedEvent.getDescription(p);}
    public String getNorthDescription(Player p) {return this._decoratedEvent.getNorthDescription(p)+"To the south thickly bunched trees block your way.";}
    public String getSouthDescription(Player p) {return this._decoratedEvent.getSouthDescription(p)+"To the north thickly bunched trees block your way.";}
    public String getWestDescription(Player p) {return this._decoratedEvent.getWestDescription(p)+"To the east thickly bunched trees block your way.";}
    public String getEastDescription(Player p) {return this._decoratedEvent.getEastDescription(p)+"To the west thickly bunched trees block your way.";}
    public ArrayList<GameAction> getActions() {
        return this._decoratedEvent.getActions();
    }
    public Requirement getApproachableReq() {return _decoratedEvent.getApproachableReq();} // just like actions and desc.
}
