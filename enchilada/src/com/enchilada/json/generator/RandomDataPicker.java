package com.enchilada.json.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.enchilada.json.generator.bean.FeedMessage;
import com.enchilada.json.generator.bean.FeedUser;

public class RandomDataPicker {

	private static Map<Integer, String> source = new HashMap<Integer, String>();
	private static Map<Integer, String> message = new HashMap<Integer, String>();
	private static Map<Integer, List<String>> msg = new HashMap<Integer, List<String>>();
	private static ArrayList<FeedUser> users = new ArrayList<FeedUser>();
	static{
		users.add(new FeedUser("Fiona","http://lorempixel.com/g/64/64/fashion"));
		users.add(new FeedUser("Omar","http://lorempixel.com/g/64/64/city"));
		users.add(new FeedUser("Justin","http://lorempixel.com/g/64/64/food"));
		users.add(new FeedUser("Eliel","http://lorempixel.com/g/64/64/technics"));
		users.add(new FeedUser("Pat","http://lorempixel.com/g/64/64/cats"));
		users.add(new FeedUser("Mat","http://lorempixel.com/g/64/64/nature"));
		users.add(new FeedUser("James","http://lorempixel.com/g/64/64/business"));
		users.add(new FeedUser("Sriram","http://lorempixel.com/g/64/64/abstract"));


	
		source.put(1, "jira");
		source.put(2, "bamboo");
		source.put(3, "crucible");
		source.put(4, "svn");

		message.put(1, "broke the build");
		message.put(2, "went out for coffee");
		message.put(3, "changed the story status to In-Progress");
		message.put(4, "changed the story status to Resolved");
		message.put(5, "left the office for good");
		message.put(6, "is now reviewing the story");
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

	}

	public static void main(String[] args) {
		System.out.println(getNewSource());
	}

	public static FeedUser getNewUser() {
		int key = getRandomNumber(users.size() - 1);
		return users.get(key);
	}

	public static FeedMessage getNewFeedMessage(String storyId) {
		int key = getRandomNumber(source.size());
		return new FeedMessage(source.get(key), getRandomMessage(key, storyId));
	}

	private static String getRandomMessage(int key, String storyId) {
		List<String> ran = msg.get(key);
		return format(ran.get(getRandomNumber(ran.size() - 1)), storyId);

	}

	private static String format(String string, String storyId) {

		return string.replace("{number}", Integer.toString(getRandomNumber(9999))).replace(
				"{storyId}", storyId);
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

	private static int getRandomNumber(int maxNumber) {
		Random generator = new Random();
		return maxNumber - generator.nextInt(maxNumber);
	}
}
