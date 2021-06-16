package com.kodilla.stream.forum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class ForumUserTestSuite {

    @Test
    public void testGetLocationsOfFriends(){
        ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
        ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");

        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);

        Set<String> locations = user1.getLocationOfFriends();
        Set<String> resultSet = new HashSet<>();
        resultSet.add(user3.getLocation());
        resultSet.add(user7.getLocation());
        resultSet.add(user10.getLocation());

        Assertions.assertEquals(resultSet, locations);

    }

    @Test
    public void testGetLocationsOfFriendsOfFriends(){
        ForumUser user1 = new ForumUser("alan01", "Alan Kosovsky", "Washington");
        ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
        ForumUser user4 = new ForumUser("booth", "Mya Booth", "Washington");
        ForumUser user5 = new ForumUser("nicole1987", "Nicole Lee", "Orlando");
        ForumUser user6 = new ForumUser("nobody", "Briana Williams", "Miami");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Washington");
        ForumUser user8 = new ForumUser("thebigone", "Clay Small", "Orlando");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Washington");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");

        //When
        //Create relations for user1
        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);
        //Create relations for user3
        user3.addFriend(user1);
        user3.addFriend(user7);
        user3.addFriend(user2);
        user3.addFriend(user9);
        //Create relations for user7
        user7.addFriend(user1);
        user7.addFriend(user3);


        Assertions.assertEquals(3, user1.getLocationOfFriendsOfFriends().size());
        Assertions.assertTrue(user1.getLocationOfFriendsOfFriends().contains("Key West"));
        Assertions.assertTrue(user1.getLocationOfFriendsOfFriends().contains("Washington"));
        Assertions.assertTrue(user1.getLocationOfFriendsOfFriends().contains("Miami"));
        Assertions.assertFalse(user1.getLocationOfFriendsOfFriends().contains("Orlando"));


    }

}
