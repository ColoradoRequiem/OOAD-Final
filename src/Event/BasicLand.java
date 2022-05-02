package Event;

import Action.GameAction;
import Player.Player;

import java.util.ArrayList;


public class BasicLand extends EventDecorator {
    public BasicLand(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription(Player p) {return "The ground here is covered with tall light green grass."+this._decoratedEvent.getDescription(p);}
    public String getNorthDescription(Player p) {return this._decoratedEvent.getNorthDescription(p)+"To the south you see grass.";}
    public String getSouthDescription(Player p) {return this._decoratedEvent.getSouthDescription(p)+"To the north you see grass.";}
    public String getWestDescription(Player p) {return this._decoratedEvent.getWestDescription(p)+"To the east you see grass.";}
    public String getEastDescription(Player p) {return this._decoratedEvent.getEastDescription(p)+"To the west you see grass.";}
    public ArrayList<GameAction> getActions() {
        return this._decoratedEvent.getActions(); // No additional actions
    }

}
