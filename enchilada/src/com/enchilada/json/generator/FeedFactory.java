package com.enchilada.json.generator;

import java.util.Calendar;

import com.enchilada.json.generator.bean.FeedItem;
import com.enchilada.json.generator.bean.FeedMessage;
import com.enchilada.json.generator.bean.FeedUser;

public class FeedFactory {

	public static FeedItem getNewItem() {
		FeedItem item = new FeedItem();
		FeedUser user = RandomDataPicker.getNewUser();
		String storyId = RandomDataPicker.getNewStoryId();

		FeedMessage message = RandomDataPicker.getNewFeedMessage(storyId);

		String context = "";
		String prefix = "";

		if (message.getSource().equals("jira")) {
			context = "browse";
			prefix = "EWS-";
		} else if (message.getSource().equals("bamboo")) {
			context = "browse";
			prefix = "ECM831-EXEC-";
		} else if (message.getSource().equals("crucible")) {
			context = "cru";
			prefix = "ECM83-";
		}else if (message.getSource().equals("svn")) {
			context = "repos";
			prefix = "EWS-";
		}


		String sourceLink = "http://" + message.getSource() + ".objective.com/" + context + "/"
				+ prefix + storyId;
		if (message.getSource().equals("svn")) {
			sourceLink = "";
		}

		item.setSource(message.getSource());
		item.setSourceLink(sourceLink);
		item.setUserStoryId("EWS-"+storyId);
		item.setDate(Calendar.getInstance().getTime());
		item.setMessage(user.getName() + " " + message.getMessage());
		item.setName(user.getName());
		item.setAvatar(user.getAvatar());
		return item;
	}

}
