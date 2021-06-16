package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDiretory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.person.People;
import com.kodilla.stream.world.Country;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        ///################################## Module 7.1:
//        taskModule7_1();


        ///################################## Module 7.3:
//        taskModule7_3();

    }
    public static void taskModule7_1(){
        String text = "This is my examplary sentence.";

        PoemBeautifier.beautify(text, decorator -> "ABC | "
                + text.toUpperCase()
                .replaceAll("[E ]","*")
                .split("X")[0] + "\n"                                       ///Module 7.1
                + text.toUpperCase().replaceAll("[E ]","*")
                .split("X")[1] + " | ABC" + "!!!");
    }
    public static void taskModule7_3(){
        Forum forum = new Forum();
        Map<Integer, ForumUser> users = forum.getUsersList()
                .stream().filter(sex -> sex.getSex() == 'M')
                .filter(age -> age.getDateOfBirth().getYear() < 2001)
                .filter(post -> post.getPublicatedPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        users.entrySet().stream().map(user -> user.getKey() + ": " + user.getValue())
                .forEach(System.out::println);
    }
}
