package Event;

import Action.GameAction;

import java.util.ArrayList;

public class Coast extends EventDecorator {
    public Coast(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription() {return "The water is shallow. You can drop anchor here and go ashore."+this._decoratedEvent.getDescription();}
    public String getNorthDescription() {return this._decoratedEvent.getNorthDescription()+"To the south you see a breadth of approachable shoreline.";}
    public String getSouthDescription() {return this._decoratedEvent.getSouthDescription()+"To the north you see a breadth of approachable shoreline.";}
    public String getWestDescription() {return this._decoratedEvent.getWestDescription()+"To the east you see a breadth of approachable shoreline.";}
    public String getEastDescription() {return this._decoratedEvent.getEastDescription()+"To the west you see a breadth of approachable shoreline.";}
    public ArrayList<GameAction> getActions() {
        return this._decoratedEvent.getActions(); // Drop anchor -> Go ashore
    }
}
