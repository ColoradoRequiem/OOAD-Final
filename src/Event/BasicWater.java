package Event;

import Action.GameAction;
import Player.Player;

import java.util.ArrayList;

public class BasicWater extends EventDecorator {
    public BasicWater(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription(Player p) {return "The water is deep blue here. You cannot see the bottom."+this._decoratedEvent.getDescription(p);}
    public String getNorthDescription(Player p) {return this._decoratedEvent.getNorthDescription(p)+"To the south you see water.";}
    public String getSouthDescription(Player p) {return this._decoratedEvent.getSouthDescription(p)+"To the north you see water.";}
    public String getWestDescription(Player p) {return this._decoratedEvent.getWestDescription(p)+"To the east you see water.";}
    public String getEastDescription(Player p) {return this._decoratedEvent.getEastDescription(p)+"To the west you see water.";}
    public ArrayList<GameAction> getActions() {
        return this._decoratedEvent.getActions(); // No additional actions
    }

}
