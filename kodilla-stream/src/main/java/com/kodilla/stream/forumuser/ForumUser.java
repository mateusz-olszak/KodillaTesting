package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int id;
    private final String username;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int publicatedPosts;

    public ForumUser(final int id,final String username,final char sex,final LocalDate dateOfBirth,final int publicatedPosts) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.publicatedPosts = publicatedPosts;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPublicatedPosts() {
        return publicatedPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", publicatedPosts=" + publicatedPosts +
                '}';
    }
}
