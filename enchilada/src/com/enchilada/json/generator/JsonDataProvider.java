package com.enchilada.json.generator;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.enchilada.json.generator.bean.FeedItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonDataProvider {

    public String generateJson() {
        List<FeedItem> feed = new ArrayList<FeedItem>();
        FeedItem item = FeedFactory.newItem();
            feed.add(item);

        Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        Type type = new TypeToken<List<FeedItem>>() {
        }.getType();

        return gson.toJson(feed, type);
    }
    
    public static void main(String[] args) {
        JsonDataProvider provider = new JsonDataProvider();
        System.out.println(provider.generateJson());
    }
}
