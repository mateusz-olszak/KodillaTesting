package com.kodilla.testing.forum;

import java.util.Objects;

public class ForumComment {

    private ForumPost forumPost;
    private String author;
    private String commentBody;

    public ForumComment(ForumPost forumPost, String author, String commentBody) {
        this.forumPost = forumPost;
        this.author = author;
        this.commentBody = commentBody;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getAuthor() {
        return author;
    }

    public String getCommentBody() {
        return commentBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumComment that = (ForumComment) o;
        return Objects.equals(forumPost, that.forumPost) && Objects.equals(author, that.author) && Objects.equals(commentBody, that.commentBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forumPost, author, commentBody);
    }
}
