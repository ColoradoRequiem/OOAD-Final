package IslandType;

import IslandType.Season;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static int readInput(){
        // https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/#:~:text=1%20Using%20Buffered%20Reader%20Class%20This%20is%20the,command%20line.%20...%204%20Using%20Command%20line%20argument
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int i = Integer.parseInt(br.readLine()); // for Integer Input
            return i;
        } catch(IOException ioe) {
            return -1;
        }

    }
}
