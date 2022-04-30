package Crew;

import Item.*;
import com.company.Utils;

import java.util.ArrayList;

public class Crew extends Utils {
    public String _race;
    public String _sex;
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
        _race = Utils.getRandomLine("\\src\\Crew\\commonRaces");
        _sex = Utils.randomSex();
        _name = Utils.getRandomLine("\\src\\Crew\\"+_race.toLowerCase()+_sex+"Names");
        _personality = Utils.getRandomLine("\\src\\Crew\\commonPersonalities");
        _job = Utils.getRandomLine("\\src\\Crew\\commonJobs");

        for (int i=0; i<6; i++) {
            _attr.add(random(-2,3));
        }

        _held = null;
        _worn = null;
    }

    public String getJob() {return _job;}
    public int getAttr(String attr) {
        switch (attr) { // STR CON DEX CHA WIS INT
            case "STR":
                return _attr.get(0);
            case "CON":
                return _attr.get(1);
            case "DEX":
                return _attr.get(2);
            case "CHA":
                return _attr.get(3);
            case "WIS":
                return _attr.get(4);
            case "INT":
                return _attr.get(5);
            default:
                return -1;
        }
    }
    public Item getRightHandItem() {
        return _rightHand;
    }
    public Item getLeftHandItem() {
        return _leftHand;
    }
}
