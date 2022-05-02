package Item;

import Crew.*;

import Action.*;
import java.util.ArrayList;

public abstract class Item {
    protected String _name;
    protected String _stat;
    protected ArrayList<String> _attr = new ArrayList<String>();

    public String getName() {return _name;}
    public ArrayList<String> getAttr() {return _attr;}
    public String getStat() {return _stat;}
}

abstract class Weapon extends Item { // might build economy off this
    protected int _baseAtk;

    public int getAtk(Crew c) { // Who's wielding it changes atk value
        return _baseAtk + c.getAttr(_stat);
    }
}



class Clothing extends Item { // might build economy off this
    private int _baseDef;

    public int getDef(Crew c) { // Who's wielding it changes atk value
        return _baseDef + c.getAttr(_stat);
    }
}
