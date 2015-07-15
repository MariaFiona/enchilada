package com.json.generator.demo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonDataProvider {

    public static void main(String[] args) {
        JsonDataProvider provider = new JsonDataProvider();
        System.out.println(provider.generateJsonData());
    }

    public String generateJsonData() {
        List<FeedItem> feed = new ArrayList<FeedItem>();
        for (int i = 0; i < 20; i++) {
            FeedItem item = FeedFactory.getNewItem();
            feed.add(item);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<List<FeedItem>>() {
        }.getType();

        return gson.toJson(feed, type);
    }
}
