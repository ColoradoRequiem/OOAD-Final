package Event;

import Action.*;
import Player.Player;

import java.util.ArrayList;


public class Chest extends EventDecorator {
    public Chest(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription(Player p) {return this._decoratedEvent.getDescription(p);}
    public String getNorthDescription(Player p) {return this._decoratedEvent.getNorthDescription(p)+" A large wooden box lies on the ground there.";}
    public String getSouthDescription(Player p) {return this._decoratedEvent.getSouthDescription(p);}
    public String getWestDescription(Player p) {return this._decoratedEvent.getWestDescription(p);}
    public String getEastDescription(Player p) {return this._decoratedEvent.getEastDescription(p);}
    public ArrayList<GameAction> getActions() {
        GameAction admin = new Action.Admin(_map, _mapPos);
        ArrayList<GameAction> gameActionList = this._decoratedEvent.getActions();
        gameActionList.add(admin);
        return gameActionList; // No additional actions
    }
}
