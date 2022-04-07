package Event;

import Action.*;

import java.util.ArrayList;


public class Admin extends EventDecorator {
    public Admin(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription() {return this._decoratedEvent.getDescription();}
    public String getNorthDescription() {return this._decoratedEvent.getNorthDescription();}
    public String getSouthDescription() {return this._decoratedEvent.getSouthDescription();}
    public String getWestDescription() {return this._decoratedEvent.getWestDescription();}
    public String getEastDescription() {return this._decoratedEvent.getEastDescription();}
    public ArrayList<Action> getActions() {
        Action admin = new ActionAdmin(_map, _mapPos);
        ArrayList<Action> actionList = this._decoratedEvent.getActions();
        actionList.add(admin);
        return actionList; // No additional actions
    }
}
