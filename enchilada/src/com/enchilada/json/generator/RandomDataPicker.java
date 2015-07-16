package com.enchilada.json.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.enchilada.json.generator.bean.FeedMessage;
import com.enchilada.json.generator.bean.FeedUser;

public class RandomDataPicker {

    private static Map<Integer, String> dataSources = new HashMap<>();
    private static Map<Integer, String> messages = new HashMap<>();
	private static Map<Integer, List<String>> msg = new HashMap<Integer, List<String>>();
	private static ArrayList<FeedUser> users = new ArrayList<FeedUser>();
	private static Map<Integer, String> names = new HashMap<>();
	private List<String> namesAvailable = new ArrayList<>();

	static{
		users.add(new FeedUser("Fiona","http://lorempixel.com/g/64/64/fashion"));
		users.add(new FeedUser("Omar","http://lorempixel.com/g/64/64/city"));
		users.add(new FeedUser("Justin","http://lorempixel.com/g/64/64/food"));
		users.add(new FeedUser("Eliel","http://lorempixel.com/g/64/64/technics"));
		users.add(new FeedUser("Pat","http://lorempixel.com/g/64/64/cats"));
		users.add(new FeedUser("Mat","http://lorempixel.com/g/64/64/nature"));
		users.add(new FeedUser("James","http://lorempixel.com/g/64/64/business"));
		users.add(new FeedUser("Sriram","http://lorempixel.com/g/64/64/abstract"));
		msg.put(1,
				new ArrayList<String>(Arrays.asList("set subtask EWS-{number} to done",
						"logged 3 hours on subtask EWS-{number}",
						"set subtask EWS-{number} to in-progress")));

		msg.put(2,
				new ArrayList<String>(
						Arrays.asList(
								"has successfully built ECM 8.3.x Executive #{number}",
								"has been automatically assigned to build failure ECM 8.3.x Executive #{number}",
								"has been automatically assigned to build failure ECM 8.3.x Common #{number}",
								"has successfully built ECM 8.3.x Common #{number}")));
		msg.put(3,
				new ArrayList<String>(Arrays.asList(
						"has commented on the review: This is totally wrong, fix it.",
						"has commented on the review: I like this implementation!",
						"has commented on the review: Refactor this.")));
		msg.put(4,
				new ArrayList<String>(Arrays.asList(
						"committed 4 files with message: EWS-{storyId} added javadocs",
						"committed 5 files with message: EWS-{storyId} added ref to response",
						"committed 1 file with message: EWS-{storyId} created new service")));
        // sources
        dataSources.put(1, "JIRA");
        dataSources.put(2, "Bamboo");
        dataSources.put(3, "Crucible");
        dataSources.put(4, "SVN");
        dataSources.put(5, "Bamboo"); // repeat for higher probability

        // JIRA messages
        messages.put(1, "added a worklog on subtask EWS-1586");
        messages.put(2, "added a comment: For every GET request? What if the client makes a bunch of requests "
                        + "to cache data, or just to display the object in a list or object picker control or "
                        + "something? Would log a lot of false audit events. ");
        messages.put(3, "added a worklog on subtask EWS-1586 2h logged, Remaining Time Estimate changed from 2h to 0");
        messages.put(4, "updated EWS-1980 Re: Manual testing 2 Tested Audit Trail");
        messages.put(5, "left the office for good");

        // Bamboo messages
        messages.put(6, "ECM 8.3.x Executive #1074 was SUCCESSFUL (with 1433 tests). Change made by ");
        messages.put(7, "ECM 8.3.x Executive #669 has FAILED. Change made by ");
        messages.put(8, "ECM 8.3.x Common #215 has FAILED (1 tests failed, no failures were new). Change made by ");
        messages.put(9, "ECM 8.3.x Executive #613 has FAILED. Changes made by ");
        messages.put(10, "ECM 8.3.x Executive #777 has FAILED. Shame on you ");

        // Crucible messages
        messages.put(11, "Do the xml/json annotations do anything when using form params?");
        messages.put(12, "State changed to Review: (ECM83-393) Edit new Version");
        messages.put(13, "Missing the referrer from being set. This is based on the requirement.");
        messages.put(14, "Fixed. This is actually a good catch. It turned out that getParentDto does NOT handle this yet.");
        messages.put(15, "This code is trash");

        // SVN messages
        messages.put(16, "Created service for retrieving approval spec, and added approval spec ref to document response");
        messages.put(17, "Fix where 403 is expected instead of 404");
        messages.put(18, "Peer review changes; added test for user who can edit but can't open");
        messages.put(19, "I just want to mess things up");
        messages.put(20, "I am counting on you Bamboo. Do not fail me");

        // Developers
        names.put(1, "Justin Luciano");
        names.put(2, "Patricia Utanes");
        names.put(3, "Fiona Morella");
        names.put(4, "Omar Bacani");
        names.put(5, "Eliel Goco");
        names.put(6, "Mathew Fenech");
        names.put(7, "James Robson");
        names.put(8, "Sriram Ananthram");
    }

    public RandomDataPicker() {
        for (String value : names.values()) {
            namesAvailable.add(value);
        }
    }

	public static FeedUser getNewUser() {
		int key = getRandomNumber(0, users.size() - 1);
		return users.get(key);
	}

	public static FeedMessage getNewFeedMessage(String storyId) {
		int key = getRandomNumber(1, dataSources.size());
		return new FeedMessage(dataSources.get(key), getRandomMessage(key, storyId));
	}

	private static String getRandomMessage(int key, String storyId) {
		List<String> ran = msg.get(Math.min(key, msg.size()));
		return format(ran.get(getRandomNumber(0, ran.size() - 1)), storyId);

	}

	public static void main(String[] args) {
		System.out.println(RandomDataPicker.getNewFeedMessage("EWS-1234"));
	}
	
	private static String format(String string, String storyId) {
		return string.replace("{number}", Integer.toString(getRandomNumber(1222, 1238))).replace(
				"{storyId}", storyId);
	}

    public static String getNewSource() {
        int key = getRandomNumber(1, dataSources.size());
        return dataSources.get(key);
    }

    public static String getNewStoryId() {
        return "" + getRandomNumber(1217, 1222);
    }

    public static String getNewMessage(int rangeStart, int rangeEnd) {
        int key = getRandomNumber(rangeStart, rangeEnd);
        return messages.get(key);
    }

    public static String getNewName() {
        int key = getRandomNumber(1, names.size());
        return names.get(key);
    }

    public String getDislikes() {
        StringBuilder nameList = new StringBuilder();
        int howMany = getRandomNumber(0, namesAvailable.size()); // how many dislikes

        for (int i = 0; i < howMany; i++) {
            int pos = getRandomNumber(1, namesAvailable.size());
            if (!nameList.toString().contains(namesAvailable.get(pos - 1))) {
                nameList.append(namesAvailable.get(pos - 1)).append(",");
                namesAvailable.remove(pos - 1);
            }
        }

        if (nameList.length() > 0 && nameList.charAt(nameList.length() - 1) == ',') {
            nameList.deleteCharAt(nameList.length() - 1);
        }
        return nameList.toString();
    }

    public String getLikes() {
        return getDislikes();
    }

    private static int getRandomNumber(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
