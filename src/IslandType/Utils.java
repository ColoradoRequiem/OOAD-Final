package IslandType;

import IslandType.Season;

import java.util.Random;

public class Utils {
    public static double random() {
        Random rand = new Random();
        return rand.nextDouble();
    }
    public static int random(int min, int max) { // inclusive
        Random rand = new Random();
        return rand.nextInt(max+1-min)+min;
    }
    public static Season getSeason(int i) {
        return switch (i) {
            case 0 -> Season.FALL;
            case 1 -> Season.SPRING;
            case 2 -> Season.SUMMER;
            case 3 -> Season.WINTER;
            default -> null;
        };
    }
    public static Season randSeason() {
        return getSeason(random(0,3));
    }
    public static void out(String s) {
        System.out.println(s);
    }
}
