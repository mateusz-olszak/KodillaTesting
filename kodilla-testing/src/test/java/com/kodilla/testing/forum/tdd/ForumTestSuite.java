package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests(){
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestPosts {

        @Test
        void testAddPost() {
            ForumPost forumPost = new ForumPost("mati", "Have a good day people");
            ForumUser forumUser = new ForumUser("mati", "Mateusz Olszak");
            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        @Test
        void testGetPost(){
            ForumPost forumPost = new ForumPost("mati", "Have a good day people");
            ForumUser forumUser = new ForumUser("mati", "Mateusz Olszak");

            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

            Assertions.assertEquals(forumPost, forumUser.getPost(0));

        }

        @Test
        void testRemovePostNotExisting(){
            ForumUser forumUser = new ForumUser("mati", "Mateusz Olszak");
            ForumPost forumPost = new ForumPost("mati", "Have a good day people");

            boolean removePost = forumUser.removePost(forumPost);

            Assertions.assertFalse(removePost);

        }

        @Test
        void testRemovePost(){
            ForumUser forumUser = new ForumUser("mati", "Mateusz Olszak");
            ForumPost forumPost = new ForumPost("mati", "Have a good day people");
            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());

            boolean removePost = forumUser.removePost(forumPost);

            Assertions.assertTrue(removePost);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for comments")
    class CommentsTest{
        @Test
        void testAddComment(){
            ForumPost forumPost = new ForumPost("mati", "Have a good day people");
            ForumUser forumUser = new ForumUser("mati", "Mateusz Olszak");
            ForumComment forumComment = new ForumComment(forumPost, "xxx", "funny!");

            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

            Assertions.assertEquals(1, forumUser.getCommentsQuantity());

        }

        @Test
        void testGetComment(){
            ForumUser forumUser = new ForumUser("mati", "Mateusz Olszak");
            ForumPost forumPost = new ForumPost("mati", "Have a good day people");
            ForumComment forumComment = new ForumComment(forumPost, "xxx", "funny!");

            forumUser.addComment(forumPost, forumComment.getAuthor(),forumComment.getCommentBody());

            Assertions.assertEquals(forumComment, forumUser.getComment(0));
        }

        @Test
        void testRemoveCommentNotExisting(){
            ForumUser forumUser = new ForumUser("mati", "Mateusz Olszak");
            ForumPost forumPost = new ForumPost("mati", "Have a good day people");
            ForumComment forumComment = new ForumComment(forumPost, "xxx", "funny!");

            boolean removeComment = forumUser.removeComment(forumComment);

            Assertions.assertFalse(removeComment);
        }

        @Test
        void testRemoveComment(){
            ForumUser forumUser = new ForumUser("mati", "Mateusz Olszak");
            ForumPost forumPost = new ForumPost("mati", "Have a good day people");
            ForumComment forumComment = new ForumComment(forumPost, "xxx", "funny!");
            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());

            boolean removeComment = forumUser.removeComment(forumComment);

            Assertions.assertTrue(removeComment);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());

        }
    }

}
