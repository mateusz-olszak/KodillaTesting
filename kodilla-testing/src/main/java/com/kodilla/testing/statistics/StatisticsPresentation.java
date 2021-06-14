package com.kodilla.testing.statistics;

import java.util.ArrayList;
import java.util.List;

public class StatisticsPresentation {

    private List<String> users = new ArrayList<>();
    private int postsQuantity;
    private int commentsQuantity;

    public void calculateAdvStatistics(Statistics statistics){
        for (String username : statistics.usersNames()){
            users.add(username);
        }

        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();
    }

    public String showStatistics(){
        return "Statistic for average posts per user: " + getAveragePostsPerUser()
                + "\nStatistic for average comments per user: " + getAverageCommentsPerUser();
    }


    public List<String> getUsers() {
        return users;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    public int getCommentsQuantity() {
        return commentsQuantity;
    }

    public double getAveragePostsPerUser() {
        return (double) postsQuantity/(double) users.size();
    }

    public double getAverageCommentsPerUser() {
        return (double) commentsQuantity/(double) users.size();
    }

    public double getAverageCommentsPerPost() {
        if (commentsQuantity > postsQuantity)
            return commentsQuantity/postsQuantity;
        else {
            return  (double) commentsQuantity/(double)postsQuantity;
        }
    }
}
