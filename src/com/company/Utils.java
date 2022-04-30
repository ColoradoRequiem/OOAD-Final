package com.company;

import IslandType.Season;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




import java.io.File;
import java.io.FileInputStream;

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

    } // User input
    public static int getNumLines(String path) {
        String filePath = System.getProperty("user.dir") + path;
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] byteArray = new byte[(int)file.length()];
            fis.read(byteArray);
            String data = new String(byteArray);
            String[] stringArray = data.split("\r\n");
            return stringArray.length-1;
        } catch(IOException ioe) {
            return -1;
        }
    }
    public static String getRandomLine(String path) {
        try {
            int max = getNumLines(path);
            int r = random(0,max);
            String specific_line_text = Files.readAllLines(Paths.get(System.getProperty("user.dir") + path)).get(r);
            return specific_line_text;
        } catch(IOException ioe) {
            return null;
        }
    }

    public static String randomSex() {
        int s = random(0,1);
        if (s==1) {
            return "Male";
        }
        else {
            return "Female";
        }
    }


}
