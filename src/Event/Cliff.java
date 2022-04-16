package Event;

import Action.GameAction;
import Requirement.*;

import java.util.ArrayList;

public class Cliff extends EventDecorator {
    public Cliff(Event e) {

        e.setApproachableReq(new CliffRequirement());
        _decoratedEvent = e;
    }
    public String getDescription() {return "The cliffs here are impassable."+this._decoratedEvent.getDescription();}
    public String getNorthDescription() {return this._decoratedEvent.getNorthDescription()+"To the south you see towering cliffs.";}
    public String getSouthDescription() {return this._decoratedEvent.getSouthDescription()+"To the north you see towering cliffs.";}
    public String getWestDescription() {return this._decoratedEvent.getWestDescription()+"To the east you see towering cliffs.";}
    public String getEastDescription() {return this._decoratedEvent.getEastDescription()+"To the west you see towering cliffs.";}
    public ArrayList<Action> getActions() {
        return this._decoratedEvent.getActions();
    }
    public Requirement getApproachableReq() {return _decoratedEvent.getApproachableReq();} // just like actions and desc.
}
