package Event;

import Action.*;
import Player.Player;

import java.util.ArrayList;


public class Chest extends EventDecorator {
    public Chest(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription(Player p) {return "A large chest rests before you."+this._decoratedEvent.getDescription(p);}
    public String getNorthDescription(Player p) {return this._decoratedEvent.getNorthDescription(p)+" A large wooden box lies on the ground there.";}
    public String getSouthDescription(Player p) {return this._decoratedEvent.getSouthDescription(p)+" A large wooden box lies on the ground there.";}
    public String getWestDescription(Player p) {return this._decoratedEvent.getWestDescription(p)+" A large wooden box lies on the ground there.";}
    public String getEastDescription(Player p) {return this._decoratedEvent.getEastDescription(p)+" A large wooden box lies on the ground there.";}
    public ArrayList<GameAction> getActions() {
        GameAction chest = new OpenChest(_map, _mapPos);
        ArrayList<GameAction> gameActionList = this._decoratedEvent.getActions();
        gameActionList.add(chest);
        return gameActionList; // No additional actions
    }
}
