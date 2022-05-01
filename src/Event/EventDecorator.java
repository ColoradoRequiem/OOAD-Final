package Event;
import Action.*;
import Player.Player;

import java.util.ArrayList;

public abstract class EventDecorator extends Event {
    protected Event _decoratedEvent;

    public abstract String getDescription(Player p);
    public abstract String getNorthDescription(Player p);
    public abstract String getSouthDescription(Player p);
    public abstract String getWestDescription(Player p);
    public abstract String getEastDescription(Player p);
    public abstract ArrayList<GameAction> getActions();
}
