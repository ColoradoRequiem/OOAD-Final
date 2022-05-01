package Event;

import Action.*;
import Player.Player;
import Requirement.*;

import java.util.ArrayList;


public class HiddenDoor extends EventDecorator {
    Requirement _seen = new CrewAttrRequirement("WIS", 1);
    public HiddenDoor(Event e) {
        _decoratedEvent = e;
    }
    public String getDescription(Player p) {
        if (_seen.getValue(p)==true) {
            return "In the dirt around your feet you see the faint etchings of a door, a handle barely protrudes from the grass."+this._decoratedEvent.getDescription(p);
        }
        else {
            return this._decoratedEvent.getDescription(p);
        }

    }
    public String getNorthDescription(Player p) {
        if (_seen.getValue(p)==true) {
            return this._decoratedEvent.getNorthDescription(p)+" A strange object protrudes from the ground there.";
        }
        else {
            return this._decoratedEvent.getNorthDescription(p);
        }
    }
    public String getSouthDescription(Player p) {
        if (_seen.getValue(p)==true) {
            return this._decoratedEvent.getSouthDescription(p)+" A strange object protrudes from the ground there.";
        }
        else {
            return this._decoratedEvent.getSouthDescription(p);
        }
    }
    public String getWestDescription(Player p) {
        if (_seen.getValue(p)==true) {
            return this._decoratedEvent.getWestDescription(p)+" A strange object protrudes from the ground there.";
        }
        else {
            return this._decoratedEvent.getWestDescription(p);
        }
    }
    public String getEastDescription(Player p) {
        if (_seen.getValue(p)==true) {
            return this._decoratedEvent.getEastDescription(p)+" A strange object protrudes from the ground there.";
        }
        else {
            return this._decoratedEvent.getEastDescription(p);
        }
    }
    public ArrayList<GameAction> getActions() {
        GameAction door = new OpenDoor(_map, _mapPos);
        ArrayList<GameAction> gameActionList = this._decoratedEvent.getActions();
        gameActionList.add(door);
        return gameActionList; // No additional actions
    }
}
