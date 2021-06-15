package com.kodilla.testing.statistics;

import java.util.List;

public class StatisticsPresentation {

    private Statistics statistics;

    public void calculateAdvStatistics(Statistics statistics){
        this.statistics = statistics;
    }

    public String showStatistics(){
        return "Statistic for average posts per user: " + getAveragePostsPerUser()
                + "\nStatistic for average comments per user: " + getAverageCommentsPerUser();
    }


    public List<String> getUsers() {
        return statistics.usersNames();
    }

    public int getPostsQuantity() {
        return statistics.postsCount();
    }

    public int getCommentsQuantity() {
        return statistics.commentsCount();
    }

    public double getAveragePostsPerUser() {
        return (double) statistics.postsCount()/(double) statistics.usersNames().size();
    }

    public double getAverageCommentsPerUser() {
        return (double) statistics.commentsCount()/(double) statistics.usersNames().size();
    }

    public double getAverageCommentsPerPost() {
        if (statistics.commentsCount() > statistics.postsCount())
            return statistics.commentsCount()/statistics.postsCount();
        else {
            return  (double) statistics.commentsCount()/(double)statistics.postsCount();
        }
    }
}
