package Event;

import Action.Action;

import java.util.ArrayList;

public class BasicLand extends EventDecorator {
    public BasicLand(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription() {return "The land here is basic."+this._decoratedEvent.getDescription();}
    public String getNorthDescription() {return this._decoratedEvent.getNorthDescription()+"To the south you see land.";}
    public String getSouthDescription() {return this._decoratedEvent.getSouthDescription()+"To the north you see land.";}
    public String getWestDescription() {return this._decoratedEvent.getWestDescription()+"To the east you see land.";}
    public String getEastDescription() {return this._decoratedEvent.getEastDescription()+"To the west you see land.";}
    public ArrayList<Action> getActions() {
        return this._decoratedEvent.getActions(); // No additional actions
    }

}
