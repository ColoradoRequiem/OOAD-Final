package Event;

import Action.GameAction;
import Player.Player;

import java.util.ArrayList;


public class BasicLand extends EventDecorator {
    public BasicLand(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription(Player p) {return "The land here is basic."+this._decoratedEvent.getDescription(p);}
    public String getNorthDescription(Player p) {return this._decoratedEvent.getNorthDescription(p)+"To the south you see land.";}
    public String getSouthDescription(Player p) {return this._decoratedEvent.getSouthDescription(p)+"To the north you see land.";}
    public String getWestDescription(Player p) {return this._decoratedEvent.getWestDescription(p)+"To the east you see land.";}
    public String getEastDescription(Player p) {return this._decoratedEvent.getEastDescription(p)+"To the west you see land.";}
    public ArrayList<GameAction> getActions() {
        return this._decoratedEvent.getActions(); // No additional actions
    }

}
