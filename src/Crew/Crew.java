package Crew;

import IslandType.Utils;
import Item.*;

import java.util.ArrayList;

public class Crew extends Utils {
    private String _name;
    private ArrayList<Integer> _attr = new ArrayList<Integer>(); // STR CON DEX CHA WIS INT

    private String _personality;
    private String _job;

    private Item _rightHand;
    private Item _leftHand;

    private ArrayList<Item> _held;
    private ArrayList<Item> _worn;
    private int _maxCapacity = 5;

    public Crew() {
        _name = "random"; // need to implement random choice from list
        for (int i=0; i<6; i++) {
            _attr.add(random(8,18));
        }
        _personality = "Neutral";
        _job = null;

        _held = null;
        _worn = null;
    }

    public String getJob() {return _job;}
    public String getName(){return _name;}
}
