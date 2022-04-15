package Event;
import Action.*;

import java.util.ArrayList;

public abstract class EventDecorator extends Event {
    protected Event _decoratedEvent;

    public abstract String getDescription();
    public abstract String getNorthDescription();
    public abstract String getSouthDescription();
    public abstract String getWestDescription();
    public abstract String getEastDescription();
    public abstract ArrayList<GameAction> getActions();
}
