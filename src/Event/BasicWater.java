package Event;

import Action.Action;

import java.util.ArrayList;
import Player.*;

public class BasicWater extends EventDecorator {
    public BasicWater(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription() {return "The water is deep blue here. You cannot see the bottom."+this._decoratedEvent.getDescription();}
    public String getNorthDescription() {return this._decoratedEvent.getNorthDescription()+"To the south you see water.";}
    public String getSouthDescription() {return this._decoratedEvent.getSouthDescription()+"To the north you see water.";}
    public String getWestDescription() {return this._decoratedEvent.getWestDescription()+"To the east you see water.";}
    public String getEastDescription() {return this._decoratedEvent.getEastDescription()+"To the west you see water.";}
    public ArrayList<Action> getActions() {
        return this._decoratedEvent.getActions(); // No additional actions
    }

}
