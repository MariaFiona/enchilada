package com.json.generator;

import java.util.ArrayList;

import com.json.generator.bean.FeedUser;

public class FeedUserData {
	public static ArrayList<FeedUser> USERS = new ArrayList<FeedUser>();
	static{
		USERS.add(new FeedUser("Fiona","http://lorempixel.com/g/64/64/fashion"));
		USERS.add(new FeedUser("Omar","http://lorempixel.com/g/64/64/city"));
		USERS.add(new FeedUser("Justin","http://lorempixel.com/g/64/64/food"));
		USERS.add(new FeedUser("Eliel","http://lorempixel.com/g/64/64/technics"));
		USERS.add(new FeedUser("Pat","http://lorempixel.com/g/64/64/cats"));
		USERS.add(new FeedUser("Mat","http://lorempixel.com/g/64/64/nature"));
		USERS.add(new FeedUser("James","http://lorempixel.com/g/64/64/business"));
		USERS.add(new FeedUser("Sriram","http://lorempixel.com/g/64/64/abstract"));


	}
}
