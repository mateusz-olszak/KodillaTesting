package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum() {
        usersList.add(new ForumUser(1,"username1",'M', LocalDate.of(1990,5,10),30));
        usersList.add(new ForumUser(2,"username2",'M', LocalDate.of(1981,12,5),10));
        usersList.add(new ForumUser(3,"username3",'F', LocalDate.of(1997,1,22),15));
        usersList.add(new ForumUser(4,"username4",'M', LocalDate.of(1985,7,25),13));
        usersList.add(new ForumUser(5,"username5",'F', LocalDate.of(2002,10,15),20));
        usersList.add(new ForumUser(6,"username6",'F', LocalDate.of(1995,10,19),18));
        usersList.add(new ForumUser(7,"username7",'M', LocalDate.of(1993,11,9),0));
        usersList.add(new ForumUser(8,"username8",'M', LocalDate.of(2003,9,7),3));
    }

    public List<ForumUser> getUsersList() {
        return new ArrayList<>(usersList);
    }
}
