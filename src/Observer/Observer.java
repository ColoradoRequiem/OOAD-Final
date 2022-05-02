package Observer;

import Crew.Crew;
import Item.Item;
import Player.Player;

public interface Observer {
   void update(Item update);
   void update(Crew update);
   void update(Player update);
   void save();
}
