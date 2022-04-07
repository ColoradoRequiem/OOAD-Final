package Requirement;

import Player.*;
public class NameRequirement implements Requirement {
    public boolean getValue(Player p) {
        if (p.getName().equals("Admin")) {return true;}
        return false;
    }
}
