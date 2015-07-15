package com.json.generator.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomDataPicker {

    private static Map<Integer, String> source = new HashMap<>();
    private static Map<Integer, String> message = new HashMap<>();
    private static Map<Integer, String> name = new HashMap<>();

    static {
        source.put(1, "jira");
        source.put(2, "bamboo");
        source.put(3, "jira");
        source.put(4, "svn");
        message.put(1, "broke the build");
        message.put(2, "went out for coffee");
        message.put(3, "changed the story status to In-Progress");
        message.put(4, "changed the story status to Resolved");
        message.put(5, "left the office for good");
        message.put(6, "is now reviewing the story");
        name.put(1, "Justin");
        name.put(2, "Pat");
        name.put(3, "Fiona");
        name.put(4, "Omar");
        name.put(5, "Eliel");
        name.put(6, "Mat");
        name.put(7, "James");
        name.put(8, "Sriram");
    }

    public static void main(String[] args) {
        System.out.println(getNewSource());
    }

    public static String getNewSource() {
        int key = getRandomNumber(source.size());
        return source.get(key);
    }

    public static String getNewStoryId() {
        return "" + getRandomNumber(9999);
    }

    public static String getNewMessage() {
        int key = getRandomNumber(message.size());
        return message.get(key);
    }

    public static String getNewName() {
        int key = getRandomNumber(name.size());
        return name.get(key);
    }

    private static int getRandomNumber(int maxNumber) {
        Random generator = new Random();
        return maxNumber - generator.nextInt(maxNumber);
    }
}
