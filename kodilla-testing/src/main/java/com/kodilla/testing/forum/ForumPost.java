package com.kodilla.testing.forum;

import java.util.Objects;

public class ForumPost {

    private String author;
    private String postBody;

    public ForumPost(String author, String postBody) {
        this.author = author;
        this.postBody = postBody;
    }

    public String getAuthor() {
        return author;
    }

    public String getPostBody() {
        return postBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumPost forumPost = (ForumPost) o;
        return Objects.equals(author, forumPost.author) && Objects.equals(postBody, forumPost.postBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, postBody);
    }

}
