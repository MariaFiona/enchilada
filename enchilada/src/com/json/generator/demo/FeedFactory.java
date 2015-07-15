package com.json.generator.demo;

import java.util.Calendar;

public class FeedFactory {

    public static FeedItem getNewItem() {
        FeedItem item = new FeedItem();
        String storyId = RandomDataPicker.getNewStoryId();
        String name = RandomDataPicker.getNewName();
        String sourceId = RandomDataPicker.getNewSource();

        String context = "";
        String prefix = "";

        if (sourceId.equals("jira")) {
            context = "browse";
            prefix = "EWS-";
        } else if (sourceId.equals("bamboo")) {
            context = "browse";
            prefix = "ECM831-EXEC-";
        } else if (sourceId.equals("crucible")) {
            context = "cru";
            prefix = "ECM83-";
        }

        String sourceLink = "http://" + sourceId + ".objective.com/" + context + "/" + prefix + storyId;
        if (sourceId.equals("svn")) {
            sourceLink = "";
        }

        item.setSource(sourceId);
        item.setSourceLink(sourceLink);
        item.setUserStoryId(storyId);
        item.setDate(Calendar.getInstance().getTime());
        item.setMessage(name + " " + RandomDataPicker.getNewMessage());
        item.setName(name);
        item.setAvatar("http://link.to.avatar/" + name);
        return item;
    }

}
